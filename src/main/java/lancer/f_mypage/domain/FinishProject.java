package lancer.f_mypage.domain;

public class FinishProject {
	private String proName;
	private String proTerm;
	private int cost;
	private String p_job;
	
	public FinishProject(){}
	
	public FinishProject(String proName, String proTerm, int cost, String p_job) {
		super();
		this.proName = proName;
		this.proTerm = proTerm;
		this.cost = cost;
		this.p_job = p_job;
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProTerm() {
		return proTerm;
	}

	public void setProTerm(String proTerm) {
		this.proTerm = proTerm;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getP_job() {
		return p_job;
	}

	public void setP_job(String p_job) {
		this.p_job = p_job;
	}
	
	
}
