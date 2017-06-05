package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lancer.c_login.domain.c_login_freelancerVO;
import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.Freelancer;
import lancer.f_mypage.domain.School;
import lancer.total.service.F_MypageService;

@Controller
@RequestMapping("/f_mypage")
public class F_MypageController {
	
	@Inject
	private F_MypageService service;
	
	@RequestMapping(value="/myInfo", method = RequestMethod.GET)
	public void myInfo(Model model, HttpSession session) throws Exception{
		System.out.println(session);
		System.out.println(session.getAttribute("client"));
		c_login_freelancerVO freelancer = (c_login_freelancerVO) session.getAttribute("client");
		
		model.addAttribute("freelancer", freelancer);
		
		String[] ph = freelancer.getF_phone().split("-");
		for(int i=0;i<ph.length; i++){
			model.addAttribute("ph"+(i+1), ph[i]);
		}
		String[] hph = freelancer.getF_hphone().split("-");
		for(int i=0;i<hph.length; i++){
			model.addAttribute("hph"+(i+1), hph[i]);
		}
		String[] email = freelancer.getF_email().split("@");
		for(int i=0; i<email.length; i++){
			model.addAttribute("email" + (i+1), email[i]);
		}
		String[] address = freelancer.getF_address().split("&");
		for(int i=0; i<address.length; i++){
			model.addAttribute("address" + (i+1), address[i]);
		}
	
		
		List<Integer> joblist = service.showFreelancerJobInfo(3);
		model.addAttribute("joblist", joblist);
		
		List<Career> career = service.showCareerInfo(3);
		List<School> school = service.showSchoolInfo(3);
		List<Certificate> certificate = service.showCertiInfo(3);
		List<ApplyProject> applyproject = service.getApplyProject(3);
		for(int i=0; i<applyproject.size(); i++){
			System.out.println(i);
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
		
		if(applyproject.size()==0){
			model.addAttribute("applyprojectcheck", "0");
		}else{
			model.addAttribute("applyproject", applyproject);
		}
	}
	
	@RequestMapping(value="/updateInfo", method=RequestMethod.POST)
	public String updateFreelancerInfo(Freelancer freelancer, Model model) throws Exception{
		System.out.println("우에에");
		String my_pwd = service.getFreelancerPassword(3);
	
		/*if(!freelancer.getF_pwd().equals(my_pwd)){
			model.addAttribute("pwd_error", "error");
			return "redirect:/myInfo";
		}else{
			if(freelancer.getTemp_sex()==1){
				freelancer.setF_sex("남");
			}else{
				freelancer.setF_sex("여");
			}
			String f_hphone = freelancer.getFm_phone1() + "-" + freelancer.getFm_phone2() + "-" + freelancer.getFm_phone3(); 
			freelancer.setF_hphone(f_hphone);
			String f_phone = freelancer.getFm_tel1() + "-" + freelancer.getFm_tel2() + "-" + freelancer.getFm_tel3(); 
			freelancer.setF_phone(f_phone);
			String f_email = freelancer.getFm_email11() + "@" + freelancer.getFm_email12();
			freelancer.setF_email(f_email);
			String f_address = freelancer.getFm_zip() + "&" + freelancer.getFm_address() + "&" + freelancer.getFm_address_etc();
			freelancer.setF_address(f_address);
			
			
			service.updateFreelancerInfo(freelancer);*/
			
			/*String checkArr[] = request.getParameterValues("fm_new_keyword[]");
			service.deleteFreelancerJobInfo(freelancer.getF_num());
			int total=0;
			for(int i=0; i<checkArr.length; i++){
				total += dao.insertFreelancerJobInfo(new F_job(f_num, Integer.parseInt(checkArr[i])));
			}*/
			
/*
			if(re>0 && total==checkArr.length){
				forward.setRedirect(true);
				forward.setPath("/Matching_Project/f_mypage/updateSuccess.jsp");
			}else{
				forward.setRedirect(true);
				forward.setPath("/Matching_Project/f_mypage/updateSuccess.jsp?f_num="+freelancer.getF_num());
			}*/
			return "redirect:/updateSuccess";
		//}
	}
	
	
	@RequestMapping(value = "/scheduleManager", method = RequestMethod.GET)
	public void scheduleManager(Model model, HttpSession session) throws Exception{
		model.addAttribute("proName", service.getMyProjectName(3));
		model.addAttribute("scheduleList", service.getMySchedule(3));	
	}
}
