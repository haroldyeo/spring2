package com.harold.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.harold.validation.CourseCode;

public class Customer {
	
	private String firstName;
	@NotNull(message="is required")
	@NotEmpty
	private String lastName;
	
	@Min(value=0)
	@Max(value=10)
	@NotNull
	private int freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Only 5 characters / digits")
	private String postalCode;
	
	@CourseCode(value="HOLA", message="Must strat with HOLA")
	private String courseCode;
	
			
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getFreePasses() {
		return freePasses;
	}
	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}
	
	
	
	

}
