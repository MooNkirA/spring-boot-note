package com.moon.webcomponent.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 自定义 Listenr
 *
 * @author MoonZero
 * @version 1.0
 * @date 2020-3-15 12:11
 * @description
 */
@WebListener
public class MyListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("================ MyListener.contextInitialized() 方法执行================");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("================ MyListener.contextDestroyed() 方法执行================");
    }

}
