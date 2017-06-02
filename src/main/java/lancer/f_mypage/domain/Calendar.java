package lancer.f_mypage.domain;

import java.io.Serializable;

public class Calendar implements Serializable{
	private int calendar_num;
	private int f_num;
	private String contents;
	private String startdate;
	private String enddate;
	
	public Calendar(){}
	
	public Calendar(int calendar_num, int f_num, String contents, String startdate, String enddate) {
		super();
		this.calendar_num = calendar_num;
		this.f_num = f_num;
		this.contents = contents;
		this.startdate = startdate;
		this.enddate = enddate;
	}

	public int getCalendar_num() {
		return calendar_num;
	}

	public void setCalendar_num(int calendar_num) {
		this.calendar_num = calendar_num;
	}

	public int getF_num() {
		return f_num;
	}

	public void setF_num(int f_num) {
		this.f_num = f_num;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	
}
