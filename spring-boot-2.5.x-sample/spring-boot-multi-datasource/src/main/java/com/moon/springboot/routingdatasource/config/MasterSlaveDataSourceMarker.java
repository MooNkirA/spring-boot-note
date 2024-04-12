package com.moon.springboot.routingdatasource.config;

/**
 * 维护当前业务的“读写状态”
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2024-02-15 13:16
 * @description
 */
public class MasterSlaveDataSourceMarker {
    // 在当前线程中保存当前业务的读写状态
    private static final ThreadLocal<Boolean> flag = new ThreadLocal<Boolean>();

    // 返回标记
    public static Boolean get() {
        return flag.get();
    }

    // 写状态，标记为主库
    public static void master() {
        flag.set(Boolean.TRUE);
    }

    // 读状态，标记为从库
    public static void slave() {
        flag.set(Boolean.FALSE);
    }

    // 清空标记
    public static void clean() {
        flag.remove();
    }

}
