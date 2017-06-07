package lancer.c_freelancerlist.domain;

import java.io.Serializable;
import java.util.Arrays;

public class c_freelancerlist_SearchCriteria extends c_freelancerlist_Criteria implements Serializable{

	private String[] jobs;

	public String[] getJobs() {
		return jobs;
	}

	public void setJobs(String[] jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "c_freelancerlist_SearchCriteria [jobs=" + Arrays.toString(jobs) + "]";
	}
	
}


