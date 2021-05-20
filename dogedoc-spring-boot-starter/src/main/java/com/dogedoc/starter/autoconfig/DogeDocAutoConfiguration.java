package com.dogedoc.starter.autoconfig;

import com.dogedoc.core.config.DogeDocConfig;
import com.dogedoc.starter.properties.DogeDocProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zhengfa
 * @date 2021年05月19日 11:36:00
 * @description
 */
@Configuration
@Import(DogeDocConfig.class)
@EnableConfigurationProperties(DogeDocProperties.class)
public class DogeDocAutoConfiguration {

    @Autowired
    private DogeDocProperties dogedocProperties;

}
