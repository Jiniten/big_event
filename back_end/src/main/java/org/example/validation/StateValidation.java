package org.example.validation;

import org.example.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StateValidation implements ConstraintValidator<State, String> {
    /**
     * @param value 将来要校验的数据
     * @param context
     * @return 如果返回 false 则校验不通过，如果返回 true 则返回通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 提供校验规则
        if (value == null) {
            return false;
        }
        if (value.equals("已发布") || value.equals("草稿")) {
            return true;
        }
        
        return false;
    }
}
