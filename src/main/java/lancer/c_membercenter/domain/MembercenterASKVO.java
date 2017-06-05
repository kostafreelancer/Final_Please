package lancer.c_membercenter.domain;

import java.util.Date;

public class MembercenterASKVO {

	private int asknum;
	private String askcontents;
	private Date askdate;
	private int f_num;
	private int e_num;
	private String asktitle;
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
	public Date getAskdate() {
		return askdate;
	}
	public void setAskdate(Date askdate) {
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
	public String getasktitle() {
		return asktitle;
	}
	public void setasktitle(String asktitle) {
		this.asktitle = asktitle;
	}
	@Override
	public String toString() {
		return "membercenterVO [asknum=" + asknum + ", askcontents=" + askcontents + ", askdate=" + askdate + ", f_num="
				+ f_num + ", e_num=" + e_num + ", asktitle=" + asktitle + "]";
	}
	
	
}
