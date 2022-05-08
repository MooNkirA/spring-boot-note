package com.moon.springboot.admin.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * 示例业务
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-07 13:59
 * @description
 */
@Service
public class DemoServiceImpl implements DemoService {

    private final Counter counter;

    /* 定义有参构造，方法形参是 MeterRegistry 类型，此对象实例会进行自动注入 */
    public DemoServiceImpl(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("接口被查询的次数：");
    }

    @Override
    public String query() {
        // 方法每次被执行，都进行自增记录
        counter.increment();
        return String.valueOf(new Random().nextInt());
    }

}
