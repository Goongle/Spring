package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object result = invocation.proceed(); // ������ invoke�� ���� ������ ����
		
		/* ������ �ڹٴ� Object result = method.invoke(exam, args);
		 ���� ���� ���� Ŭ������ �����߾�� �ߴ�.
		 ������ invocation�� ���� proceed ��� �ϳ��� �����Ƿ� �׷��� ���Ӽ��� ���� �Ͽ���.
		 */
		 long end  = System.currentTimeMillis();
		 String message = (end - start) + " �ð��� �ɷȽ��ϴ�." ;
		 System.out.println(message);
		return result;
	}
	

}
