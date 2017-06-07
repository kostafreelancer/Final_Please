package lancer.total.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	
	private String url = "";

	private List<String> news = new ArrayList<String>();

	public List<String> scrap_method() {
		
		try {
			url = "http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105"; // 신문기사
			Document doc = Jsoup.connect(url).get(); // document 객체 생성.
			Elements ele = doc.select(".sphoto1");

			for(int i=0; i<ele.size();i++){
				news.add(ele.get(i).html());

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return news;
	}

}
