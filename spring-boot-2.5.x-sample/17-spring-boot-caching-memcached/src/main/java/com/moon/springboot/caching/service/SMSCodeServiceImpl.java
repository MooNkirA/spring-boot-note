package com.moon.springboot.caching.service;

import com.moon.springboot.caching.domain.SMSCode;
import net.rubyeye.xmemcached.MemcachedClient;
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

    @Autowired
    private MemcachedClient memcachedClient;

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
        try {
            /*
             * 通过 set 方法，将验证保存到缓存中
             *  set(final String key, final int exp, final Object value)
             *      key 参数：保存在缓存中键名称
             *      exp 参数：缓存中过期时间，单位：秒
             *      value 参数：保存的值
             */
            memcachedClient.set(tel, 10, code);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        String codeCache = null;
        try {
            // 根据键获取缓存中的验证码
            codeCache = memcachedClient.get(smsCode.getTel());
        } catch (Exception e) {
            e.printStackTrace();
        }
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
