package com.example.validator;

import com.example.annotation.EnumValue;
import com.example.enums.EnumMsg;
import com.example.util.EnumUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EnumValueValidator implements ConstraintValidator<EnumValue, Object> {
    private Class<? extends EnumMsg> enumClass;
    private boolean nullable;

    @Override
    public void initialize(EnumValue constraintAnnotation) {
        enumClass = constraintAnnotation.enumClass();
        nullable = constraintAnnotation.nullable();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if (nullable && value == null)
            return true;
        
        return EnumUtils.isValid(value, enumClass);
    }
}
