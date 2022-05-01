package com.moon.springboot.caching.controller;

import com.moon.springboot.caching.domain.SMSCode;
import com.moon.springboot.caching.service.SMSCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 短信验证码请求控制层
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-29 14:04
 * @description
 */
@RestController
@RequestMapping("/sms")
public class SMSCodeController {

    @Autowired
    private SMSCodeService smsCodeService;

    /* 获取验证码 */
    @GetMapping
    public String getCode(String tel){
        return smsCodeService.sendSMSCode(tel);
    }

    /* 校验验证码 */
    @PostMapping
    public boolean checkCode(@RequestBody SMSCode smsCode){
        return smsCodeService.checkCode(smsCode);
    }

}
