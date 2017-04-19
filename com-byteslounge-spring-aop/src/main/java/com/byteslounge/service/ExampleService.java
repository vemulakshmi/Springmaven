package com.byteslounge.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.byteslounge.model.Account;
import com.byteslounge.spring.aop.Auditable;
import com.byteslounge.spring.aop.Auditable.AuditDestination;

@Service
public class ExampleService {

	@Auditable(AuditDestination.DATABASE)
	public void updateAccountBalance(Account account, Long amount) {
		System.out.println("Inside updateAccountBalance(). Account: "
				+ account.getAccountNumber() + ", amount: " + amount);
	}

	public List<Account> findCustomerAccounts(Long customerId) {
		System.out.println("Finding accounts for customer: " + customerId);
		List<Account> result = new ArrayList<>();
		result.add(new Account("000001", "Account 1"));
		return result;
	}

	public void updateAccountDescription(Account account) {
		System.out.println("Updating account description to :"
				+ account.getAccountDescription());
	}

	public <T> void methodUsingGenerics(T parameter) {
		System.out.println("Inside methodUsingGenerics: "
				+ parameter.getClass().getName());
	}

}
