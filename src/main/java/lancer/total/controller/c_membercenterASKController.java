package lancer.total.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_login.domain.checking_identity;
import lancer.c_membercenter.domain.MembercenterASKVO;
import lancer.total.service.c_membercenterASKService;

@Controller
@RequestMapping("/c_membercenter/*")
public class c_membercenterASKController {

	
	@Inject
	private c_membercenterASKService service;
	
	/*@RequestMapping(value="/member_centerMain", method = RequestMethod.GET)
	public void insertAsk(MembercenterASKVO vo, Model model) throws Exception{
		System.out.println("고객센타");
	}*/
	
	@RequestMapping(value="/member_centerMain", method = RequestMethod.POST)
	public String insertAskPOST(MembercenterASKVO vo, Model model) throws Exception{
		System.out.println("문의POST");
		
		System.out.println(vo.toString());
		service.insertAsk(vo);
		
		model.addAttribute("f_num", vo.getF_num());
		
		return "redirect:/c_membercenter/member_centerMain";
	}
	

	@RequestMapping(value="/member_centerMain", method = RequestMethod.GET)
	public void myAskList(Model model, HttpSession session) throws Exception{
		checking_identity identity = (checking_identity) session.getAttribute("identity");
		int num = 0;
		
		if(identity.getIdentity().equals("freelancer")){
			c_login_freelancerVO vo = (c_login_freelancerVO) session.getAttribute("client");
			num = vo.getF_num();
			model.addAttribute("list", service.myAskList(num));
		}else if(identity.getIdentity().equals("enterprise")){
			c_login_enterpriseVO vo = (c_login_enterpriseVO) session.getAttribute("client");
			num = vo.getE_num();
			model.addAttribute("list",service.e_myAskList(num));
		}
		
		System.out.println("리스트");
		
		
	}
	
}
