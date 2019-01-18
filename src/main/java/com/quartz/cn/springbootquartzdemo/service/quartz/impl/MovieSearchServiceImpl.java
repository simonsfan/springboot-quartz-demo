package com.quartz.cn.springbootquartzdemo.service.quartz.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quartz.cn.springbootquartzdemo.bean.MovieSearch;
import com.quartz.cn.springbootquartzdemo.service.quartz.MovieSearchService;
import com.quartz.cn.springbootquartzdemo.util.ResultUtil;
import com.quartz.cn.springbootquartzdemo.vo.MovieIndexTemplate;
import com.quartz.cn.springbootquartzdemo.vo.MovieVo;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.ActionListener;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.get.MultiGetItemResponse;
import org.elasticsearch.action.get.MultiGetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName MovieSearchServiceImpl
 * @Description TODO
 * @Author simonsfan
 * @Date 2019/1/16
 * Version  1.0
 */
@Service
public class MovieSearchServiceImpl implements MovieSearchService {

    private static Logger logger = LoggerFactory.getLogger(MovieSearchServiceImpl.class);

    private static final String INDEX = "movie_index";
    private static final String TYPE = "info";

    @Autowired
    private TransportClient transportClient;

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 新增文档
     *
     * @param indexTemplate
     * @return
     */
    @Override
    public String addIndex(MovieIndexTemplate indexTemplate) {
        if (indexTemplate == null) {
            return ResultUtil.fail();
        }
        try {
            IndexRequestBuilder indexRequestBuilder = transportClient.prepareIndex(INDEX, TYPE).setSource(objectMapper.writeValueAsBytes(indexTemplate), XContentType.JSON);
            IndexResponse indexResponse = indexRequestBuilder.get();
            if (indexResponse.status() == RestStatus.CREATED) {
                logger.info("name={},新增文档成功", indexTemplate.getName());
                return ResultUtil.success();
            }
        } catch (JsonProcessingException e) {
            logger.error("");
        }
        return ResultUtil.fail();
    }

    @Override
    public String getIndex(String id) {
        GetResponse getResponse = transportClient.prepareGet(INDEX, TYPE, id).get();
        String result = getResponse.getSourceAsString();
        logger.info("get api result ={},", result);
        if (StringUtils.isEmpty(result)) {
            return ResultUtil.fail();
        }
        return ResultUtil.success(result);
    }

    //multi getindex
    public void getIndex2(String[] keyword) {
        MultiGetResponse multiGetItemResponse = transportClient.prepareMultiGet()
                .add(INDEX, TYPE, keyword[0])
                .add(INDEX, TYPE, keyword[1])
                .get();
        for (MultiGetItemResponse getItemResponse : multiGetItemResponse) {
            GetResponse response = getItemResponse.getResponse();
            String json = response.getSourceAsString();
        }
    }

    @Override
    public String deleteIndex(String id) {
        DeleteRequestBuilder deleteRequestBuilder = transportClient.prepareDelete(INDEX, TYPE, id);
        DeleteResponse deleteResponse = deleteRequestBuilder.get();
        if (deleteResponse.status() == RestStatus.OK) {
            logger.info("");
            return ResultUtil.success();
        }
        return ResultUtil.fail();
    }

    @Override
    public String deleteByQueryAction(String keyword) {
        BulkByScrollResponse bulkByScrollResponse = DeleteByQueryAction.INSTANCE.newRequestBuilder(transportClient).filter(QueryBuilders.matchQuery(MovieSearch.NAME, keyword)).source(INDEX).get();
        long deleted = bulkByScrollResponse.getDeleted();
        logger.info("根据条件keyword={}删除result={}", keyword, deleted);
        if (deleted < 1) {
            logger.info("根据条件keyword={}删除失败", keyword);
            return ResultUtil.fail();
        }
        logger.info("根据条件keyword={}删除成功", keyword);
        return ResultUtil.success();
    }

    //异步执行delete by query
    public void deleteByQueryAction1(String keyword) {
        DeleteByQueryAction.INSTANCE.newRequestBuilder(transportClient).filter(QueryBuilders.matchQuery(MovieSearch.NAME, keyword)).source(INDEX).execute(new ActionListener<BulkByScrollResponse>() {
            @Override
            public void onResponse(BulkByScrollResponse bulkByScrollResponse) {
                long deleted = bulkByScrollResponse.getDeleted();
                logger.info("根据条件keyword={}删除result={}", keyword, deleted);
                if (deleted < 1) {
                    logger.info("根据条件keyword={}删除失败", keyword);
                }
                logger.info("根据条件keyword={}删除成功", keyword);
            }

            @Override
            public void onFailure(Exception e) {
                // Hanlder the exception……
            }
        });
    }

    //批量bulk操作
    @Override
    public void buldOption(MovieIndexTemplate indexTemplate, String id) throws JsonProcessingException {
        BulkRequestBuilder bulkRequestBuilder = transportClient.prepareBulk();

        bulkRequestBuilder.add(transportClient.prepareDelete(INDEX, TYPE, id));

        bulkRequestBuilder.add(transportClient.prepareIndex(INDEX, TYPE).setSource(objectMapper.writeValueAsBytes(indexTemplate), XContentType.JSON));

        BulkResponse bulkItemResponses = bulkRequestBuilder.get();
        RestStatus status = bulkItemResponses.status();
        logger.info("bulk option result status={}", status);
    }


    /**
     * 复合查询
     *
     * @param search
     * @return
     */
    @Override
    public List<MovieVo> searchMovie(MovieSearch search) {
        List<MovieVo> movieVoList = new ArrayList<>();
        if (search == null) {
            return movieVoList;
        }
        String label = search.getLabel();
        String area = search.getArea();
        float score = search.getScore();
        String release = search.getRelease();

        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (StringUtils.isNotEmpty(label) && !StringUtils.equals("*", label)) {
            boolQueryBuilder.filter(QueryBuilders.termQuery(MovieSearch.LABEL, label));
        }
        if (StringUtils.isNotEmpty(area) && !StringUtils.equals("*", area)) {
            boolQueryBuilder.filter(QueryBuilders.termQuery(MovieSearch.AREA, area));
        }
        if (score > 0) {
            RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery(MovieSearch.SCORE);
            rangeQueryBuilder.gte(score);
            boolQueryBuilder.filter(rangeQueryBuilder);
        }
        if (StringUtils.isNotEmpty(release) && !StringUtils.equals("*", release)) {
            boolQueryBuilder.filter(QueryBuilders.termQuery(MovieSearch.RELEASE, release));
        }

        boolQueryBuilder.must(QueryBuilders.multiMatchQuery(search.getKeyword(),
                MovieSearch.NAME,
                MovieSearch.ACTORS,
                MovieSearch.ALIAS,
                MovieSearch.DIRECTORS,
                MovieSearch.INTRODUCTION,
                MovieSearch.AREA));

        String[] includes = {MovieSearch.NAME, MovieSearch.ALIAS, MovieSearch.SCORE, MovieSearch.ACTORS, MovieSearch.DIRECTORS, MovieSearch.INTRODUCTION};

        SearchRequestBuilder searchRequestBuilder = this.transportClient
                .prepareSearch(INDEX)
                .setTypes(TYPE)
                .setQuery(boolQueryBuilder)
                .addSort(MovieSearch.RELEASE, SortOrder.DESC).
                        setFrom(0).
                        setSize(10).
                        setFetchSource(includes, null);

        SearchResponse searchResponse = searchRequestBuilder.get();
        if (searchResponse.status() != RestStatus.OK) {
            logger.error("");
            return movieVoList;
        }
        SearchHits hits = searchResponse.getHits();
        MovieVo movieVo = new MovieVo();
        for (SearchHit hit : hits) {
            String movieName = (String) hit.getSource().get(MovieSearch.NAME);
            String movieAlias = (String) hit.getSource().get(MovieSearch.ALIAS);
            String movieActors = (String) hit.getSource().get(MovieSearch.ACTORS);
            String movieDirectors = (String) hit.getSource().get(MovieSearch.DIRECTORS);
            String movieIntroduction = (String) hit.getSource().get(MovieSearch.INTRODUCTION);
            movieVo.setName(movieName);
            movieVo.setAlias(movieAlias);
            movieVo.setActors(movieActors);
            movieVo.setDirectors(movieDirectors);
            movieVo.setIntroduction(movieIntroduction);
            movieVoList.add(movieVo);
        }
        logger.info("");
        return movieVoList;
    }


    public void queryDsl() {
        //Match Query
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(MovieSearch.NAME, "毒液");

        //Muitl Match Query
        MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery("", MovieSearch.NAME, MovieSearch.AREA, MovieSearch.INTRODUCTION, MovieSearch.ACTORS, MovieSearch.DIRECTORS);

        //Common Terms Query
        CommonTermsQueryBuilder commonTermsQueryBuilder = QueryBuilders.commonTermsQuery(MovieSearch.NAME, "毒液");

        //Query String Query
        QueryStringQueryBuilder queryStringQueryBuilder = QueryBuilders.queryStringQuery("毒液").field(MovieSearch.NAME).defaultOperator(Operator.OR);

        //Simple Query String Query
        SimpleQueryStringBuilder simpleQueryStringBuilder = QueryBuilders.simpleQueryStringQuery("毒液").field(MovieSearch.NAME);


        //Term Query
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery(MovieSearch.NAME, "毒液");

        //Terms Query
        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery(MovieSearch.NAME, "毒液", "我不是药神");

        //Range Query    筛选评分在7~10分之间的数据集，includeLower(false)表示from是gt，反之；includeUpper(false)表示to是lt，反之
        QueryBuilders.rangeQuery(MovieSearch.SCORE).from(7).to(10).includeLower(false).includeUpper(false);

    }

    public void boolDsl() {
        //Bool Query
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        //电影名称必须包含我不是药神经过分词后的文本，比如我、不、是、药、神
        boolQueryBuilder.must(QueryBuilders.matchQuery(MovieSearch.NAME, "我不是药神"));

        //排除导演是张三的电影信息
        boolQueryBuilder.mustNot(QueryBuilders.termQuery(MovieSearch.DIRECTORS, "张三"));

        //别名中应该包含药神经过分词后的文本，比如药、神
        boolQueryBuilder.should(QueryBuilders.matchQuery(MovieSearch.ALIAS, "药神"));

        //评分必须大于9（因为es对filter会有智能缓存，推荐使用）
        boolQueryBuilder.filter(QueryBuilders.rangeQuery(MovieSearch.SCORE).gt(9));

        //name、actors、introduction、alias、label 多字段匹配"药神"，或的关系
        boolQueryBuilder.filter(QueryBuilders.multiMatchQuery("药神", MovieSearch.NAME, MovieSearch.ACTORS, MovieSearch.INTRODUCTION, MovieSearch.ALIAS, MovieSearch.LABEL));

        String[] includes = {MovieSearch.NAME, MovieSearch.ALIAS, MovieSearch.SCORE, MovieSearch.ACTORS, MovieSearch.DIRECTORS, MovieSearch.INTRODUCTION};
        SearchRequestBuilder searchRequestBuilder = transportClient.prepareSearch(INDEX).setTypes(TYPE).setQuery(boolQueryBuilder).addSort(MovieSearch.SCORE, SortOrder.DESC).setFrom(0).setSize(10).setFetchSource(includes, null);
        SearchResponse searchResponse = searchRequestBuilder.get();
        if (!RestStatus.OK.equals(searchResponse.status())) {
            return;
        }
        for (SearchHit searchHit : searchResponse.getHits()) {
            String name = (String) searchHit.getSource().get(MovieSearch.NAME);
            //TODO
        }
    }


}
