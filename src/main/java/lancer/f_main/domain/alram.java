package lancer.f_main.domain;

import java.io.Serializable;

public class alram implements Serializable{

	public String asktitle;
	public int f_num;
	
	

	public int getF_num() {
		return f_num;
	}

	public void setF_num(int f_num) {
		this.f_num = f_num;
	}

	public String getAsktitle() {
		return asktitle;
	}

	public void setAsktitle(String asktitle) {
		this.asktitle = asktitle;
	}

	@Override
	public String toString() {
		return "alram [asktitle=" + asktitle + ", f_num=" + f_num + "]";
	}

	
}
