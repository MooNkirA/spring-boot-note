package com.moon.springboot.caching.domain;

import lombok.Data;

/**
 * 验证码实体类
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-29 11:13
 * @description
 */
@Data
public class SMSCode {

    private String tel;
    private String code;

}
