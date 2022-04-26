# spring-boot-2.5.x-sample

> 注：此示例项目会参考一些网络示例，外加个人了解学习整理

## 项目简介

此项目是 Spring Boot 的使用示例，包含用来深度学习并实战 `spring boot` 的项目，集成常用的技术框架

目前示例使用的 **Spring Boot 的版本是 2.5.x**

<font color=red>*项目持续更新中...*</font>

## 项目运行环境

- **JDK 1.8 +**
- **Maven 3.5 +**
- **IntelliJ IDEA ULTIMATE 2018.2 +** (*注意：推荐使用 IDEA 开发，同时保证安装 `lombok` 插件*)
- **Mysql 5.7 +** (*尽量保证使用 5.7 版本以上，因为 5.7 版本加了一些新特性，同时不向下兼容。示例可能不确认兼容性*)

## 项目运行方式

1. `git clone https://github.com/MooNkirA/spring-boot-note.git`
2. 使用 IDEA 打开 clone 下来的项目
3. 在 IDEA 中 Maven Projects 的面板导入项目根目录下 的 `pom.xml` 文件（勾上 IDEA 顶部工具栏的 View -> Tool Buttons ，然后 Maven Projects 的面板就会出现在 IDEA 的右侧）
4. 找到各个 Module 的 Application 类就可以运行各个 demo 了
5. **注意：有些 demo 可能会有 README 配套，可配合代码食用~**
6. **注意：运行某些 demo 之前，可能有需要事先初始化数据库数据的，别忘记了哦~**

## 项目模块介绍

### 已实现

|   完成度   | Module 名称                        | Module 介绍                            |
| :--------: | ---------------------------------- | -------------------------------------- |
|     √      | 00-spring-boot-quickstart          | Spring Boot 基础快速开始示例           |
|     √      | 01-spring-boot-config              | Spring Boot 项目配置示例               |
|     √      | 02-spring-boot-multi-config        | Spring Boot 项目多配置示例             |
|     √      | 03-spring-boot-war                 | Spring Boot 项目打成 war 包示例        |
|     √      | 04-spring-boot-junit               | Spring Boot 整合 Junit                 |
|     √      | 05-spring-boot-devtools            | Spring Boot 热部署插件                 |
|   整理中   | 06-spring-boot-hibernate-validator | Spring Boot 整合 javax.validation 校验 |
|     √      | 07-spring-boot-embedded-hikariCP   | Spring Boot 使用内置数据源 HikariCP    |
|     √      | 08-spring-boot-embedded-h2         | Spring Boot 使用内置数据库 H2          |
|     √      | 09-spring-boot-jdbc                | Spring Boot 整合 JDBC                  |
| 未创建工程 | 10-spring-boot-mybatis             | Spring Boot 整合 MyBatis               |
|            | 11-spring-boot-redis               | Spring Boot 整合 Redis                 |
|            |                                    |                                        |
|            |                                    |                                        |
|            |                                    |                                        |

### 计划实现
