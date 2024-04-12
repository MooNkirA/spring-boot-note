package com.moon.springboot.routingdatasource.test;

import com.moon.springboot.routingdatasource.service.TestService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 多数据源测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-02-15 13:54
 * @description
 */
@SpringBootTest
public class MultiDatasourceTest {

    private static final Logger log = LoggerFactory.getLogger(MultiDatasourceTest.class);

    @Autowired
    private TestService testService;

    @Test
    public void testBasic() throws Exception {
        // 连续4次读
        log.info("read={}", this.testService.read());
        log.info("read={}", this.testService.read());
        log.info("read={}", this.testService.read());
        log.info("read={}", this.testService.read());
        // 写
        log.info("write={}", this.testService.write());
    }

}
