package lancer.c_projectlist.domain;

import java.io.Serializable;
import java.util.Arrays;

public class SearchCriteria extends Criteria implements Serializable{

	private String[] jobs;

	public String[] getJobs() {
		return jobs;
	}

	public void setJobs(String[] jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "SearchCriteria [jobs=" + Arrays.toString(jobs) + "]";
	}
	
	
	
	
}


