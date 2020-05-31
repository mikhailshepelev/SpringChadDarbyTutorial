package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

   private String coursePrefix;

   public void initialize(CourseCode theCourseCode) {
      coursePrefix = theCourseCode.value();
      // .value means that coursePrefix will be taken from value parameter in front of annotation
   }

   public boolean isValid(String theCode, ConstraintValidatorContext context) {
      //we can implement any logic here
      boolean result;
      if (theCode != null) {
         result = theCode.startsWith(coursePrefix);
      }
      else result = true;
      return result;
   }
}
