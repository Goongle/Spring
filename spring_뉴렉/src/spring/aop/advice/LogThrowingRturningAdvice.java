package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogThrowingRturningAdvice implements ThrowsAdvice{

	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		/*IllegalArgumentException e 같은 경우 원하는 에러에 대해 정의를 해놓으면 된다. 
		 어떤 오류가 있을지 모르므로 정해진 형식이 없는 것이다. */
		System.out.println("예외가 발생하였습니다. " + e.getMessage());
	}
}
