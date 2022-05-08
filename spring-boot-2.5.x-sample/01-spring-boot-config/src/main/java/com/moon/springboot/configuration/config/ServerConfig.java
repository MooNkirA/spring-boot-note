package com.moon.springboot.configuration.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * 宽松绑定 与 常用计量单位绑定 测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-17 17:20
 * @description
 */
@Data
@ConfigurationProperties("servers")
public class ServerConfig {

    private String ipAddress;
    // Duration 时间类型，@DurationUnit 指定单位为 hour
    @DurationUnit(ChronoUnit.HOURS)
    private Duration serverTimeOut;
    // DataSize 数据大小类型，@DataSizeUnit 指定单位为 MB
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;
}
