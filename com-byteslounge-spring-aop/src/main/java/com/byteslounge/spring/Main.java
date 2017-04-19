package com.byteslounge.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.byteslounge.model.Account;
import com.byteslounge.service.ExampleService;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/byteslounge/spring/resources/beans.xml");
		ExampleService exampleService = (ExampleService) ctx
				.getBean("exampleService");

		Account account = new Account("000001", "Account 1");
		exampleService.updateAccountBalance(account, 100L);

		List<Account> accounts = exampleService.findCustomerAccounts(1L);

		account.setAccountDescription("Test Description");
		exampleService.updateAccountDescription(account);

		exampleService.methodUsingGenerics(account);

	}
}
