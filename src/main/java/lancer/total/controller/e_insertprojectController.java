package lancer.total.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_insertproject.domain.Enterprise;
import lancer.total.service.e_insertprojectService;

@Controller
@RequestMapping("/e_insertproject/*")
public class e_insertprojectController{
	
	@Inject
	private e_insertprojectService service;

	@RequestMapping(value = "/e_insertproject", method = RequestMethod.GET)
	public void insertprojectGET(Model model,HttpSession session) throws Exception{
		
		c_login_enterpriseVO enterprise = (c_login_enterpriseVO)session.getAttribute("client");
		model.addAttribute("client", session.getAttribute("client"));
		
		String[] manager_hphone = enterprise.getManager_hphone().split("-");
		model.addAttribute("manager_hphone_1", manager_hphone[0]);
		model.addAttribute("manager_hphone_2", manager_hphone[1]);
		model.addAttribute("manager_hphone_3", manager_hphone[2]);
		
		String[] manager_mail = enterprise.getManager_mail().split("@");
		model.addAttribute("manager_mail_1", manager_mail[0]);
		model.addAttribute("manager_mail_2", manager_mail[1]);
			
	
	}
	
	@RequestMapping(value = "/e_insertproject", method = RequestMethod.POST)
	public String insertprojectPOST(E_Insert project, HttpSession session, Model model, Map<String, Integer> map,
			@ModelAttribute("p_location1") String p_location1, @ModelAttribute("p_location2") String p_location2,@ModelAttribute("check") String check[]) throws Exception{
		
		model.addAttribute("project", session.getAttribute("project"));
	
		System.out.println(p_location1+p_location2+"주소야");
		project.setP_location(p_location1+p_location2);
		int e_pr_num = service.getnum()+1;
		map.put("e_pr_num", e_pr_num);
		project.setE_pr_num(e_pr_num);
		service.insertProject(project);

		model.addAttribute("map", session.getAttribute("map"));
		
		
		
		System.out.println(check.length+"사이즈");
		for(int i=0;i<check.length;i++)
		{
			if(map.get("job_id") == null){
				map.put("job_id", Integer.parseInt(check[i]));
			}else{
				map.replace("job_id", Integer.parseInt(check[i]));
			}
			System.out.println(map);
			service.insertP_Job(map);
		}

		
		return "/e_insertproject/e_finishproject";
	}

}
