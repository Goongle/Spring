package spring.di.ui;

import spring.di.entity.Exam;

public class GridExamConsole implements ExamConsole {

private Exam exam;
	public GridExamConsole() {
		// TODO Auto-generated constructor stub
	}
	public GridExamConsole(Exam exam) {
		this.exam = exam;
	}

	@Override
	public void print() {
		System.out.printf(" �ش� ȭ���� Grid �Դϴ�. ");
		System.out.printf(" total is %d, avg is %f ", exam.total(), exam.avg());
		return;
	}

	@Override
	public void setExam(Exam exam) {
		this.exam = exam;
		
	}

}
