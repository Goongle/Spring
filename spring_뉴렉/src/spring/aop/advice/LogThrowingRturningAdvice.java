package spring.aop.advice;

import org.springframework.aop.ThrowsAdvice;

public class LogThrowingRturningAdvice implements ThrowsAdvice{

	public void afterThrowing(IllegalArgumentException e) throws Throwable {
		/*IllegalArgumentException e ���� ��� ���ϴ� ������ ���� ���Ǹ� �س����� �ȴ�. 
		 � ������ ������ �𸣹Ƿ� ������ ������ ���� ���̴�. */
		System.out.println("���ܰ� �߻��Ͽ����ϴ�. " + e.getMessage());
	}
}
