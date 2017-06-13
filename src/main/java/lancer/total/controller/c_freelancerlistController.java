package lancer.total.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lancer.c_freelancerlist.domain.c_freelancerlist_PageMaker;
import lancer.c_freelancerlist.domain.c_freelancerlist_SearchCriteria;
import lancer.c_freelancerlist.domain.c_freelancerlist_careerVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_projectlist.domain.Contract;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.c_projectlist.domain.SubmitVO;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_mypage.domain.Project;
import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.FinishProject;
import lancer.f_mypage.domain.School;
import lancer.total.service.c_freelancerlistService;

@Controller
@RequestMapping("/c_freelancerlist/*")
public class c_freelancerlistController {
	
	@Inject
	c_freelancerlistService service; 
	
	@RequestMapping("/f_list")
	public void f_list(@ModelAttribute("cri") c_freelancerlist_SearchCriteria cri,HttpServletRequest request,Model model,@ModelAttribute("reset") String reset) throws Exception{
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
		
		List<Career> career = service.showCareerInfo(f_num);
		List<School> school = service.showSchoolInfo(f_num);
		List<Certificate> certificate = service.showCertiInfo(f_num);
		
		List<Project> project = service.getMyFinishProject(f_num);
		List<FinishProject> finishProject  = new ArrayList<FinishProject>();
		for(int i=0; i<project.size(); i++){
			FinishProject fp = new FinishProject();
			fp.setProName(project.get(i).getP_name());
			fp.setProTerm(project.get(i).getP_startdate().substring(0, 10) + " ~ " + project.get(i).getP_enddate().substring(0, 10));
			fp.setCost(project.get(i).getP_uppercost());
			List<String> tempList = service.getProjectP_job(project.get(i).getE_pr_num());
			System.out.println(project.get(i).getE_pr_num());
			String temp = "";
			for(int j=0; j<tempList.size(); j++){
				temp += tempList.get(j) + ", ";
			}
			fp.setP_job(temp.substring(0, temp.length()-2));
			finishProject.add(fp);
		}
		
		
		if(career.size()==0){
			model.addAttribute("careercheck", "0");
		}else{
			model.addAttribute("career", career);
		}
		
		if(school.size()==0){
			model.addAttribute("schoolcheck", "0");
		}else{
			model.addAttribute("school", school);
		}
		
		if(certificate.size()==0){
			model.addAttribute("certificatecheck", "0");
		}else{
			model.addAttribute("certificate", certificate);
		}
		
		if(finishProject.size() == 0 ){
			model.addAttribute("finishprojectcheck", "0");
		}else{
			model.addAttribute("finishproject", finishProject);
		}
	}
	
	@RequestMapping(value="/f_complete", method= RequestMethod.POST)
	@ResponseBody
		public List<E_Insert> readPagePOST(HttpServletResponse response ,HttpSession session, Model model) throws Exception{
		System.out.println("들어옴?");
		int e_num = ((c_login_enterpriseVO)(session.getAttribute("client"))).getE_num();
		List<E_Insert> list = service.getProject(e_num);
		return list;
		/*SubmitVO submitVO = new SubmitVO();
			
			E_Insert project = (E_Insert)session.getAttribute("project");
			submitVO.setE_pr_num(project.getE_pr_num());
			submitVO.setF_num(f_num);
			
			model.addAttribute("contract", session.getAttribute("contract"));
			
			int c_num = service.getnum()+1;
			submitVO.setC_num(c_num);
			
			contract.setC_num(c_num);
			
			service.insertContract(submitVO);*/
			
			
		}
	

}
