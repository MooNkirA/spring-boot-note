package com.moon.springboot.validator;

import com.moon.springboot.validator.config.EnableFormValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-17 21:51
 * @description
 */
@SpringBootApplication
@EnableFormValidator // 自定义是否快速返回校验结果开关
public class ValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidatorApplication.class, args);
    }

}
