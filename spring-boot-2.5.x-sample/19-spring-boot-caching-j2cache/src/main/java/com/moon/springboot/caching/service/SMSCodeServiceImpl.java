package com.moon.springboot.caching.service;

import com.moon.springboot.caching.domain.SMSCode;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 短信验证业务实现
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-29 11:27
 * @description
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    /* 注入 j2cache 缓存操作对象 CacheChannel */
    @Autowired
    private CacheChannel cacheChannel;

    /**
     * 获取短信验证码
     *
     * @param tel
     * @return
     */
    @Override
    public String sendSMSCode(String tel) {
        // 生成验证码
        String code = generateGode(tel);
        /*
         * CacheChannel 类的 set(String region, String key, Object value) 方法，将数据存入缓存
         *      region 参数：缓存键的前缀
         *      key 参数：缓存的键
         *      value 参数：缓存的值
         */
        cacheChannel.set("sms", tel, code);
        // 返回验证码
        return code;
    }

    /**
     * 校验短信验证码
     *
     * @param smsCode
     * @return
     */
    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = smsCode.getCode();
        /*
         * CacheChannel 类的 get(String region, String key, boolean...cacheNullObject) 方法，从缓存中获取数据
         * 用户无需判断返回的对象是否为空
         *      region 参数：缓存键的前缀
         *      key 参数：缓存的键
         */
        String codeCache = cacheChannel.get("sms", smsCode.getTel()).asString();
        // 取出缓存中的验证码与接收的验证码比对，如果相同，返回true
        return code.equals(codeCache);
    }

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

}
