package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogAfterRturningAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// Before 같은 경우 Object Return이 없었다. 
		// 하지만 after는 수행 직후 호출된 값을 사용할 수 있도록 Object가 반환이 된다.
		
		System.out.println("ReturnValue: " + returnValue + ", Method :" + method.getName());
		
	}

}
