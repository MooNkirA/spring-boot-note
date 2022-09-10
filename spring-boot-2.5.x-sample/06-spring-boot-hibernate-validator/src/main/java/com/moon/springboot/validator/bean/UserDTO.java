package com.moon.springboot.validator.bean;

import com.moon.springboot.validator.groups.Create;
import com.moon.springboot.validator.groups.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户传输实体
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-07-20 15:08
 * @description
 */
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -3440487180915805408L;

    /**
     * 用户ID
     */
    @NotNull(message = "用户id不能为空", groups = Update.class)
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空")
    @Length(message = "用户名不能超过20个字符", max = 20, groups = {Create.class, Update.class})
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
    private String username;

    /**
     * 年龄
     */
    @Min(message = "年龄最小为18岁", value = 18)
    @Max(message = "年龄最大为80岁", value = 80)
    private int age;

    /**
     * 邮箱
     */
    @Email(message = "请输入正确的邮箱")
    // 或者使用正则表达式的方式校验
    // @Pattern(regexp = "[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$",
    //         message = "邮箱格式不正确")
    private String email;

    /**
     * 手机号
     */
    @NotEmpty(message = "手机号不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    private String mobile;

    /**
     * 性别（无校验）
     */
    private String sex;

    /**
     * 创建时间
     */
    @Future(message = "时间必须是将来时间")
    private Date createTime;
}
