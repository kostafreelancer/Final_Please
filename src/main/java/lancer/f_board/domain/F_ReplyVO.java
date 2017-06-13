package lancer.f_board.domain;

import java.util.Date;

public class F_ReplyVO {

	private Integer reply_num;
	private Integer board_num;
	private String reply_content;
/*	private String replyer;*/

	private Date reply_date;
	private Integer f_num;

	public Integer getReply_num() {
		return reply_num;
	}

	public void setReply_num(Integer reply_num) {
		this.reply_num = reply_num;
	}

	public Integer getBoard_num() {
		return board_num;
	}

	public void setBoard_num(Integer board_num) {
		this.board_num = board_num;
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

	public Integer getF_num() {
		return f_num;
	}

	public void setF_num(Integer f_num) {
		this.f_num = f_num;
	}

	@Override
	public String toString() {
		return "F_ReplyVO [reply_num=" + reply_num + ", board_num=" + board_num + ", reply_content=" + reply_content
				+  ", reply_date=" + reply_date + ", f_num=" + f_num + "]";
	}

}