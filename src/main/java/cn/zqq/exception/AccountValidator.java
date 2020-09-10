package cn.zqq.exception;

import cn.zqq.Domin.Account;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * class创建日期
 *
 * @date 2020/9/919:21
 */
public class AccountValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return Account.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Account account=(Account)o;
        String username = account.getUsername();
        String password = account.getPassword();
        if (!username.matches("^[a-zA-Z0-9_-]{4,16}$")){////用户名正则，4到16位（字母，数字，下划线，减号）
            errors.rejectValue("username","error.account.Invalidate","must match the regex");
        }
        if (!password.matches("^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$")){
            //密码强度正则，最少6位，包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
            errors.rejectValue("password","error.account.Invalidate","must match the regex");
        }
    }
}
