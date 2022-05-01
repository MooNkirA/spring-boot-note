package com.moon.springboot.caching.config;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * Memcached 的 Xmemcached 相关配置
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-30 16:12
 * @description
 */
@Configuration
public class XMemcachedConfig {

    // 注入配置文件映射类
    @Autowired
    private XMemcachedProperties memcachedProperties;

    /**
     * 创建 Memcached 客户端实例 MemcachedClient
     *
     * @return
     * @throws IOException
     */
    @Bean
    public MemcachedClient getMemcachedClient() throws IOException {
        // 创建 MemcachedClientBuilder，设置配置文件的节点信息
        MemcachedClientBuilder memcachedClientBuilder = new XMemcachedClientBuilder(memcachedProperties.getServers());
        memcachedClientBuilder.setConnectionPoolSize(memcachedProperties.getPoolSize());
        memcachedClientBuilder.setOpTimeout(memcachedProperties.getOpTimeout());
        return memcachedClientBuilder.build();
    }

}
