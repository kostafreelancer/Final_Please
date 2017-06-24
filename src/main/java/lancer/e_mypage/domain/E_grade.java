package lancer.e_mypage.domain;

public class E_grade {
	private int e_pr_num;
	private int e_num;
	private int f_num;
	private int e_grade_num;
	private double e_grade_star;
	
	public E_grade(){};
	
	public E_grade(int e_pr_num, int e_num, int f_num, int e_grade_num, double e_grade_star) {
		super();
		this.e_pr_num = e_pr_num;
		this.e_num = e_num;
		this.f_num = f_num;
		this.e_grade_num = e_grade_num;
		this.e_grade_star = e_grade_star;
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
	public int getE_grade_num() {
		return e_grade_num;
	}
	public void setE_grade_num(int e_grade_num) {
		this.e_grade_num = e_grade_num;
	}
	public double getE_grade_star() {
		return e_grade_star;
	}
	public void setE_grade_star(double e_grade_star) {
		this.e_grade_star = e_grade_star;
	}
	
	
}
