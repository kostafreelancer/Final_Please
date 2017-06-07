package lancer.c_membercenter.domain;

import java.io.Serializable;
import java.util.Date;

public class MemberCenterAnswerVO implements Serializable {

	public String answercontents;
	public String answertitle;
	public Date answerdate;
	public int ad_num;
	public String getAnswercontents() {
		return answercontents;
	}
	public void setAnswercontents(String answercontents) {
		this.answercontents = answercontents;
	}
	public String getAnswertitle() {
		return answertitle;
	}
	public void setAnswertitle(String answertitle) {
		this.answertitle = answertitle;
	}
	public Date getAnswerdate() {
		return answerdate;
	}
	public void setAnswerdate(Date answerdate) {
		this.answerdate = answerdate;
	}
	public int getAd_num() {
		return ad_num;
	}
	public void setAd_num(int ad_num) {
		this.ad_num = ad_num;
	}
	
	
}
