package lancer.total.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lancer.total.service.e_MainService;
import lancer.total.util.Crawler;

@Controller
@RequestMapping("/e_main/*")
public class e_mainController {

	@Inject
	private e_MainService e_mainService;
	
	@RequestMapping(value="/e_main", method = RequestMethod.GET)
	public void e_mainControl(Model model) throws Exception{
		
		Crawler crawler = new Crawler();
		
		List<String> newslist = crawler.scrap_method();
		
		List<String> newspack = new ArrayList<String>();
		List<String> newspack2= new ArrayList<String>();
		
		
		for(int i=0; i<(newslist.size()/2);i++){
			newspack.add(newslist.get(i*2));
			newspack2.add(newslist.get(i*2+1));
		}
		
		if((newslist.size()%2)!=0){
			newspack.add(newslist.get(newslist.size()-1));
		}
		model.addAttribute("news_pack", newspack);
		model.addAttribute("news_pack2", newspack2);
		
		model.addAttribute("freelancerNum", e_mainService.countFreelancer());
		model.addAttribute("projectNum", e_mainService.countProject());
	}

}
