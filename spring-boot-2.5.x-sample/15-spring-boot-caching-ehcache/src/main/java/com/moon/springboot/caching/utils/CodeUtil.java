package com.moon.springboot.caching.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 验证码工具类，用于生成验证码与
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-29 14:20
 * @description
 */
@Component
public class CodeUtil {

    private final String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};

    /**
     * 简单的实现生成验证码
     *
     * @param tel
     * @return
     */
    public String generateGode(String tel) {
        int hash = tel.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

    /**
     * 从缓存中获取验证码
     *
     * @param tel
     * @return
     */
    // 此方法只需要从缓存取值，所以在方法上标识 @Cacheable 注解，方法的返回值为 null 即可
    @Cacheable(value = "smsCodeCache", key = "#tel")
    public String getCodeCache(String tel) {
        return null;
    }
}
