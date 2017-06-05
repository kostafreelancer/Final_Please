package lancer.total.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lancer.e_main.domain.Newslist;
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
		
		List<String> newspack1 = crawler.newscrw1();
		List<String> newspack2 = crawler.newscrw2();
		
		model.addAttribute("news_pack1", newspack1);
		model.addAttribute("news_pack2", newspack2);
		
		model.addAttribute("freelancerNum", e_mainService.countFreelancer());
		model.addAttribute("projectNum", e_mainService.countProject());
	}

}
