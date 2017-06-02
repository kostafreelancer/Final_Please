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
		List<String> imglist = crawler.imgcrw();
		List<String> titlelist = crawler.titlecrw();
		List<String> txtlist = crawler.txtcrw();
		
	/*	model.addAttribute("news_img", imglist);
		model.addAttribute("news_title", titlelist);
		model.addAttribute("news_txt", txtlist);*/
		
		Newslist newslist = new Newslist();
		
		List<Newslist> list = new ArrayList<Newslist>();
		
		for(int i=0; i<imglist.size();i++){
			list.add(new Newslist(imglist.get(i), txtlist.get(i)));
			/*newslist.setImg(imglist.get(i));
			newslist.setTitle(titlelist.get(i));
			newslist.setTxt(txtlist.get(i));*/
			
			System.out.println(newslist + "aaa");
			/*list.add(newslist);*/
		}
		model.addAttribute("news_list", list);
		
		model.addAttribute("freelancerNum", e_mainService.countFreelancer());
		model.addAttribute("projectNum", e_mainService.countProject());
	}

}
