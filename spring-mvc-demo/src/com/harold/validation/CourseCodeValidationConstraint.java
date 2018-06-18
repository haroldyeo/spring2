package com.harold.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeValidationConstraint implements ConstraintValidator<CourseCode, String>{

	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}
	
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {
		
		boolean result =false;
		if(theCode !=null)
		 result = theCode.startsWith(coursePrefix);
		else
			result = true;
		return result;
	}

}
