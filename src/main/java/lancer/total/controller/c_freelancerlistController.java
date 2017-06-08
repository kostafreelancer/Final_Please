package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@RequestMapping(value="/f_readpage", method= RequestMethod.GET)
	public void readPage(@ModelAttribute("cri") SearchCriteria cri,@RequestParam("f_num") int f_num, Model model) throws Exception{
		
		//개인정보 구하기
		c_freelancerlist_totalVO freelancer = service.selectFreelancer(f_num);
		model.addAttribute("freelancer", freelancer);

		String[] ph = freelancer.getF_phone().split("-");
		model.addAttribute("ph1", ph[0]);
		model.addAttribute("ph2", ph[1]);
		model.addAttribute("ph3", ph[2]);
		
		String[] hph = freelancer.getF_hphone().split("-");
		model.addAttribute("hph1", hph[0]);
		model.addAttribute("hph2", hph[1]);
		model.addAttribute("hph3", hph[2]);
		
		String[] email = freelancer.getF_email().split("@");
		model.addAttribute("email1", email[0]);
		model.addAttribute("email2", email[1]);
		
		String[] address = freelancer.getF_address().split("&");
		model.addAttribute("address1", address[0]);
		model.addAttribute("address2", address[1]);
		model.addAttribute("address3", address[2]);
		
		//상세분야 구하기
		List<Integer> f_job =service.selectF_job(f_num);
		model.addAttribute("f_job", f_job);
	}
	

}
