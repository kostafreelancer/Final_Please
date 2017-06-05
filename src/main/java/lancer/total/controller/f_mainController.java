package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lancer.f_main.domain.member;
import lancer.total.service.f_mainService;

@Controller
@RequestMapping("/f_main/*")
public class f_mainController {

	@Inject
	f_mainService service;
	
	@RequestMapping(value="/f_main", method = RequestMethod.GET)
	public void f_mainGET(Model model, member m) throws Exception{
		
		service.getF_info(m);
		service.countFreelancer(); // 활동중인 총 프리랜서 숫자
		service.countProject(); // 등록된 총 프로젝트 숫자
		
		System.out.println(service.countFreelancer() + "프리랜서 숫자");
		System.out.println(service.countProject() + "등록된 프로젝트 숫자");
		System.out.println("??");
		model.addAttribute("m", m);
		model.addAttribute("count", service.countFreelancer());
		model.addAttribute("countP", service.countProject());
	}
	
/*	@RequestMapping(value="/f_main", method = RequestMethod.POST)
	public void f_mainPOST(member m , Model model) throws Exception{
		service.getF_info(m);
		service.countFreelancer(); // 활동중인 총 프리랜서 숫자
		service.countProject(); // 등록된 총 프로젝트
		
		System.out.println(m.getF_name() + "이름");
		System.out.println(service.countFreelancer() + "프리랜서 숫자");
		System.out.println(service.countProject() + "등록된 프로젝트 숫자");
		
		model.addAttribute("count", service.countFreelancer());
		model.addAttribute("countP", service.countProject());
		model.addAttribute("m", m);
	}*/
	
}
