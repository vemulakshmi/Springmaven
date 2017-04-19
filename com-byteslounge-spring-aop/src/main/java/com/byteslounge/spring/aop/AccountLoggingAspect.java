package com.byteslounge.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.byteslounge.model.Account;

@Aspect
public class AccountLoggingAspect {

	@Before(value = "com.byteslounge.spring.aop.PointcutDefinition.serviceLayer() && "
			+ "args(account,..)")
	public void beforeAccountMethodExecution(Account account) {
		System.out.println("Logging account access. Account: "
				+ account.getAccountNumber());
	}

	@Before(value = "com.byteslounge.spring.aop.PointcutDefinition.serviceLayer() && "
			+ "args(account,..)")
	public void beforeAccountMethodExecution(JoinPoint jp, Account account) {

		System.out.println("Before method: " + jp.getSignature().getName()
				+ ". Class: " + jp.getTarget().getClass().getSimpleName());

		System.out.println("Logging account access. Account: "
				+ account.getAccountNumber());
	}

	@Before(value = "com.byteslounge.spring.aop.PointcutDefinition.serviceLayer() && "
			+ "args(account,amount)")
	public void beforeAccountMethodExecution(JoinPoint jp, Account account,
			Long amount) {

		System.out.println("Logging account access. Account: "
				+ account.getAccountNumber() + ", Amount: " + amount);
	}

	@Before(value = "com.byteslounge.spring.aop.PointcutDefinition.serviceLayer() && "
			+ "args(account,..) && @annotation(auditable)")
	public void audit(Account account, Auditable auditable) {
		System.out.println("Audit account access: "
				+ account.getAccountNumber() + ". Audit destination: "
				+ auditable.value());
	}

	@Before(value = "com.byteslounge.spring.aop.PointcutDefinition.serviceLayer() && "
			+ "execution(java.util.List<com.byteslounge.model.Account> find*(..)) && "
			+ "args(customerId,..)")
	public void beforeAcountFinder(Long customerId) {
		System.out.println("Logging access to account finder. CustomerID: "
				+ customerId);
	}

	@Around(value = "com.byteslounge.spring.aop.PointcutDefinition.serviceLayer() && "
			+ "execution(* com.byteslounge.service.ExampleService.updateAccountDescription(..)) && "
			+ "args(account)")
	public void beforeUpdateAccountDescription(ProceedingJoinPoint pjp,
			Account account) throws Throwable {
		account.setAccountDescription(account.getAccountDescription()
				.toUpperCase());
		System.out
				.println("Logging access to updateAccountDescription. Prepared account description: "
						+ account.getAccountDescription());

		pjp.proceed(new Object[] { account });
	}

	@Before(value = "com.byteslounge.spring.aop.PointcutDefinition.serviceLayer() && "
			+ "execution(* com.byteslounge.service.ExampleService.methodUsingGenerics(..)) && "
			+ "args(parameter)")
	public void beforeGenericMethod(Account parameter) {
		System.out.println("Logging access to generic method. Account: "
				+ parameter.getAccountNumber());
	}

}
