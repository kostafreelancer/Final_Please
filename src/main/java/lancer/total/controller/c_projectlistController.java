package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lancer.c_projectlist.domain.PageMaker;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_insertproject.domain.Enterprise;
import lancer.total.service.c_projectlistService;

@Controller
@RequestMapping("/c_projectlist/*")
public class c_projectlistController {
	
	@Inject
	c_projectlistService service;
	
	@RequestMapping(value = "/c_projectlist")
	public void projectlistGET(@ModelAttribute("cri") SearchCriteria cri,Model model,HttpSession session,HttpServletRequest request) throws Exception{
		String[] job = request.getParameterValues("fm_new_keyword[]");
		
		if(cri.getJobs()==null){
			cri.setJobs(job);
		}
		/*if(reset.equals("reset")){
			cri.setJobs(null);
		}*/
		List<E_Insert> list = service.listSearch(cri);
		if(cri.getJobs()!=null){
			String str[] =cri.getJobs();
			for(int i=0;i<cri.getJobs().length;i++){
				
				System.out.println(str[i]);
			}
		}else{
			cri.setJobs(job);
		}
		
		model.addAttribute("list", list);
		PageMaker pageMaker =  new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	@RequestMapping(value="/c_readpage", method= RequestMethod.GET)
	public void readPage(@ModelAttribute("cri") SearchCriteria cri,@RequestParam("e_pr_num") int e_pr_num,@RequestParam("e_num") int e_num, Model model) throws Exception{
		
		//담당자정보 구하기
		Enterprise enterprise = service.selectEnterprise(e_num);
		model.addAttribute("enterprise", enterprise);
		
		String[] manager_hphone = enterprise.getManager_hphone().split("-");
		model.addAttribute("manager_hphone_1", manager_hphone[0]);
		model.addAttribute("manager_hphone_2", manager_hphone[1]);
		model.addAttribute("manager_hphone_3", manager_hphone[2]);
		
		String[] manager_mail = enterprise.getManager_mail().split("@");
		model.addAttribute("manager_mail_1", manager_mail[0]);
		model.addAttribute("manager_mail_2", manager_mail[1]);
		
		//프로젝트 정보구하기
		E_Insert project = service.read(e_pr_num);
	    model.addAttribute("project", project);
				
		//상세분야 구하기
		List<Integer> p_job = service.selectP_job(e_pr_num);
		model.addAttribute("p_job", p_job);
	}
	

}
