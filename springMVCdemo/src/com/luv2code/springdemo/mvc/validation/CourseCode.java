package com.luv2code.springdemo.mvc.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class) //concrete implementation of CourseCode interface
@Target( {ElementType.METHOD, ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME) //process CourseCode annotation during runtime
public @interface CourseCode {
    //define default course code
    String value() default "LUV";
    //define default error message
    String message() default "must start with LUV";
    //define default groups
    Class<?>[] groups() default {};
    //define default payloads
    Class<? extends Payload>[] payload() default {};
}
