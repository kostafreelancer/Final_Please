package lancer.total.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lancer.c_login.domain.c_login_freelancerVO;
import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.CalEvent;
import lancer.f_mypage.domain.Calendar;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.F_job;
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
	
	@RequestMapping(value="/myInfo", method=RequestMethod.POST)
	public String updateFreelancerInfo(Freelancer freelancer,RedirectAttributes rttr, Model model, HttpSession session, HttpServletRequest request) throws Exception{
		System.out.println(freelancer.getF_sex());
		c_login_freelancerVO original =  (c_login_freelancerVO) session.getAttribute("client");
		String my_pwd = original.getF_pwd();
		System.out.println(my_pwd);
		if(!freelancer.getF_pwd().equals(my_pwd)){
			rttr.addFlashAttribute("pwd_error", "error");
			return "redirect:/f_mypage/myInfo";
		}else{
			if(freelancer.getF_sex().equals("1")){
				original.setF_sex("남");
			}else{
				original.setF_sex("여");
			}
			
			String f_hphone = freelancer.getFm_phone1() + "-" + freelancer.getFm_phone2() + "-" + freelancer.getFm_phone3(); 
			original.setF_hphone(f_hphone);
			String f_phone = freelancer.getFm_tel1() + "-" + freelancer.getFm_tel2() + "-" + freelancer.getFm_tel3(); 
			original.setF_phone(f_phone);
			String f_email = freelancer.getFm_email11() + "@" + freelancer.getFm_email12();
			original.setF_email(f_email);
			String f_address = freelancer.getFm_zip() + "&" + freelancer.getFm_address() + "&" + freelancer.getFm_address_etc();
			original.setF_address(f_address);
			
			original.setF_name(freelancer.getF_name());
			original.setF_birth(freelancer.getF_birth());
			original.setF_fname(freelancer.getF_fname());
			service.updateFreelancerInfo(original);
			session.setAttribute("client", original);
			
			String checkArr[] = request.getParameterValues("fm_new_keyword[]");
			service.deleteFreelancerJobInfo(original.getF_num());
			int f_num = original.getF_num();
			for(int i=0; i<checkArr.length; i++){
				service.insertFreelancerJobInfo(new F_job(f_num, Integer.parseInt(checkArr[i])));
			}
			
/*
			if(re>0 && total==checkArr.length){
				forward.setRedirect(true);
				forward.setPath("/Matching_Project/f_mypage/updateSuccess.jsp");
			}else{
				forward.setRedirect(true);
				forward.setPath("/Matching_Project/f_mypage/updateSuccess.jsp?f_num="+freelancer.getF_num());
			}*/
			return "redirect:/f_mypage/updateSuccess";
			}
	}
	
	@RequestMapping(value="/updateSuccess")
	public void updateSuccess(){
		
	}
	
	
	@RequestMapping(value = "/scheduleManager", method = RequestMethod.GET)
	public void scheduleManager(Model model, HttpSession session) throws Exception{
		c_login_freelancerVO freelancer = (c_login_freelancerVO) session.getAttribute("client");
		int f_num = freelancer.getF_num();
		model.addAttribute("proName", service.getMyProjectName(f_num));
		model.addAttribute("scheduleList", service.getMySchedule(f_num));	
	}
	
	@RequestMapping(value="/scheduleInfoAjax")
	public @ResponseBody List<CalEvent> scheduleInfoAjax(@RequestParam("num") int num) throws Exception{
			System.out.println(num);
			List<Calendar> scheduleList = service.getMySchedule(num);	
			
			List<CalEvent> ceList = new ArrayList<CalEvent>();
			for(int i=0; i<scheduleList.size(); i++){
				CalEvent ce = new CalEvent();
				ce.setTitle(scheduleList.get(i).getContents());
				ce.setStart(scheduleList.get(i).getStartdate());
				ce.setEnd(scheduleList.get(i).getEnddate());
				System.out.println(ce.getStart());
				System.out.println(ce.getEnd());
				ceList.add(ce);
			}
			return ceList;
	}
	
	@RequestMapping(value="/scheduleAdd", method=RequestMethod.GET)
	public void scheduleAdd() throws Exception{
	}
	
	@RequestMapping(value="/scheduleAdd", method=RequestMethod.POST)
	public String scheduleAdd(Calendar calen, HttpSession session, Model model) throws Exception{
		System.out.println("컨트롤러 들어오셨어요?");
		//c_login_freelancerVO freelancer = (c_login_freelancerVO) session.getAttribute("client");
		//int f_num = freelancer.getF_num();
		//calen.setF_num(f_num);
		calen.setCalendar_num(service.getScheduleNum()+1);
		service.insertMySchedule(calen);
		return "/f_mypage/scheduleManager";
	}
	
	@RequestMapping(value="/scheduleModify", method=RequestMethod.GET)
	public void scheduleModify(@RequestParam("title") String title, @RequestParam("syear") String syear,  @RequestParam("smonth") String smonth, @RequestParam("sdate") String sdate, @RequestParam("eyear") String eyear, @RequestParam("emonth") String emonth, @RequestParam("edate") String edate, @RequestParam("f_num") int f_num) throws Exception{
		
		System.out.println("들어온거 맞아?");
		System.out.println(title);
		System.out.println(syear);
		System.out.println(smonth);
		System.out.println(sdate);
		System.out.println(syear);
		System.out.println(emonth);
		System.out.println(edate);
		if(smonth.length()==1){
			smonth = "0"+smonth;
		}if(emonth.length()==1){
			emonth = "0"+emonth;
		}
		
		String start = syear.substring(2) +"/" + smonth + "/" + sdate;
		String end = eyear.substring(2) +"/" + emonth + "/" + edate;
		Calendar cal = new Calendar();
		cal.setF_num(f_num);
		cal.setContents(title);
		cal.setStartdate(start);
		cal.setEnddate(end);
		service.updateMySchedule(cal);
	}
	
	@RequestMapping(value="/scheduleDelete", method=RequestMethod.GET)
	public String scheduleDelete(@RequestParam("title") String title, @RequestParam("f_num") int f_num) throws Exception{
		Calendar cal = new Calendar();
		cal.setContents(title);
		cal.setF_num(f_num);
		service.deleteMySchedule(cal);
		return "/f_mypage/scheduleManager";
	}
	
}
