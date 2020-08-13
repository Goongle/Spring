package spring.aop.entity;

public class NewlecExam implements Exam {
	private int kor;
	private int eng;
	private int math;
	private int com;
	
	public NewlecExam() {
		this.kor = 0;
		this.eng = 0;
		this.math = 0;
		this.com = 0;
		System.out.println(1);
	}

	public NewlecExam(int kor, int eng, int math, int com) {
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.com = com;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getCom() {
		return com;
	}

	public void setCom(int com) {
		this.com = com;
	}

	@Override
	public int total() {

		
		int result = kor + eng + math + com;
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (kor > 100 )
		{
			throw new IllegalArgumentException("유효하지 않은 국어 점수");
			
		}

		return result;
	}

	@Override
	public float avg() {
		float result = total() / 4.0f;
		
		return result;
	}
	public void Print_info() {
		System.out.println("Kor = " + kor + " eng = " + eng + " math = " + math + " com = " + com);
		return;
	}

}
