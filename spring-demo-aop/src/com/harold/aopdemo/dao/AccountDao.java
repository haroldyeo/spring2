package com.harold.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDao {
	
	public void addAccount() {
		System.out.println(getClass() + "ADDIND AN ACCOUNT");
	}

}
