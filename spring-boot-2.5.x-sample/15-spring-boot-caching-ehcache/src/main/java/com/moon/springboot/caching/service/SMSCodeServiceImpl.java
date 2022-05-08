package com.moon.springboot.caching.service;

import com.moon.springboot.caching.domain.SMSCode;
import com.moon.springboot.caching.utils.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
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
    private CodeUtil codeUtil;

    /**
     * 获取短信验证码
     *
     * @param tel
     * @return
     */
    // @CachePut 注解标识的方法仅具有向缓存中保存数据的功能，返回时并不会从缓存取值
    @CachePut(value = "smsCodeCache", key = "#tel")
    @Override
    public String sendSMSCode(String tel) {
        // 生成验证码并返回，注：只会保存到缓存中，再次调用时并不会从缓存中读取
        return codeUtil.generateGode(tel);
    }

    /**
     * 校验短信验证码
     *
     * @param smsCode
     * @return
     */
    @Override
    public boolean checkCode(SMSCode smsCode) {
        // 取出缓存中的验证码与接收的验证码比对，如果相同，返回true
        String code = smsCode.getCode();
        String codeCache = codeUtil.getCodeCache(smsCode.getTel());
        return code.equals(codeCache);
    }

}
