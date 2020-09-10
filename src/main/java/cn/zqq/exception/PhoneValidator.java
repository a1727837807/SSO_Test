package cn.zqq.exception;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * class创建日期
 *
 * @date 2020/9/922:09
 */
public class PhoneValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return String.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        String phone=(String) o;
        if (!phone.matches("^1[3456789]\\d{9}$")){
            errors.rejectValue("phone","error.phone.Invalidate","must match the regex");
        }
    }
}
