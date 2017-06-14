package lancer.c_membercenter.domain;

import java.io.Serializable;
import java.util.Date;

public class MembercenterASKVO implements Serializable {

	private int asknum;
	private String askcontents;
	private String askdate;
	private int f_num;
	private int e_num;
	private String asktitle;
	private String writer;
	private String answercontents;
	private String answerdate;
	private int ad_num;
	private String ask_state;
	
	
	
	public String getAsk_state() {
		return ask_state;
	}
	public void setAsk_state(String ask_state) {
		this.ask_state = ask_state;
	}
	public String getAnswerdate() {
		return answerdate;
	}
	public void setAnswerdate(String answerdate) {
		this.answerdate = answerdate;
	}
	public int getAd_num() {
		return ad_num;
	}
	public void setAd_num(int ad_num) {
		this.ad_num = ad_num;
	}
	public String getAnswercontents() {
		return answercontents;
	}
	public void setAnswercontents(String answercontents) {
		this.answercontents = answercontents;
	}
	public int getAsknum() {
		return asknum;
	}
	public void setAsknum(int asknum) {
		this.asknum = asknum;
	}
	public String getAskcontents() {
		return askcontents;
	}
	public void setAskcontents(String askcontents) {
		this.askcontents = askcontents;
	}
	public String getAskdate() {
		return askdate;
	}
	public void setAskdate(String askdate) {
		this.askdate = askdate;
	}
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	public int getE_num() {
		return e_num;
	}
	public void setE_num(int e_num) {
		this.e_num = e_num;
	}
	public String getAsktitle() {
		return asktitle;
	}
	public void setAsktitle(String asktitle) {
		this.asktitle = asktitle;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	@Override
	public String toString() {
		return "MembercenterASKVO [asknum=" + asknum + ", askcontents=" + askcontents + ", askdate=" + askdate
				+ ", f_num=" + f_num + ", e_num=" + e_num + ", asktitle=" + asktitle + ", writer=" + writer + "]";
	}
	
	
	
}
