package com.moon.springboot.configuration.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.moon.springboot.configuration.bean.CatBean;
import com.moon.springboot.configuration.bean.CompanyBean;
import com.moon.springboot.configuration.bean.ValueBean;
import com.moon.springboot.configuration.config.ServerConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

/**
 * 配置文件绑定值测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-17 16:32
 * @description
 */
@SpringBootTest
public class InjectedConfigTest {

    @Autowired
    private ValueBean valueBean;

    @Autowired
    private Environment environment;

    @Autowired
    private CompanyBean companyBean;

    @Autowired
    private CatBean catBean;

    @Autowired
    private DruidDataSource druidDataSource;

    @Autowired
    private ServerConfig serverConfig;

    /*
     * 测试使用 @Value 注入配置值
     */
    @Test
    public void testInjectedByValueAnnotation() {
        System.out.println(valueBean);
    }

    // 通过 Environment 对象读取配置文件
    @Test
    public void testReadByEnvironment() {
        Map<String, Object> map = new HashMap<>();
        // 读取普通类型
        String name = environment.getProperty("name");
        map.put("name", name);
        // 读取数组，第2个元素
        String city = environment.getProperty("city[1]");
        map.put("city", city);
        // 读取对象类型数组，第3个对象元素的 score 属性
        String score = environment.getProperty("student[2].score");
        map.put("score", score);
        // 读取复杂对象类型，subject 属性数组的第1个元素
        String subject = environment.getProperty("company.subject[0]");
        map.put("subject", subject);
        // 一样可以读取 properties 文件的属性值
        String port = environment.getProperty("custom.port");
        map.put("port", port);

        System.out.println(map);
    }

    // 通过 @ConfigurationProperties 注解方式进行配置与实体映射
    @Test
    public void testInjectedByConfigurationProperties() {
        System.out.println(companyBean);
    }

    // 通过 @PropertySource 导入自定义 propertiees 配置，并使用 @ConfigurationPropertiesBean 注解方式进行配置与实体映射读取
    @Test
    public void testInjectedByConfigurationPropertiesWithPropertySource() {
        System.out.println(catBean);
    }

    // 通过 @ConfigurationProperties 注解方式，对第三方 jar 包对象进行配置属性值注入
    @Test
    public void testInjectedThirdPartyByConfigurationProperties() {
        System.out.println("注入 druid 数据源 driverClassName: " + druidDataSource.getDriverClassName());
        System.out.println("注入 druid 数据源 password: " + druidDataSource.getPassword());
    }

    // 通过 @ConfigurationProperties 注解宽松绑定配置属性值
    @Test
    public void testConfigurationPropertiesLooselyBound() {
        System.out.println("宽松绑定属性 ipAddress: " + serverConfig.getIpAddress());
    }

    // 测试常用计量单位绑定
    @Test
    public void testCommonUnitMeasureBinding() {
        System.out.println("常用计量单位绑定属性 serverTimeOut: " + serverConfig.getServerTimeOut());
        System.out.println("常用计量单位绑定属性 ipAddredataSizess: " + serverConfig.getDataSize());
    }


}
