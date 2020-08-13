package spring.di.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import spring.di.entity.Exam;

@Component
public class InlineExamConsole implements ExamConsole {
	
	@Autowired(required = true)
	private Exam exam;
	public InlineExamConsole() {
		System.out.println("Constructor");
	}
	
	public InlineExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf(" total is %d, avg is %f ", exam.total(), exam.avg());
		return;
	}

	@Autowired(required = true)
	@Override
	public void setExam (Exam exam) {
		this.exam = exam;
		
	}

}
