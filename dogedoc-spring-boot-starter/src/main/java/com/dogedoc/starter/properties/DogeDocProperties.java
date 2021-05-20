package com.dogedoc.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhengfa
 * @date 2021年03月30日 14:41:00
 * @description
 */
@Component
@ConfigurationProperties(prefix = "dogedoc")
public class DogeDocProperties {



}
