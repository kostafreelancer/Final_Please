package lancer.total.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lancer.total.service.c_freelancerlistService;

@Controller
@RequestMapping("/c_freelancerlist/*")
public class c_freelancerlistController {
	@Inject
	private static c_freelancerlistService service;
	
	@RequestMapping("/f_list")
	public void f_list(){
		service.c_freelancerlist_select_basic();
	}
}
