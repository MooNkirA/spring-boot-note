package com.moon.springboot.routingdatasource.aspect;

import com.moon.springboot.routingdatasource.config.MasterSlaveDataSourceMarker;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 切面，用于标识当前操作的方法的业务读写状态
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-02-15 13:22
 * @description
 */
@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)  // 保证在事务开始之前执行
public class MasterSlaveDataSourceAspect {

    private static final Logger log = LoggerFactory.getLogger(MasterSlaveDataSourceAspect.class);

    @Pointcut(value = "@annotation(org.springframework.transaction.annotation.Transactional)")
    public void txMethod() {
    }

    @Around("txMethod()")
    public Object handle(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            // 获取事务方法上的注解
            Transactional transactional = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(Transactional.class);
            // 获取当前请求的主从标识
            if (transactional != null && transactional.readOnly()) {
                log.info("标记为从库");
                MasterSlaveDataSourceMarker.slave();    // 只读，从库
            } else {
                log.info("标记为主库");
                MasterSlaveDataSourceMarker.master(); // 可写，主库
            }

            // 执行业务方法
            Object ret = joinPoint.proceed();

            return ret;
        } catch (Throwable e) {
            throw e;
        } finally {
            MasterSlaveDataSourceMarker.clean();
        }
    }

}
