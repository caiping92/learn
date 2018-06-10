package pers.caiping.learn.validate.annotations;

import pers.caiping.learn.validate.validators.LatitudeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author caiping
 * @create 2018/1/16 9:50
 * @Description 纬度校验，小数点后面不能低于2位
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {LatitudeValidator.class})
public @interface Latitude {
    String message() default "维度小数点后面不能小于2位";
    /**
     * @return the regular expression to match 小数点后面不能小于2位
     */
    String regexp() default "\\d*+\\.\\d{2,}+";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Latitude[] value();
    }
}
