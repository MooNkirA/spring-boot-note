package com.moon.springboot.caching.service;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.moon.springboot.caching.domain.SMSCode;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

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

    /*
     *  Cache 类是 jetCache 的缓存对象
     *  @CreateCache 注解用于配置当前缓存对象的信息
     *      area 属性：设置选择配置文件中哪个缓存方案，默认值是 default
     *      name 属性：设置缓存键的前缀
     *      expire 属性：设置缓存的过期时间，默认单位是秒
     *      timeUnit 属性：设置过期时间的单位，默认值是秒，即 TimeUnit.SECONDS
     */
    // @CreateCache(area = "default", name = "jetCache_", expire = 10, timeUnit = TimeUnit.SECONDS)
    // cacheType 属性用于指定使用远程缓存还是本地缓存，默认是远程缓存(CacheType.REMOTE)
    // @CreateCache(area = "default", name = "jetCache_", expire = 10, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.LOCAL)
    // cacheType = CacheType.BOTH 配置同时使用本地缓存和远程缓存
    @CreateCache(area = "default", name = "jetCache_", expire = 10, timeUnit = TimeUnit.SECONDS, cacheType = CacheType.BOTH)
    private Cache<String, String> jetCache;
    // 可以创建多套不同的缓存方案，其中 area 属性指定使用的缓存方案名称即可
    @CreateCache(area = "sms", name = "jetCache_", expire = 2, timeUnit = TimeUnit.MINUTES)
    private Cache<String, String> smsCache;

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
        // 使用 Cache 类的 put 方法，将数据加入缓存
        jetCache.put(tel, code);
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
        // 使用 Cache 类的 get 方法，根据键从缓存获取数据
        String codeCache = jetCache.get(smsCode.getTel());
        return code.equals(codeCache);
    }

    private final String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};

    /**
     * 简单的实现生成验证码
     *
     * @param tel
     * @return
     */
    private String generateGode(String tel) {
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
