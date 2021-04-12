package com.lovemio.knife4j.annotation;

/**
 * @author liwenjin
 * @date 2021年04月12日 16:44
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {Phone11Validator.class})// 标明由哪个类执行校验逻辑
@NotBlank(message = "电话不能为空")
public @interface Phone11 {
    boolean required() default true;

    String message() default "11位手机格式不正确";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
