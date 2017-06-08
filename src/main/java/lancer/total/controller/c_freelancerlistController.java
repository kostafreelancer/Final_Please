package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import lancer.c_freelancerlist.domain.c_freelancerlist_PageMaker;
import lancer.c_freelancerlist.domain.c_freelancerlist_SearchCriteria;
import lancer.c_freelancerlist.domain.c_freelancerlist_careerVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.total.service.c_freelancerlistService;

@Controller
@RequestMapping("/c_freelancerlist/*")
public class c_freelancerlistController {
	
	@Inject
	c_freelancerlistService service; 
	
	@RequestMapping("/f_list")
	public void f_list(@ModelAttribute("cri") c_freelancerlist_SearchCriteria cri,HttpServletRequest request,Model model,@ModelAttribute("reset") String reset){
		String[] job = request.getParameterValues("fm_new_keyword[]");
		if(cri.getJobs()==null){
			cri.setJobs(job);
		}
		if(reset.equals("reset")){
			cri.setJobs(null);
		}
		List<c_freelancerlist_totalVO> list = service.c_freelancerlist_select_basic(cri);
		if(cri.getJobs()!=null){
			String str[] =cri.getJobs();
			for(int i=0;i<cri.getJobs().length;i++){
				
				System.out.println(str[i]);
			}
		}else{
			cri.setJobs(job);
		}
		//주석주석
		model.addAttribute("totallists", list);
		c_freelancerlist_PageMaker pageMaker = new c_freelancerlist_PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.c_freelancerlist_totalCount(cri));
		model.addAttribute("pageMaker", pageMaker);
		
	}
	@RequestMapping("/pading")
	public String pading(@ModelAttribute("cri") SearchCriteria cri){
		System.out.println(cri.getPageStart()+" : "+cri.getPerPageNum());
		return null;
	}
	

}
