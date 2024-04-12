package com.moon.springboot.routingdatasource.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * 数据库配置映射类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-02-15 13:10
 * @description
 */
@ConfigurationProperties(prefix = "app.datasource")  //  配置前缀
public class MasterSlaveDataSourceProperties {

    // 主库
    private final Properties master;

    // 从库
    private final Map<String, Properties> slave;

    @ConstructorBinding // 通过构造函数注入配置文件中的值
    public MasterSlaveDataSourceProperties(Properties master, Map<String, Properties> slave) {
        super();
        Objects.requireNonNull(master);
        Objects.requireNonNull(slave);
        this.master = master;
        this.slave = slave;
    }

    public Properties master() {
        return master;
    }

    public Map<String, Properties> slave() {
        return slave;
    }

}
