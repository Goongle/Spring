package spring.di;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.di.entity.Exam;
import spring.di.entity.NewlecExam;
import spring.di.ui.ExamConsole;

public class Program {

	public static void main(String[] args) {
		
	// ApplicationContext context = new ClassPathXmlApplicationContext("./spring/di/setting.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(NewlecDIConfig.class);
		ExamConsole console = context.getBean(ExamConsole.class);
		console.print();
		
		// context.register(NewlecAppConfig.class);
		// ctx.register(NewlecAppConfig.class,NewlecAppConfig2.class);
		//Exam exam = context.getBean(Exam.class);
		// System.out.println(exam);
		// ExamConsole console = (ExamConsole)context.getBean("console");
		
	
		// List<Exam> exams  = (List<Exam>) context.getBean("exams"); // new ArrayList<>();
		
		//for (Exam e : exams) 
		//{
		//	e.Print_info();
				
		//}
	}

}
