/*package lancer.total.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawler {
	

	public void crw() {
		
		
		try {
			Document doc = Jsoup.connect("http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105").get();
			Elements links = doc.select("");
			for(Element e : links){
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
	
}*/

package lancer.total.util;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Crawler {
	
	private String url = "";
	
	private List<String> imglist = new ArrayList<String>();
	
	private List<String> ttl_addr_list = new ArrayList<String>();
	private List<String> titlelist = new ArrayList<String>();
	private List<String> txtlist = new ArrayList<String>();
	
	public List<String> imgcrw() {
		
		try {
			url = "http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105"; // 신문기사
			Document doc = Jsoup.connect(url).get(); // document 객체 생성.
			Elements img = doc.select(".photo img");

			for(int i=0;i<img.size();i++){
				imglist.add(img.get(i).attr("src"));
				
				System.out.println("img: ");
				System.out.println(imglist.get(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return imglist;
	}
	
	public List<String> ttl_addr_crw() {
		
		try {
			url = "http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105"; // 신문기사
			Document doc = Jsoup.connect(url).get(); // document 객체 생성.
			
			Elements title = doc.select(".sphoto1 dt:eq(1) a");
			
			for(int i=0;i<title.size();i++){
				ttl_addr_list.add(title.get(i).attr("href"));
				System.out.println("title-href: ");
				System.out.println(ttl_addr_list.get(i));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ttl_addr_list;
	}
	
	public List<String> titlecrw() {
		
		try {
			url = "http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105"; // 신문기사
			Document doc = Jsoup.connect(url).get(); // document 객체 생성.
			
			Elements title = doc.select(".sphoto1 dt:eq(1) a");

			for(int i=0;i<title.size();i++){
				titlelist.add(title.get(i).text());
				System.out.println("title: ");
				System.out.println(titlelist.get(i));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return titlelist;
	}
		public List<String> txtcrw() {
			
			try {
				url = "http://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=105"; // 신문기사
				Document doc = Jsoup.connect(url).get(); // document 객체 생성.

				Elements txt = doc.select(".sphoto1 dd");
				
				for(int i=0;i<txt.size();i++){
					txtlist.add(txt.get(i).text());	
					System.out.println("txt: ");
					System.out.println(txtlist.get(i));
				}
			
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return txtlist;
	}

}
