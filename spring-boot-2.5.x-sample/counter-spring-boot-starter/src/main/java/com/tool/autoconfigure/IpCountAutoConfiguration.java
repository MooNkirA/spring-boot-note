package com.tool.autoconfigure;

import com.tool.service.IpCountService;
import com.tool.service.IpCountServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 自动配置类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-10 23:04
 * @description
 */
@EnableScheduling // 开启 Spring Task 定时任务
// @EnableConfigurationProperties(IpCountProperties.class)
@Import({IpCountProperties.class})
public class IpCountAutoConfiguration {

    @Bean
    public IpCountService ipCountService() {
        return new IpCountServiceImpl();
    }

}
