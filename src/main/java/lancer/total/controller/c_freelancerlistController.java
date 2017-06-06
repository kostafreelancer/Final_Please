package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lancer.c_freelancerlist.domain.c_freelancerlist_PageMaker;
import lancer.c_freelancerlist.domain.c_freelancerlist_SearchCriteria;
import lancer.c_freelancerlist.domain.c_freelancerlist_careerVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.total.service.c_freelancerlistService;

@Controller
@RequestMapping("/c_freelancerlist/*")
public class c_freelancerlistController {
	
	@Inject
	c_freelancerlistService service;
	
	@RequestMapping("/f_list")
	public void f_list(Model model,@ModelAttribute("cri") c_freelancerlist_SearchCriteria cri){
		
		List<c_freelancerlist_totalVO> list = service.c_freelancerlist_select_basic(cri);
		c_freelancerlist_PageMaker pageMaker = new c_freelancerlist_PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.c_freelancerlist_totalCount());
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("totallists", list);
	}
	@RequestMapping("/pading")
	public String pading(@ModelAttribute("cri") SearchCriteria cri){
		System.out.println(cri.getPageStart()+" : "+cri.getPerPageNum());
		return null;
	}

}
