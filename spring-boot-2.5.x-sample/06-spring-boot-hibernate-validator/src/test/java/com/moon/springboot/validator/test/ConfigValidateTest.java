package com.moon.springboot.validator.test;

import com.moon.springboot.validator.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * 配置绑定数据与类型检查测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-17 22:15
 * @description
 */
@SpringBootTest
public class ConfigValidateTest {

    @Autowired
    private ApplicationContext applicationContext;

    /*
     * 配置绑定类型测试
     */
    @Test
    public void testConfigurationPropertiesBinding() {
        Person bean = applicationContext.getBean(Person.class);
        System.out.println(bean);
    }

}
