package com.harold.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.harold.aopdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount, boolean theVip) {
		System.out.println(getClass() + ": ADDIND AN SIMPLE ACCOUNT");
	}
	
	public void doWork() {
		System.out.println("==== DOING WORK =====");
	}

	public String getName() {
		System.out.println("==== in get name=====");
		return name;
	}

	public void setName(String name) {
		System.out.println("==== in set name =====");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println("==== in getServiceCode=====");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println("==== in setServiceCode =====");
		this.serviceCode = serviceCode;
	}
	
	

}
