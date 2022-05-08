package com.moon.springboot.caching.service;

import com.moon.springboot.caching.domain.SMSCode;

/**
 * 短信验证码业务层接口
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-29 11:18
 * @description
 */
public interface SMSCodeService {
    /**
     * 获取短信验证码
     *
     * @param tele
     * @return
     */
    String sendSMSCode(String tele);

    /**
     * 校验短信验证码
     *
     * @param smsCode
     * @return
     */
    boolean checkCode(SMSCode smsCode);

}
