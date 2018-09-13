package com.harold.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.harold.aopdemo.Account;

@Component
public class AccountDao {
	
	private String name;
	private String serviceCode;
	
	
	public List<Account> getAccounts(boolean tripWire){
		
		if(tripWire) {
			throw new RuntimeException("Some exception");
		}
		
		List<Account> accounts = new ArrayList<>();
		
		// create sample accounts
		Account temp1 = new Account("Harold","Basic");
		Account temp2 = new Account("Elodie","Silver");
		Account temp3 = new Account("Estelle","Gold");
		
		// add these accounts to list
		
		accounts.add(temp1); accounts.add(temp2); accounts.add(temp3);
		
		return accounts;
	}
	
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
