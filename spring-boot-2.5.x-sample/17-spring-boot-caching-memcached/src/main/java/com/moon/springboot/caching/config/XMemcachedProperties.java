package com.moon.springboot.caching.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 读取配置文件中 Memcached 节点配置
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-30 16:10
 * @description
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "memcached")
public class XMemcachedProperties {

    private String servers;
    private int poolSize;
    private long opTimeout;

}
