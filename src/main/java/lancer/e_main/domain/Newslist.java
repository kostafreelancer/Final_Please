package lancer.e_main.domain;

public class Newslist {
	
	String img;
	
	String ttl_addr;
	String title;
	
	String txt;
	
	public Newslist(){}

	public Newslist(String img, String ttl_addr, String title, String txt) {
		super();
		this.img = img;
		this.ttl_addr = ttl_addr;
		this.title = title;
		this.txt = txt;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTtl_addr() {
		return ttl_addr;
	}

	public void setTtl_addr(String ttl_addr) {
		this.ttl_addr = ttl_addr;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTxt() {
		return txt;
	}

	public void setTxt(String txt) {
		this.txt = txt;
	}

	@Override
	public String toString() {
		return "Newslist [img=" + img + ", ttl_addr=" + ttl_addr + ", title=" + title + ", txt=" + txt + "]";
	}
	
	
}
