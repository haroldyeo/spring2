package com.harold.mvc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Value("#{countryOptions}") 
	private Map<String, String> countryOptions;
	
	@RequestMapping("/showStudentForm")
	public String showForm(Model model) {
		
		// create new student object & add it to the model
		model.addAttribute("student", new Student("Harold","YEO","INR", "Java"));
		
		  // add the country options to the model 
		model.addAttribute("theCountryOptions", countryOptions); 
		
		return "student-form";
	}
	
	
	@RequestMapping("/showStudentProcessForm")
	public String processForm(@ModelAttribute("student")Student student) {

		System.out.println("The student: "+ student.getFirstName() + "  " + student.getLastName());
		
		return "student-confirmation";
	}

}
