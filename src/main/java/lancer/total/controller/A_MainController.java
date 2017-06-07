package lancer.total.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lancer.total.service.A_MainService;
import lancer.total.service.C_DropService;

@Controller
@RequestMapping("/a_main/*")
public class A_MainController {

	@Inject
	private A_MainService service;
	
	@Inject
	private C_DropService dropService;
	
	@RequestMapping(value = "/a_main", method = RequestMethod.GET)
	public void a_mainGET(Model model,HttpSession session)throws Exception{
		
		model.addAttribute("listFreelancer", service.listFreelancer());
		model.addAttribute("listEnterprise", service.listEnterprise());
		model.addAttribute("listEnterprisePermit", service.listEnterprisePermit());
		
	}
	
	@RequestMapping(value = "/a_deleteF", method = RequestMethod.POST)
	public String a_deleteFPOST(@RequestParam("deleteF_num") int deleteF_num)throws Exception{
		dropService.deleteFreelancer(deleteF_num);
		
		return "redirect:/a_main/a_main";
	}
	
	@RequestMapping(value = "/a_deleteE", method = RequestMethod.POST)
	public String a_deleteEPOST(@RequestParam("deleteE_num") int deleteE_num)throws Exception{
		dropService.deleteEnterprise(deleteE_num);
		
		return "redirect:/a_main/a_main";
	}
	
	@RequestMapping(value = "/a_permit", method = RequestMethod.POST)
	public String a_permitPOST(@RequestParam("permitE_num") int permitE_num)throws Exception{
		service.permitAccount(permitE_num);
		
		return "redirect:/a_main/a_main";
	}
}
