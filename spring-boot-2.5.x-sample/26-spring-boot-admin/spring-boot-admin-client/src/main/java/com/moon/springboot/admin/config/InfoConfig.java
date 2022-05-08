package com.moon.springboot.admin.config;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Info 端点配置类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-07 11:07
 * @description
 */
@Configuration
public class InfoConfig implements InfoContributor {

    /**
     * 设置 info 端点信息
     */
    @Override
    public void contribute(Info.Builder builder) {
        // 配置单个信息
        builder.withDetail("runTime", System.currentTimeMillis());
        // 使用 Map 配置多个信息
        Map<String, Object> infoMap = new HashMap<>();
        infoMap.put("description", "我是这个应用的一段描述");
        infoMap.put("how to use", "使用说明！");
        builder.withDetails(infoMap);
    }

}
