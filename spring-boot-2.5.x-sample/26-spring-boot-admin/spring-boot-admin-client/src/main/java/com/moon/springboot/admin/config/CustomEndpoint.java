package com.moon.springboot.admin.config;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义端点
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-07 11:36
 * @description
 */
@Configuration
/*
 * @Endpoint 注解用于标识自定义端点
 *  id 属性：设置端点在配置中的名称
 *  enableByDefault 属性：设置是否默认开放此端点，默认值是 true-默认开放
 */
@Endpoint(id = "custom-endpoint", enableByDefault = false)
public class CustomEndpoint {

    // @ReadOperation 注解标识方法，定义请求该端点时返回的信息
    @ReadOperation
    public Object getResult() {
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("level 1", "300");
        resultMap.put("level 2", "291");
        resultMap.put("level 3", "666");
        return resultMap;
    }

}
