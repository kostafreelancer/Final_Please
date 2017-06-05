package lancer.total.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lancer.total.service.C_TempService;

@Controller
@RequestMapping("/c_temp/*")
public class C_TempController {

	@Inject
	private C_TempService service;
	
	@RequestMapping(value = "/c_temp", method = RequestMethod.GET)
	public void c_tempGET(Model model,HttpSession session)throws Exception{
		model.addAttribute("listFreelancer", service.listFreelancer());
		model.addAttribute("listEnterprise", service.listEnterprise());
		model.addAttribute("listEnterprisePermit", service.listEnterprisePermit());
		
		
	}
}
