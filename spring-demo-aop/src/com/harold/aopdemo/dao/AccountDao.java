package com.harold.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.harold.aopdemo.Account;

@Component
public class AccountDao {
	
	public void addAccount(Account theAccount, boolean theVip) {
		System.out.println(getClass() + ": ADDIND AN SIMPLE ACCOUNT");
	}
	
	public void doWork() {
		System.out.println("==== DOING WORK =====");
	}

}
