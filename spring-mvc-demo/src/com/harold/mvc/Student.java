package com.harold.mvc;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private String favouriteLang;
	private LinkedHashMap<String, String> countryOptions;
	private String[] favouriteOS;
	
	public Student() {
		// populate list of countries
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BRA", "Brazil");
		countryOptions.put("FRA", "France");
		countryOptions.put("GER", "Germany");
		countryOptions.put("INR", "India");
		countryOptions.put("USA", "United States of America");
	}
	
		
	public Student(String firstName, String lastName, String country, String favouriteLang) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.favouriteLang = favouriteLang;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public String getFavouriteLang() {
		return favouriteLang;
	}

	public void setFavouriteLang(String favouriteLang) {
		this.favouriteLang = favouriteLang;
	}


	public String[] getFavouriteOS() {
		return favouriteOS;
	}


	public void setFavouriteOS(String[] favouriteOS) {
		this.favouriteOS = favouriteOS;
	}
	
	
	
	
	
	
}
