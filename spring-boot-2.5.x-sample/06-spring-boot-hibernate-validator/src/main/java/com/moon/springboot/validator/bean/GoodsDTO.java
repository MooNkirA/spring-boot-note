package com.moon.springboot.validator.bean;

import com.moon.springboot.validator.groups.Create;
import com.moon.springboot.validator.groups.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 测试分组校验实体
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-07-20 16:29
 * @description
 */
@Data
public class GoodsDTO implements Serializable {
    private static final long serialVersionUID = -7820546042872815419L;

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    @NotBlank(message = "名称不能为空")
    @Length(message = "名称不能超过20个字符", max = 20, groups = {Create.class, Update.class})
    private String name;

    @Length(message = "备注不能超过100个字符", max = 100)
    private String remark;

}
