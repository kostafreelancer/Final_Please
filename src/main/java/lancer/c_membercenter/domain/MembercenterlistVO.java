package lancer.c_membercenter.domain;

import java.util.Date;

public class MembercenterlistVO {

	public String writer;
	public String asktitle;
	public Date askdate;
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getAsktitle() {
		return asktitle;
	}
	public void setAsktitle(String asktitle) {
		this.asktitle = asktitle;
	}
	public Date getAskdate() {
		return askdate;
	}
	public void setAskdate(Date askdate) {
		this.askdate = askdate;
	}
	@Override
	public String toString() {
		return "MembercenterlistVO [writer=" + writer + ", asktitle=" + asktitle + ", askdate=" + askdate + "]";
	}
	
	
}
