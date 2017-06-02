package lancer.e_main.domain;

public class Newslist {
	
	String img;
	String title;
	String txt;
	
	public Newslist(){}
	
	public Newslist(String img, String title, String txt) {
		this.img = img;
		this.title = title;
		this.txt = txt;
	}
	
	public Newslist(String img, String txt){
		this.img = img;
		this.txt = txt;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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
		return "Newslist [img=" + img + ", title=" + title + ", txt=" + txt + "]";
	}


}
