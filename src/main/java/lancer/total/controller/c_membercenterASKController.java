package lancer.total.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lancer.c_membercenter.domain.MembercenterASKVO;
import lancer.total.service.c_membercenterASKService;

@Controller
@RequestMapping("/c_membercenter/*")
public class c_membercenterASKController {

	
	@Inject
	private c_membercenterASKService service;
	
	@RequestMapping(value="/member_centerMain", method = RequestMethod.GET)
	public void insertAsk(MembercenterASKVO vo, Model model) throws Exception{
		System.out.println("고객센타");
	}
	
	@RequestMapping(value="/member_centerMain", method = RequestMethod.POST)
	public String insertAskPOST(MembercenterASKVO vo, Model model) throws Exception{
		System.out.println("문의POST");
		
		System.out.println(vo.toString());
		service.insertAsk(vo);
		
		model.addAttribute("result", "success");
		
		return "redirect:/c_membercenter/member_centerMain";
	}
	
}
