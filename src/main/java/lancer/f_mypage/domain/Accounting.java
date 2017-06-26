package lancer.f_mypage.domain;

import java.io.Serializable;

public class Accounting  implements Serializable{
	private int a_num;
	private String detail_usage;
	private int a_money;
	private String formatMoney;
	private String a_addfile;
	private String a_using_date;
	private int f_num;
	private String project_relation_check;
	private String monet_state;
	private int accfile_iden;
	
	public Accounting(){}
	
	



	public Accounting(int a_num, String detail_usage, int a_money, String formatMoney, String a_addfile,
			String a_using_date, int f_num, String project_relation_check, String monet_state, int accfile_iden) {
		super();
		this.a_num = a_num;
		this.detail_usage = detail_usage;
		this.a_money = a_money;
		this.formatMoney = formatMoney;
		this.a_addfile = a_addfile;
		this.a_using_date = a_using_date;
		this.f_num = f_num;
		this.project_relation_check = project_relation_check;
		this.monet_state = monet_state;
		this.accfile_iden = accfile_iden;
	}





	public int getA_num() {
		return a_num;
	}
	public void setA_num(int a_num) {
		this.a_num = a_num;
	}
	public String getDetail_usage() {
		return detail_usage;
	}
	public void setDetail_usage(String detail_usage) {
		this.detail_usage = detail_usage;
	}
	public int getA_money() {
		return a_money;
	}
	public void setA_money(int a_money) {
		this.a_money = a_money;
	}
	public String getA_addfile() {
		return a_addfile;
	}
	public void setA_addfile(String a_addfile) {
		this.a_addfile = a_addfile;
	}
	public String getA_using_date() {
		return a_using_date;
	}
	public void setA_using_date(String a_using_date) {
		this.a_using_date = a_using_date;
	}
	public int getF_num() {
		return f_num;
	}
	public void setF_num(int f_num) {
		this.f_num = f_num;
	}
	public String getProject_relation_check() {
		return project_relation_check;
	}
	public void setProject_relation_check(String project_relation_check) {
		this.project_relation_check = project_relation_check;
	}
	public String getMonet_state() {
		return monet_state;
	}
	public void setMonet_state(String monet_state) {
		this.monet_state = monet_state;
	}


	public int getAccfile_iden() {
		return accfile_iden;
	}


	public void setAccfile_iden(int accfile_iden) {
		this.accfile_iden = accfile_iden;
	}





	public String getFormatMoney() {
		return formatMoney;
	}


	public void setFormatMoney(String formatMoney) {
		this.formatMoney = formatMoney;
	}
	
	
}
