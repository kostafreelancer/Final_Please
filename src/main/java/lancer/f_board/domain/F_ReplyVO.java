package lancer.f_board.domain;

import java.util.Date;

public class F_ReplyVO {

	private int reply_num;
	private int board_num;
	private String reply_content;
/*	private String replyer;*/

	private Date reply_date;
	private int f_num;

	public F_ReplyVO(){}
	
	
	
	public F_ReplyVO(int reply_num, int board_num, String reply_content, Date reply_date, int f_num) {
		super();
		this.reply_num = reply_num;
		this.board_num = board_num;
		this.reply_content = reply_content;
		this.reply_date = reply_date;
		this.f_num = f_num;
	}



	public Integer getReply_num() {
		return reply_num;
	}

	

	public int getBoard_num() {
		return board_num;
	}



	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}



	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}



	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

/*	public String getReplyer() {
		return replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}*/

	public Date getReply_date() {
		return reply_date;
	}

	public void setReply_date(Date reply_date) {
		this.reply_date = reply_date;
	}


	public int getF_num() {
		return f_num;
	}



	public void setF_num(int f_num) {
		this.f_num = f_num;
	}



	@Override
	public String toString() {
		return "F_ReplyVO [reply_num=" + reply_num + ", board_num=" + board_num + ", reply_content=" + reply_content
				+  ", reply_date=" + reply_date + ", f_num=" + f_num + "]";
	}

}