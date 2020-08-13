package spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.entity.Exam;
import spring.aop.entity.NewlecExam;
import spring.di.NewlecDIConfig;

public class Program {
	
	public static void main(String[] arg) 
	{
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("./spring/aop/setting.xml");
		Exam exam = (Exam) context.getBean("exam");
		
		System.out.println("Total is " +  exam.total());
		System.out.println("Total is " +  exam.avg());
		/* 이처럼 Exam proxy를 Exam exam 으로 바꾸면 본 객체처럼 활용할 수 있다.*/
		// ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);
		/*
		Exam exam = new NewlecExam(1,1,1,1);
		
		Exam proxy = (Exam) Proxy.newProxyInstance(NewlecExam.class.getClassLoader(), new Class[] {Exam.class}, 
				new InvocationHandler() {

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						long start = System.currentTimeMillis();
						
						Object result = method.invoke(exam, args);
						 long end  = System.currentTimeMillis();
						 String message = (end - start) + " 시간이 걸렸습니다." ;
						 System.out.println(message);
						return result;
					}
		});
		*/
			
		// 곁다리 업무를 갖고 있는 것으로 곁다리 업무만을 갖고 있다.
				
	}
}
