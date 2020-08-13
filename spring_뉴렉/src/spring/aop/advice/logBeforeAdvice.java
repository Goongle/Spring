package spring.aop.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class logBeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("앞에서 구동되는 로직");
		// target method 등을 이용하여 정보나 본 로직을 수행할 수 있다.
		// 하지만 그것이 아닌 경우 그냥 여기서 넣업주면 된다.
	}

}
