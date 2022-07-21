package com.moon.springboot.validator.groups;

import javax.validation.groups.Default;

/**
 * 新增校验分组
 * 注意: 在创建分组接口时尽量继承 `javax.validation.groups.Default` 接口。
 * 否则，在声明`@Validated(Update.class)`的时候，就会出现在默认没添加`groups = {}`的时候的校验组
 * 有些标识了校验注解而不会去校验，这是因为默认的校验组是 `groups = {Default.class}`
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-07-20 16:26
 * @description
 */
public interface Create extends Default {
}
