package lancer.f_mypage.domain;

public class F_grade {
	private int e_pr_num;
	private int e_num;
	private int f_num;
	private int f_grade_num;
	private double f_grade_star;
	
	public F_grade(){};
	
	public F_grade(int e_pr_num, int e_num, int f_num, int f_grade_num, double f_grade_star) {
		super();
		this.e_pr_num = e_pr_num;
		this.e_num = e_num;
		this.f_num = f_num;
		this.f_grade_num = f_grade_num;
		this.f_grade_star = f_grade_star;
	}

	public int getE_pr_num() {
		return e_pr_num;
	}

	public void setE_pr_num(int e_pr_num) {
		this.e_pr_num = e_pr_num;
	}

	public int getE_num() {
		return e_num;
	}

	public void setE_num(int e_num) {
		this.e_num = e_num;
	}

	public int getF_num() {
		return f_num;
	}

	public void setF_num(int f_num) {
		this.f_num = f_num;
	}

	public int getF_grade_num() {
		return f_grade_num;
	}

	public void setF_grade_num(int f_grade_num) {
		this.f_grade_num = f_grade_num;
	}

	public double getF_grade_star() {
		return f_grade_star;
	}

	public void setF_grade_star(double f_grade_star) {
		this.f_grade_star = f_grade_star;
	}
	
	
}
