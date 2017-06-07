package lancer.f_board.domain;

import java.util.Date;

public class F_BoardVO {
	private Integer f_board_num;
	private String f_board_title;
	private String f_board_content;
	private Integer f_board_hits;
	private Date f_board_date;
	private Integer f_reply_count;
	private Integer f_num;
	private String f_id;
	
	
	public F_BoardVO(Integer f_board_num, String f_board_title, String f_board_content, Integer f_board_hits,
			Date f_board_date, Integer f_reply_count, Integer f_num, String f_id) {
		super();
		this.f_board_num = f_board_num;
		this.f_board_title = f_board_title;
		this.f_board_content = f_board_content;
		this.f_board_hits = f_board_hits;
		this.f_board_date = f_board_date;
		this.f_reply_count = f_reply_count;
		this.f_num = f_num;
		this.f_id = f_id;
	}


	public Integer getF_board_num() {
		return f_board_num;
	}


	public void setF_board_num(Integer f_board_num) {
		this.f_board_num = f_board_num;
	}


	public String getF_board_title() {
		return f_board_title;
	}


	public void setF_board_title(String f_board_title) {
		this.f_board_title = f_board_title;
	}


	public String getF_board_content() {
		return f_board_content;
	}


	public void setF_board_content(String f_board_content) {
		this.f_board_content = f_board_content;
	}


	public Integer getF_board_hits() {
		return f_board_hits;
	}


	public void setF_board_hits(Integer f_board_hits) {
		this.f_board_hits = f_board_hits;
	}


	public Date getF_board_date() {
		return f_board_date;
	}


	public void setF_board_date(Date f_board_date) {
		this.f_board_date = f_board_date;
	}


	public Integer getF_reply_count() {
		return f_reply_count;
	}


	public void setF_reply_count(Integer f_reply_count) {
		this.f_reply_count = f_reply_count;
	}


	public Integer getF_num() {
		return f_num;
	}


	public void setF_num(Integer f_num) {
		this.f_num = f_num;
	}


	public String getF_id() {
		return f_id;
	}


	public void setF_id(String f_id) {
		this.f_id = f_id;
	}
	
	
}
