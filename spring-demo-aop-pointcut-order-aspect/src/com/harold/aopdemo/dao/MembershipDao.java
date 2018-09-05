package com.harold.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	
	public String addSillyMember() {
		System.out.println(getClass() + ": ADDIND A MEMBERSHIP ACCOUNT");
		return "hello silly";
	}
	
	public void goToSleep() {
		System.out.println("*******  GOOD NIGHT *****");
	}

}
