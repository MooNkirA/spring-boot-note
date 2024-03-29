# spring-boot-2.2.x-sample

> 注：此示例项目会参考一些网络示例，外加个人了解学习整理

## 项目简介

此项目是 Spring Boot 的使用示例，包含用来深度学习并实战 `spring boot` 的项目，集成常用的技术框架

目前示例使用的 **Spring Boot 的版本是 2.2.x**

<font color=red>*项目持续更新中...*</font>

## 项目运行环境

- **JDK 1.8 +**
- **Maven 3.5 +**
- **IntelliJ IDEA ULTIMATE 2018.2 +** (*注意：推荐使用 IDEA 开发，同时保证安装 `lombok` 插件*)
- **Mysql 5.7 +** (*尽量保证使用 5.7 版本以上，因为 5.7 版本加了一些新特性，同时不向下兼容。示例可能不确认兼容性*)

## 项目运行方式

1. `git clone https://github.com/xkcoding/spring-boot-demo.git`
2. 使用 IDEA 打开 clone 下来的项目
3. 在 IDEA 中 Maven Projects 的面板导入项目根目录下 的 `pom.xml` 文件（勾上 IDEA 顶部工具栏的 View -> Tool Buttons ，然后 Maven Projects 的面板就会出现在 IDEA 的右侧）
4. 找到各个 Module 的 Application 类就可以运行各个 demo 了
5. **注意：有些 demo 可能会有 README 配套，可配合代码食用~**
6. **注意：运行某些 demo 之前，可能有需要事先初始化数据库数据的，别忘记了哦~**

## 项目模块介绍

| 完成度 | Module 名称                      | Module 介绍                                          |
| :----: | -------------------------------- | ---------------------------------------------------- |
|   √    | 00-Spring-Boot-Start             | Spring Boot 基础快速开始示例                         |
|        | 01-Spring-Boot-Servlet-Component | Spring Boot 整合 Servlet、Filter、Listener（已过时） |

