package com.moon.springboot.tomcat;

import com.moon.springboot.tomcat.config.SpringConfig;
import com.moon.springboot.tomcat.servlet.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.coyote.http11.Http11Nio2Protocol;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;

/**
 * 内嵌 Tomcat 容器模拟实现
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-06-13 11:22
 * @description
 */
public class EmbeddedTomcatApplication {

    /*
       Tomcat 基本结构
        Server
        └───Service
            ├───Connector (协议, 端口)
            └───Engine
                └───Host(虚拟主机 localhost)
                    ├───Context1 (应用1, 可以设置虚拟路径, / 即 url 起始路径; 项目磁盘路径, 即 docBase )
                    │   │   index.html
                    │   └───WEB-INF
                    │       │   web.xml (servlet, filter, listener) 3.0
                    │       ├───classes (servlet, controller, service ...)
                    │       ├───jsp
                    │       └───lib (第三方 jar 包)
                    └───Context2 (应用2)
                        │   index.html
                        └───WEB-INF
                                web.xml
     */
    public static void main(String[] args) throws LifecycleException, IOException {
        // 1.创建 Tomcat 对象
        Tomcat tomcat = new Tomcat();
        // 设置 tomcat 基础目录，用于保存一些必须的配置与临时文件
        tomcat.setBaseDir("tomcat");

        // 2.创建项目文件夹, 即 docBase 文件夹
        File docBase = Files.createTempDirectory("boot.").toFile();
        docBase.deleteOnExit(); // 在容器关闭时，删除文件夹

        /*
         * 3.创建 Tomcat 项目, 在 Tomcat 中称为 Context。
         *  public Context addContext(String contextPath, String docBase)
         *      contextPath 参数：上下文映射路径，空字符串（""）代表根上下文
         *      docBase 参数：上下文的基础目录，用于静态文件
         */
        Context context = tomcat.addContext("", docBase.getAbsolutePath());

        // 创建基于注解的 Spring 容器 AnnotationConfigWebApplicationContext
        // 弃用 AnnotationConfigServletWebServerApplicationContext 是因为此容器自带内嵌的 web 容器
        AnnotationConfigWebApplicationContext springContext = new AnnotationConfigWebApplicationContext();
        springContext.register(SpringConfig.class);
        springContext.refresh(); // 手动刷新容器

        // 4.编程式添加 Servlet
        context.addServletContainerInitializer(new ServletContainerInitializer() {
            @Override
            public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
                ctx.addServlet("helloServlet", new HelloServlet()).addMapping("/hello");
                // 可以从 Spring 容器中获取到被管理的 DispatcherServlet，并注册
                // DispatcherServlet dispatcherServlet = springContext.getBean(DispatcherServlet.class);
                // ctx.addServlet("dispatcherServlet", dispatcherServlet).addMapping("/");

                // 上面是手动注册一个 DispatcherServlet，为了日后的方便扩展，可以从 Spring 容器中获取所有 ServletRegistrationBean 类型的实例
                // 调用其对象的 onStartup 方法，完成所有 DispatcherServlet 的注册
                for (ServletRegistrationBean registrationBean : springContext.getBeansOfType(ServletRegistrationBean.class).values()) {
                    registrationBean.onStartup(ctx);
                }
            }
        }, Collections.emptySet());

        // 5.启动 Tomcat
        tomcat.start();

        // 6.创建连接器，使用 ProtocolHandler 的实现类 Http11Nio2Protocol
        Connector connector = new Connector(new Http11Nio2Protocol());
        // 设置监听端口
        connector.setPort(8080);
        tomcat.setConnector(connector);
    }

}
