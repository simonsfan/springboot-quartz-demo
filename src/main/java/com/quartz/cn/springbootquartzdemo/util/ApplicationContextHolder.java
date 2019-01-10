package com.quartz.cn.springbootquartzdemo.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 类描述：获取Spring代理类（上下文）
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationcontext)
            throws BeansException {
        ApplicationContextHolder.context = applicationcontext;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }
}
