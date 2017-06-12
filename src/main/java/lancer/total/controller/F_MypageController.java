package lancer.total.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lancer.c_login.domain.c_login_freelancerVO;
import lancer.e_mypage.domain.Project;
import lancer.f_mypage.domain.Accounting;
import lancer.f_mypage.domain.AccountingCommand;
import lancer.f_mypage.domain.ApplyProject;
import lancer.f_mypage.domain.CalEvent;
import lancer.f_mypage.domain.Calendar;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.F_job;
import lancer.f_mypage.domain.FinishProject;
import lancer.f_mypage.domain.Freelancer;
import lancer.f_mypage.domain.Portfolio;
import lancer.f_mypage.domain.PortfolioCommand;
import lancer.f_mypage.domain.School;
import lancer.total.service.C_DropService;
import lancer.total.service.C_FileService;
import lancer.total.service.F_MypageService;

@Controller
@RequestMapping("/f_mypage")
public class F_MypageController {

	
	@Inject
	private F_MypageService service;
	
	@Inject
	private C_DropService dropService;
	
	@Inject
	private C_FileService fileUploadService;
	
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
		List<Portfolio> portfolio = service.showPortfolioInfo(3);
		
		List<Project> project = service.getMyFinishProject(3);
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
		
		if(applyproject.size()==0){
			model.addAttribute("applyprojectcheck", "0");
		}else{
			model.addAttribute("applyproject", applyproject);
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
		
		if(portfolio.size()==0){
			model.addAttribute("portfoliocheck", "0");
		}else{

			model.addAttribute("portfolio", portfolio);
		}
		
		if(applyproject.size()==0){
			model.addAttribute("applyprojectcheck", "0");
		}else{
			model.addAttribute("applyproject", applyproject);
		}
		
		if(finishProject.size() == 0 ){
			model.addAttribute("finishprojectcheck", "0");
		}else{
			model.addAttribute("finishproject", finishProject);
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
	public void updateSuccess() throws Exception{
	}
	
	@RequestMapping(value="/dropFreelancer", method=RequestMethod.GET)
	public String dropFreelancer(@RequestParam("f_num") int f_num, HttpSession session) throws Exception{
		dropService.deleteFreelancer(f_num);
		session.invalidate();
		return "redirect:/f_main/f_main";
	}
	
	@RequestMapping(value="/careerAdd", method=RequestMethod.GET)
	public void careerAdd() throws Exception{
	}
	
	@RequestMapping(value="/careerAdd", method=RequestMethod.POST)
	public String careerAdd(Career career) throws Exception{
		career.setCareer_num(service.getCareerNum()+1);
		service.insertCareer(career);
		return "redirect:/f_mypage/updateSuccess";
	}
	
	@RequestMapping(value="/careerModify", method=RequestMethod.GET)
	public void careerModify() throws Exception{
	}
	
	@RequestMapping(value="/careerModify", method=RequestMethod.POST)
	public void careerModify(Career career, Model model) throws Exception{
		model.addAttribute("career", career);
	}
	
	@RequestMapping(value="/updateCareer", method=RequestMethod.POST)
	public String updateCareer(Career career) throws Exception{
		service.updateCareer(career);
		return "redirect:/f_mypage/updateSuccess";
	}
	@RequestMapping(value="/deleteCareer", method=RequestMethod.GET)
	public String deleteCareer(@RequestParam("deleteCareer_num") int career_num) throws Exception{
		service.deleteCareer(career_num);
		return "redirect:/f_mypage/updateSuccess";
	}
	
	
	@RequestMapping(value="/schoolAdd", method=RequestMethod.GET)
	public void schoolAdd() throws Exception{
	}
	
	@RequestMapping(value="/schoolAdd", method=RequestMethod.POST)
	public String schoolAdd(School school) throws Exception{
		school.setSchool_num(service.getSchoolNum()+1);
		service.insertSchool(school);
		return "redirect:/f_mypage/updateSuccess";
	}
	
	@RequestMapping(value="/schoolModify", method=RequestMethod.POST)
	public void schoolModify(School school, Model model) throws Exception{
		model.addAttribute("school", school);
	}
	
	@RequestMapping(value="/updateSchool", method=RequestMethod.POST)
	public String updateSchool(School school) throws Exception{
		service.updateSchool(school);
		return "redirect:/f_mypage/updateSuccess";
	}
	@RequestMapping(value="/deleteSchool", method=RequestMethod.GET)
	public String deleteSchool(@RequestParam("deleteSchool_num") int school_num) throws Exception{
		service.deleteSchool(school_num);
		System.out.println(school_num);
		return "redirect:/f_mypage/updateSuccess";
	}
	
	
	

	@RequestMapping(value="/certiAdd", method=RequestMethod.GET)
	public void certiAdd() throws Exception{
	}
	
	@RequestMapping(value="/certiAdd", method=RequestMethod.POST)
	public String certiAdd(Certificate certi) throws Exception{
		certi.setCertificate_num(service.getCertiNum()+1);
		service.insertCerti(certi);
		return "redirect:/f_mypage/updateSuccess";
	}
	@RequestMapping(value="/certiModify", method=RequestMethod.POST)
	public void certiModify(Certificate certi, Model model) throws Exception{
		model.addAttribute("certi", certi);
	}
	@RequestMapping(value="/updateCerti", method=RequestMethod.POST)
	public String updateCerti(Certificate certi) throws Exception{
		service.updateCerti(certi);
		return "redirect:/f_mypage/updateSuccess";
	}
	@RequestMapping(value="/deleteCerti", method=RequestMethod.GET)
	public String deleteCerti(@RequestParam("deleteCerti_num") int certi_num) throws Exception{
		service.deleteCerti(certi_num);
		return "redirect:/f_mypage/updateSuccess";
	}
	
	@RequestMapping(value="/portfolioAdd", method=RequestMethod.POST)
	public String portfolioAdd(PortfolioCommand portFolioCommand) throws Exception{
		System.out.println(portFolioCommand.getF_num());
		if(portFolioCommand.getPortfolio_num() == 0){
			
			System.out.println(portFolioCommand.getContents());
			System.out.println(portFolioCommand.getPortfile().getOriginalFilename());
			
			Portfolio portfolio = new Portfolio();
			portfolio.setPortfolio_num(service.getPortfolioNum()+1);
			portfolio.setContents(portFolioCommand.getContents());
			portfolio.setF_num(portFolioCommand.getF_num());
			portfolio.setPortfile_iden(service.getPortfolio_iden(portfolio.getF_num())+1);
			if(portFolioCommand.getPortfile().isEmpty()){
				portfolio.setPortfile("");
			}else{
				portfolio.setPortfile(portFolioCommand.getPortfile().getOriginalFilename());
			}
			service.insertPortfolio(portfolio);
			
			MultipartFile portfile = portFolioCommand.getPortfile();
			int identy = fileUploadService.getIdenty("portfile", portfolio.getF_num())+1;
			fileUploadService.uploadFile(portfile, "portfile", portfolio.getF_num(), identy);
		
		}else{
			System.out.println(portFolioCommand.getPortfolio_num());
			Portfolio portfolio = new Portfolio();
			portfolio.setPortfolio_num(portFolioCommand.getPortfolio_num());
			portfolio.setF_num(portFolioCommand.getF_num());
			portfolio.setContents(portFolioCommand.getContents());
			portfolio.setPortfile_iden(service.getPortfolio_iden(portfolio.getF_num())+1);
			if(portFolioCommand.getPortfile().isEmpty()){
				portfolio.setPortfile("");
			}else{
				portfolio.setPortfile(portFolioCommand.getPortfile().getOriginalFilename());
			}
			service.updatePortfolio(portfolio);
			MultipartFile portfile = portFolioCommand.getPortfile();
			int identy = fileUploadService.getIdenty("portfile", portfolio.getF_num())+1;
			fileUploadService.uploadFile(portfile, "portfile", portfolio.getF_num(), identy);
		}
		
		return "redirect:/f_mypage/updateSuccess";
	}
	
	@RequestMapping(value="/deletePortfolio", method = RequestMethod.GET)
	public String deletePortfolio(@RequestParam("deletePortfolio_num") int portfolio_num) throws Exception{
		Portfolio portfolio = service.selectOnePortfolio(portfolio_num);
		fileUploadService.deleteFile("portfile",  portfolio.getF_num(), portfolio.getPortfile_iden());
		service.deletePortfolio(portfolio_num);
		return "redirect:/f_mypage/updateSuccess";
	}

	
	
	//일정관리
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
	public String scheduleAdd(Calendar calen, Model model) throws Exception{
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
	
	
	
	//회계관리
	@RequestMapping(value="/accountingManager", method=RequestMethod.GET)
	public void accountingManager(Model model, HttpSession session) throws Exception{
		c_login_freelancerVO freelancer = (c_login_freelancerVO) session.getAttribute("client");
		int f_num = freelancer.getF_num();
		List<Accounting> spendList = service.getSpendAccounting(f_num);
		if(spendList.size()==0){
			model.addAttribute("spendListCheck", 0);
		}
		model.addAttribute("spendList", spendList);
		
		List<Accounting> incomeList = service.getIncomeAccounting(f_num);
		if(incomeList.size()==0){
			model.addAttribute("incomeListCheck", 0);
		}
		model.addAttribute("incomeList", incomeList);
		
	}
	
	@RequestMapping(value="/spendListAdd", method=RequestMethod.POST)
	public String spendListAdd(AccountingCommand command) throws Exception{
		System.out.println("우아아아아아");
		if(command.getA_num() == 0){
			
			Accounting accounting = new Accounting();
			accounting.setA_num(service.getSpendAccountingNum()+1);
			accounting.setDetail_usage(command.getDetail_usage());
			accounting.setA_money(command.getA_money());
			accounting.setA_using_date(command.getA_using_date());
			accounting.setMonet_state(command.getMonet_state());
			accounting.setProject_relation_check(command.getProject_relation_check());
			accounting.setF_num(command.getF_num());
			
			if(command.getA_addfile().isEmpty()){
				accounting.setA_addfile("");
			}else{
				accounting.setA_addfile(command.getA_addfile().getOriginalFilename());
			}
			service.insertSpendAccounting(accounting);
			
			MultipartFile a_addfile = command.getA_addfile();
			fileUploadService.uploadFile(a_addfile, "a_addfile", accounting.getF_num(),0);
		
		}else{
			
			Accounting accounting = new Accounting();
			
			accounting.setA_num(command.getA_num());
			accounting.setDetail_usage(command.getDetail_usage());
			accounting.setA_money(command.getA_money());
			accounting.setA_using_date(command.getA_using_date());
			accounting.setMonet_state(command.getMonet_state());
			accounting.setProject_relation_check(command.getProject_relation_check());
			accounting.setF_num(command.getF_num());
			
			if(command.getA_addfile().isEmpty()){
				accounting.setA_addfile("");
			}else{
				accounting.setA_addfile(command.getA_addfile().getOriginalFilename());
			}
			//service.insertSpendAccounting(accounting);
			service.updateSpendAccounting(accounting);
			MultipartFile a_addfile = command.getA_addfile();
			fileUploadService.uploadFile(a_addfile, "a_addfile", accounting.getF_num(),0);
		}

		return "redirect:/f_mypage/updateSuccess";
	}
	
	@RequestMapping(value="/accountingManager", method=RequestMethod.POST)
	public void accountingSearch(Model model, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) throws Exception{
		System.out.println(startDate);
		System.out.println(endDate);
		HashMap<String, String> searchDateMap = new HashMap<String, String>();
		searchDateMap.put("startDate", startDate);
		searchDateMap.put("endDate", endDate);
		List<Accounting>searchSpendList = service.searchSpendList(searchDateMap);
		if(searchSpendList.size()==0){
			model.addAttribute("spendListCheck", 0);
		}
		model.addAttribute("spendList", searchSpendList);
		
		List<Accounting> searchIncomeList = service.searchIncomeList(searchDateMap);
		if(searchIncomeList.size()==0){
			model.addAttribute("incomeListCheck", 0);
		}
		model.addAttribute("incomeList", searchIncomeList);
	}
	
	
}
