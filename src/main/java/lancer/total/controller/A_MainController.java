package lancer.total.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lancer.total.service.A_MainService;

@Controller
@RequestMapping("/a_main/*")
public class A_MainController {

	@Inject
	private A_MainService service;
	
	@RequestMapping(value = "/a_main", method = RequestMethod.GET)
	public void a_mainGET(Model model,HttpSession session)throws Exception{
		
		model.addAttribute("listFreelancer", service.listFreelancer());
		model.addAttribute("listEnterprise", service.listEnterprise());
		model.addAttribute("listEnterprisePermit", service.listEnterprisePermit());
		
	}
}
