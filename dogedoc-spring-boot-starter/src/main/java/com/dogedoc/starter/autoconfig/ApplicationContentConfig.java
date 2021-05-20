package com.dogedoc.starter.autoconfig;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author zhengfa
 * @date 2021年04月19日 11:02:00
 * @description
 */
@Configuration
public class ApplicationContentConfig implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContentConfig.applicationContext = applicationContext;
    }

    public static Environment getEnvironment(){
        return ApplicationContentConfig.applicationContext.getEnvironment();
    }

}
