package pers.caiping.learn.validate.validators;


import pers.caiping.learn.validate.annotations.Latitude;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author caiping
 * @create 2018/1/16 10:27
 * @Description
 */
public class LatitudeValidator implements ConstraintValidator<Latitude,Double> {

    private String regex;

    @Override
    public void initialize(Latitude constraintAnnotation) {
        this.regex = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (null == value) {//如果经纬度为null则false
            return false;
        }
        if ((value+"").matches(regex)) {
            return true;
        }
        return false;
    }
}
