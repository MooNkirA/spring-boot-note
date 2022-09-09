package com.moon.springboot.validator.handler;

import com.moon.springboot.validator.annotation.IdCard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义 Validator 类，此类是对自定义校验注解进行验证的逻辑代码
 *
 * @author MooNkirA
 * @version 1.0
 * @date 2022-07-20 16:07
 * @description
 */
public class IdentityCardNumberValidator implements ConstraintValidator<IdCard, Object> {

    @Override
    public void initialize(IdCard constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * 校验的核心逻辑
     *
     * @param value
     * @param context
     * @return
     */
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 示例做简单实现，只能是6个0
        return "000000".equals(value);
    }

}
