package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lancer.c_freelancerlist.domain.c_freelancerlist_careerVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.total.service.c_freelancerlistService;

@Controller
@RequestMapping("/c_freelancerlist/*")
public class c_freelancerlistController {
	
	@Inject
	c_freelancerlistService service;
	
	@RequestMapping("/f_list")
	public void f_list(Model model){
		
		List<c_freelancerlist_totalVO> list = service.c_freelancerlist_select_basic();
		System.out.println(list.get(2).getList_career().get(0).getDept()+"여기 나와야되");
		model.addAttribute("totallists", list);
	}

}
