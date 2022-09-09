package com.tool.service;

import com.tool.autoconfigure.IpCountProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * IP 统计实现
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-05-10 17:03
 * @description
 */
public class IpCountServiceImpl implements IpCountService {

    private final Map<String, Integer> ipCounter = new HashMap<>();

    // 当前的 HttpServletRequest 对象的注入工作由使用当前 starter 的工程提供自动装配
    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private IpCountProperties ipCountProperties;

    /**
     * 统计
     */
    @Override
    public void count() {
        // 1.获取当前操作的IP地址
        String ip = httpServletRequest.getRemoteAddr();
        // 2.根据IP地址从Map取值，并递增
        Integer count = ipCounter.get(ip);
        ipCounter.put(ip, count == null ? 1 : count + 1);
    }

    /**
     * 输出统计数据
     */
    @Scheduled(cron = "0/#{ipCountProperties.cycle} * * * * ?")
    @Override
    public void print() {
        String model = ipCountProperties.getModel();
        if (IpCountProperties.LogModel.DETAIL.getValue().equals(model)) {
            // 日志输出详细模式
            System.out.println("         IP访问监控");
            System.out.println("+-----ip-address-----+--num--+");
            for (Map.Entry<String, Integer> entry : ipCounter.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                System.out.println(String.format("|%18s  |%5d  |", key, value));
            }
            System.out.println("+--------------------+-------+");
        } else if (IpCountProperties.LogModel.SIMPLE.getValue().equals(model)) {
            // 日志输出极简模式
            System.out.println("     IP访问监控");
            System.out.println("+-----ip-address-----+");
            for (String key : ipCounter.keySet()) {
                System.out.println(String.format("|%18s  |", key));
            }
            System.out.println("+--------------------+");
        }

        // 判断是否周期内重置数据
        if (ipCountProperties.getCycleReset()) {
            ipCounter.clear();
        }
    }

}
