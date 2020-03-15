package com.moon.webcomponent.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义servlet
 *
 * @author MoonZero
 * @version 1.0
 * @date 2020-3-15 12:24
 * @description
 */
@WebServlet(urlPatterns = "/myservlet/*")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("-----------------MyServlet.doGet()-----------------------");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("-----------------MyServlet.doPost()-----------------------");
    }

}
