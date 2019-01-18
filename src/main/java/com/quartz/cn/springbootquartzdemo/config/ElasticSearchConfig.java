package com.quartz.cn.springbootquartzdemo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * es配置
 */
@Configuration
public class ElasticSearchConfig {

    @Value("${elasticsearch.host}")
    private String esHost;

    @Value("${elasticsearch.port}")
    private int esPort;

    @Value("${elasticsearch.cluster.name}")
    private String esName;

    @Bean
    public TransportClient esClient() throws UnknownHostException {
        TransportClient client = null;
        try {
            Settings settings = Settings.builder()
                    .put("client.transport.sniff", true)
                    .put("cluster.name", this.esName)
                    .build();

            InetSocketTransportAddress master = new InetSocketTransportAddress(InetAddress.getByName(esHost), esPort);

            client = new PreBuiltTransportClient(settings).addTransportAddress(master);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return client;
    }
}
