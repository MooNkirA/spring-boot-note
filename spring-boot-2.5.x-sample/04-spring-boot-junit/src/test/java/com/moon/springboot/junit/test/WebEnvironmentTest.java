package com.moon.springboot.junit.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;

/**
 * web 环境模拟测试
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-04-20 22:34
 * @description
 */
/*
 * webEnvironment 属性用于设置在测试用例中启动 web 环境
 *  值为 SpringBootTest.WebEnvironment 枚举
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // 开启虚拟MVC调用
public class WebEnvironmentTest {

    // 测试 web 启动
    @Test
    public void testWebStart() {
    }

    // 测试发起请求
    @Test
    public void testWeb(@Autowired MockMvc mockMvc) throws Exception {
        // 创建虚拟请求，设置当前访问地址 /books/msg，注意访问路径不要写成 http://localhost:8080/books/msg
        // 因为前面的服务器IP地址和端口使用的是当前虚拟的web环境，无需指定，仅指定请求的具体路径即可。
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/msg");
        // 执行对应的请求
        mockMvc.perform(builder);
    }

    @Test
    public void testStatus(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/msg");
        ResultActions action = mvc.perform(builder);

        // 设定预期值 与真实值进行比较，成功测试通过，失败测试失败
        // 定义本次调用的预期值
        StatusResultMatchers status = MockMvcResultMatchers.status();
        // 预计本次调用时成功的：状态200
        ResultMatcher ok = status.isOk();
        // 添加预计值到本次调用过程中进行匹配
        action.andExpect(ok);
    }

    @Test
    public void testBody(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/msg");
        ResultActions action = mvc.perform(builder);

        // 定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.string("book msg");
        // 添加预计值到本次调用过程中进行匹配
        action.andExpect(result);
    }

    @Test
    public void testJson(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/info");
        ResultActions action = mvc.perform(builder);

        // 定义本次调用的预期值
        ContentResultMatchers content = MockMvcResultMatchers.content();
        ResultMatcher result = content.json("{\"id\":1,\"name\":\"Spring Boot 快速入门\",\"type\":\"计算机\",\"description\":\"这是一本好书\"}");
        // 添加预计值到本次调用过程中进行匹配
        action.andExpect(result);
    }

    @Test
    public void testHeaderContentType(@Autowired MockMvc mvc) throws Exception {
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/books/info");
        ResultActions action = mvc.perform(builder);

        // 定义本次调用的预期值
        HeaderResultMatchers header = MockMvcResultMatchers.header();
        ResultMatcher contentType = header.string("Content-Type", "application/json");
        // 添加预计值到本次调用过程中进行匹配
        action.andExpect(contentType);
    }

}
