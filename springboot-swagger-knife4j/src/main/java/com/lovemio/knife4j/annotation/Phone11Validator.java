package com.lovemio.knife4j.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @author liwenjin
 * @date 2021年04月12日 16:46
 */
public class Phone11Validator implements ConstraintValidator<Phone11, String>  {
    //校验手机号正则
    public static final String REGEX_MOBILE = "^((13[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$";

    @Override
    public boolean isValid(String o, ConstraintValidatorContext constraintValidatorContext) {
        if (isMobile(o)){
            return true;
        }else {
            return false;
        }
    }


    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
}
