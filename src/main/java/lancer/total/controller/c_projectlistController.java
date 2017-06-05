package lancer.total.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lancer.c_projectlist.domain.PageMaker;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.e_insertproject.domain.E_Insert;
import lancer.total.service.c_projectlistService;

@Controller
@RequestMapping("/c_projectlist/*")
public class c_projectlistController {
	
	@Inject
	c_projectlistService service;
	
	@RequestMapping(value = "/c_projectlist", method = RequestMethod.GET)
	public void projectlistGET(@ModelAttribute("cri") SearchCriteria cri,Model model,HttpSession session) throws Exception{
		
		model.addAttribute("list", service.listSearch(cri));
		PageMaker pageMaker =  new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	@RequestMapping(value="/c_readpage", method= RequestMethod.GET)
	public void readPage(@ModelAttribute("cri") SearchCriteria cri,@RequestParam("e_pr_num") int e_pr_num, Model model) throws Exception{
		model.addAttribute(service.read(e_pr_num));
	}
	

}
