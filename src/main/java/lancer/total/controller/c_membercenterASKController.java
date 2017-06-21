package lancer.total.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public String insertAskPOST(MembercenterASKVO vo, Model model, HttpSession session) throws Exception{
		System.out.println("문의POST + ajax");
		
		
		/*String check = (String) session.getAttribute("f_num");*/
		/*checking_identity identity = (checking_identity) session.getAttribute("identity");
		
		if(identity.equals("enterprise")){
			service.insertAsk(vo);
			model.addAttribute("e_num", vo.getE_num());
		}else if(identity.equals("freelancer")){
			service.insertAsk(vo);
			model.addAttribute("f_num", vo.getF_num());
		}*/
		
		service.insertAsk(vo);
		
		System.out.println(vo.toString()+213312);
		
		/*model.addAttribute("f_num", vo.getF_num());*/
		
		return "redirect:/c_membercenter/member_centerMain";
		
	}
	

	@RequestMapping(value="/member_centerMain", method = RequestMethod.GET)
	public void myAskList(Model model, HttpSession session) throws Exception{
		checking_identity identity = (checking_identity) session.getAttribute("identity");
		int num1 = 0;
		int num2 = 0;
		
		if(identity.getIdentity().equals("freelancer")){
			c_login_freelancerVO vo = (c_login_freelancerVO) session.getAttribute("client");
			num1 = vo.getF_num();
			num2 = vo.getF_num();
			System.out.println(num1+"프리번호");
			model.addAttribute("list", service.myAskList(num1));
			model.addAttribute("OKlist", service.myAskListOK(num2));
		}else if(identity.getIdentity().equals("enterprise")){
			c_login_enterpriseVO vo = (c_login_enterpriseVO) session.getAttribute("client");
			num1 = vo.getE_num();
			num2 = vo.getE_num();
			System.out.println(num1+"기업번호");
			model.addAttribute("list",service.e_myAskList(num1));
			model.addAttribute("Oklist", service.e_myAskListOK(num1));
		}else{
			model.addAttribute("list",service.e_myAskList(num1));
		}
		
		System.out.println("리스트");
		/*System.out.println(asknum + "문의번호");*/
		
		 
	}
	
	@RequestMapping(value="/myAnswer", method = RequestMethod.GET)
	public void myAnswerGET(Model model, @RequestParam("asknum") int asknum) throws Exception{
		System.out.println("답변확인 GET");
		
		
		
	
	}
	
	
	@RequestMapping(value="/myAnswer", method = RequestMethod.POST)
	public void myAnswerPOST(Model model) throws Exception{
		System.out.println("답변확인!");
	}
	
}
