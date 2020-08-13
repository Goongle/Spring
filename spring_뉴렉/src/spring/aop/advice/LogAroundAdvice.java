package spring.aop.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		long start = System.currentTimeMillis();
		
		Object result = invocation.proceed(); // 원래의 invoke와 같은 역할을 수행
		
		/* 이전의 자바는 Object result = method.invoke(exam, args);
		 위와 같이 직접 클래스를 지정했어야 했다.
		 하지만 invocation은 단지 proceed 명령 하나만 있으므로 그러한 종속성을 제거 하였다.
		 */
		 long end  = System.currentTimeMillis();
		 String message = (end - start) + " 시간이 걸렸습니다." ;
		 System.out.println(message);
		return result;
	}
	

}
