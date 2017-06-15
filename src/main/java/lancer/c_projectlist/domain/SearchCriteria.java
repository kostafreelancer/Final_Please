package lancer.c_projectlist.domain;

import java.io.Serializable;
import java.util.Arrays;

public class SearchCriteria extends Criteria implements Serializable{

	private String[] jobs;
	private String fr;
	private String ft;
	public String[] getJobs() {
		return jobs;
	}
	public void setJobs(String[] jobs) {
		this.jobs = jobs;
	}
	public String getFr() {
		return fr;
	}
	public void setFr(String fr) {
		this.fr = fr;
	}
	public String getFt() {
		return ft;
	}
	public void setFt(String ft) {
		this.ft = ft;
	}
	@Override
	public String toString() {
		return "SearchCriteria [jobs=" + Arrays.toString(jobs) + ", fr=" + fr + ", ft=" + ft + "]";
	}
	
	
	
	
}


