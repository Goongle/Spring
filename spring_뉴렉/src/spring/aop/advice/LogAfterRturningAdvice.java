package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterRturningAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// Before ���� ��� Object Return�� ������. 
		// ������ after�� ���� ���� ȣ��� ���� ����� �� �ֵ��� Object�� ��ȯ�� �ȴ�.
		
		System.out.println("ReturnValue: " + returnValue + ", Method :" + method.getName());
		
	}

}
