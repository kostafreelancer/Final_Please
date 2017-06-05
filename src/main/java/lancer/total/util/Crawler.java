package lancer.total.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	
	private String url = "";

	private List<String> newspack1 = new ArrayList<String>();
	private List<String> newspack2 = new ArrayList<String>();
	
	public List<String> newscrw1() {
		
		try {
			url = "http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105"; // 신문기사
			Document doc = Jsoup.connect(url).get(); // document 객체 생성.
			//Elements ele1 = doc.select(".section_headline");
			Elements ele2 = doc.select(".headline_pht_small");
	
			//System.out.println(ele1);
			
			for(int i=0; i<ele2.size();i++){
				//newspack1.add(ele1.get(i).html());
				newspack1.add(ele2.get(i).html());
				
				//System.out.println("newspack1: "+ele1.get(i).html() +"\n"+ele2.get(i).html());
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return newspack1;
	}
	
	public List<String> newscrw2() {
		
		try {
			url = "http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105"; // 신문기사
			Document doc = Jsoup.connect(url).get(); // document 객체 생성.
			//Elements ele3 = doc.select(".section_headline");
			Elements ele4 = doc.select(".headline_subordi");
			
			//System.out.println(ele3+"\n"+ele4);
			
			for(int i=0; i<ele4.size();i++){
				//newspack2.add(ele3.get(i).html());
				newspack2.add(ele4.get(i).html());
				
				//System.out.println("newspack2: "+ele3.get(i).html()+"\n"+ele4.get(i).html());
			}
			System.out.println();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return newspack2;
	}

}
