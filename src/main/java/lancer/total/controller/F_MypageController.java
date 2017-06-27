package lancer.total.controller;

import java.io.InputStream;
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
import lancer.f_mypage.domain.E_grade;
import lancer.f_mypage.domain.F_job;
import lancer.f_mypage.domain.FinishProject;
import lancer.f_mypage.domain.Freelancer;
import lancer.f_mypage.domain.NowProject;
import lancer.f_mypage.domain.Portfolio;
import lancer.f_mypage.domain.PortfolioCommand;
import lancer.f_mypage.domain.School;
import lancer.total.service.C_AlramService;
import lancer.total.service.C_DropService;
import lancer.total.service.C_FileService;
import lancer.total.service.F_MypageService;
import lancer.total.service.c_projectlistService;

@Controller
@RequestMapping("/f_mypage")
public class F_MypageController {

	
	@Inject
	private F_MypageService service;
	
	@Inject
	private C_DropService dropService;
	
	@Inject
	private C_FileService fileService;
	
	@Inject
	private C_AlramService alramService;
	
	@Inject
	private c_projectlistService projectlistService;
	
	@RequestMapping(value="/myInfo", method = RequestMethod.GET)
	public void myInfo(Model model, HttpSession session, @RequestParam("where") String where) throws Exception{
		System.out.println(session);
		System.out.println(session.getAttribute("client"));
		model.addAttribute("where", where);
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
		
		HashMap<String, Object> f_fnameMap = fileService.selectFile("f_photo", freelancer.getF_num(), 0);
		System.out.println(f_fnameMap.get("file_num")+"우엑");
		if(f_fnameMap.get("file_num") != null){
			HashMap<String, Object> f_fnameMap2 = fileService.selectFileInfo((Integer)f_fnameMap.get("file_num"));
			model.addAttribute("f_photo", f_fnameMap2.get("stored_file_name"));
		}
		
		
		List<Integer> joblist = service.showFreelancerJobInfo(freelancer.getF_num());
		model.addAttribute("joblist", joblist);
		
		List<Career> career = service.showCareerInfo(freelancer.getF_num());
		List<School> school = service.showSchoolInfo(freelancer.getF_num());
		List<Certificate> certificate = service.showCertiInfo(freelancer.getF_num());
		List<ApplyProject> applyproject = service.getApplyProject(freelancer.getF_num());
		List<ApplyProject> suggestproject = service.getSuggestProject(freelancer.getF_num());
		List<Portfolio> portfolio = service.showPortfolioInfo(freelancer.getF_num());
		/*for(int i=0; i<portfolio.size(); i++){
			System.out.println(portfolio.get(i).getContents());
			portfolio.get(i).setContents(portfolio.get(i).getContents().replaceAll("<br />", "\r\n"));
			System.out.println(portfolio.get(i).getContents());
		}*/
		//NowProject nowProject = service.getMyNowProject(3);


		//nowProject.setTerm(nowProject.getP_startdate().substring(0, 10) + " ~ " + nowProject.getP_enddate().substring(0, 10));
		
		//List<Project> project = service.getMyFinishProject(3);
		//List<FinishProject> finishProject  = new ArrayList<FinishProject>();
		/*for(int i=0; i<project.size(); i++){
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
			fp.setE_num(project.get(i).getE_num());
			fp.setE_pr_num(project.get(i).getE_pr_num());
		
			finishProject.add(fp);
		}
		*/
		if(applyproject.size()==0){
			model.addAttribute("applyprojectcheck", "0");
		}else{
			model.addAttribute("applyproject", applyproject);
		}
		if(suggestproject.size()==0){
			model.addAttribute("suggestprojectcheck", "0");
		}else{
			model.addAttribute("suggestproject", suggestproject);
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
	/*	
		if(nowProject == null){
			model.addAttribute("nowProject", "0");
		}else{
			model.addAttribute("nowProject", nowProject);
		}
		
		if(finishProject.size() == 0 ){
			model.addAttribute("finishprojectcheck", "0");
		}else{
			model.addAttribute("finishproject", finishProject);
		}*/

	}
	
	@RequestMapping(value="/myInfo2", method = RequestMethod.GET)
	public void myInfo2(Model model, HttpSession session, @RequestParam("where") String where) throws Exception{
		System.out.println(session);
		System.out.println(session.getAttribute("client"));
		model.addAttribute("where", where);
		
		c_login_freelancerVO freelancer = (c_login_freelancerVO) session.getAttribute("client");
		service.updateAlramCheck(freelancer.getF_num());
		session.setAttribute("chang_num", 0);
		session.setAttribute("a_list", "");
		
		model.addAttribute("freelancer", freelancer);
		
		List<Integer> joblist = service.showFreelancerJobInfo(freelancer.getF_num());
		model.addAttribute("joblist", joblist);
		
		List<Career> career = service.showCareerInfo(freelancer.getF_num());
		List<School> school = service.showSchoolInfo(freelancer.getF_num());
		List<Certificate> certificate = service.showCertiInfo(freelancer.getF_num());
		List<ApplyProject> applyproject = service.getApplyProject(freelancer.getF_num());
		List<ApplyProject> suggestproject = service.getSuggestProject(freelancer.getF_num());
		List<Portfolio> portfolio = service.showPortfolioInfo(freelancer.getF_num());
		/*for(int i=0; i<portfolio.size(); i++){
			System.out.println(portfolio.get(i).getContents());
			portfolio.get(i).setContents(portfolio.get(i).getContents().replaceAll("<br />", "\r\n"));
			System.out.println(portfolio.get(i).getContents());
		}*/
		NowProject nowProject = service.getMyNowProject(freelancer.getF_num());
		NowProject matchingProject = service.getMyMatchingProject(freelancer.getF_num());
		if(nowProject != null){
			nowProject.setTerm(nowProject.getP_startdate().substring(0, 10) + " ~ " + nowProject.getP_enddate().substring(0, 10));
		}
		if(matchingProject != null){
		matchingProject.setTerm(matchingProject.getP_startdate().substring(0, 10) + " ~ " + matchingProject.getP_enddate().substring(0, 10));
		}
		List<NowProject> project = service.getMyFinishProject(freelancer.getF_num());
		List<FinishProject> finishProject  = new ArrayList<FinishProject>();
		for(int i=0; i<project.size(); i++){
			FinishProject fp = new FinishProject();
			fp.setC_num(project.get(i).getC_num());
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
			fp.setE_num(project.get(i).getE_num());
			fp.setE_pr_num(project.get(i).getE_pr_num());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("e_pr_num", project.get(i).getE_pr_num());
			map.put("f_num", freelancer.getF_num());
		
			fp.setEvaluate(service.evaluateCheck(map));
			
			finishProject.add(fp);
		}
		
		if(applyproject.size()==0){
			model.addAttribute("applyprojectcheck", "0");
		}else{
			model.addAttribute("applyproject", applyproject);
		}
		if(suggestproject.size()==0){
			model.addAttribute("suggestprojectcheck", "0");
		}else{
			model.addAttribute("suggestproject", suggestproject);
		}
		
		
		if(nowProject == null){
			model.addAttribute("nowProjectcheck", "0");
		}else{
			model.addAttribute("nowProject", nowProject);
		}

		if(matchingProject == null){
			model.addAttribute("matchingProjectcheck", "0");
		}else{
			model.addAttribute("matchingProject", matchingProject);
		}
		//System.out.println(matchingProject.getP_name()+"아아으아링");
		
		if(finishProject.size() == 0 ){
			model.addAttribute("finishprojectcheck", "0");
		}else{
			model.addAttribute("finishproject", finishProject);
		}
		model.addAttribute("evaluate", "0");

	}
	
	
	@RequestMapping(value="/myInfo", method=RequestMethod.POST)
	public String updateFreelancerInfo(Freelancer freelancer,RedirectAttributes rttr, Model model, HttpSession session, HttpServletRequest request) throws Exception{
		System.out.println(freelancer.getF_sex());
		c_login_freelancerVO original =  (c_login_freelancerVO) session.getAttribute("client");
		String my_pwd = original.getF_pwd();
		System.out.println(my_pwd);
		System.out.println("와버렸네여기까지");
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
			
			if(freelancer.getF_photoExist().equals("true")){
				MultipartFile f_fname = freelancer.getF_fname();	
				fileService.uploadImageFile(f_fname, "f_photo", original.getF_num(), 0);
			}
			
			original.setF_name(freelancer.getF_name());
			original.setF_birth(freelancer.getF_birth());
			//original.setF_fname(freelancer.getF_fname());
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
			return "redirect:/f_mypage/updateSuccess?where=1";
			}
	}
	
	@RequestMapping(value="/updateSuccess", method=RequestMethod.GET)
	public void updateSuccess(@RequestParam("where") String where, Model model) throws Exception{
		model.addAttribute("where", where);
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
		return "redirect:/f_mypage/updateSuccess?where=2";
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
		return "redirect:/f_mypage/updateSuccess?where=2";
	}
	@RequestMapping(value="/deleteCareer", method=RequestMethod.GET)
	public String deleteCareer(@RequestParam("deleteCareer_num") int career_num) throws Exception{
		service.deleteCareer(career_num);
		return "redirect:/f_mypage/updateSuccess?where=2";
	}
	
	
	@RequestMapping(value="/schoolAdd", method=RequestMethod.GET)
	public void schoolAdd() throws Exception{
	}
	
	@RequestMapping(value="/schoolAdd", method=RequestMethod.POST)
	public String schoolAdd(School school) throws Exception{
		school.setSchool_num(service.getSchoolNum()+1);
		service.insertSchool(school);
		return "redirect:/f_mypage/updateSuccess?where=2";
	}
	
	@RequestMapping(value="/schoolModify", method=RequestMethod.POST)
	public void schoolModify(School school, Model model) throws Exception{
		model.addAttribute("school", school);
	}
	
	@RequestMapping(value="/updateSchool", method=RequestMethod.POST)
	public String updateSchool(School school) throws Exception{
		service.updateSchool(school);
		return "redirect:/f_mypage/updateSuccess?where=2";
	}
	@RequestMapping(value="/deleteSchool", method=RequestMethod.GET)
	public String deleteSchool(@RequestParam("deleteSchool_num") int school_num) throws Exception{
		service.deleteSchool(school_num);
		System.out.println(school_num);
		return "redirect:/f_mypage/updateSuccess?where=2";
	}
	
	
	

	@RequestMapping(value="/certiAdd", method=RequestMethod.GET)
	public void certiAdd() throws Exception{
	}
	
	@RequestMapping(value="/certiAdd", method=RequestMethod.POST)
	public String certiAdd(Certificate certi) throws Exception{
		certi.setCertificate_num(service.getCertiNum()+1);
		service.insertCerti(certi);
		return "redirect:/f_mypage/updateSuccess?where=2";
	}
	@RequestMapping(value="/certiModify", method=RequestMethod.POST)
	public void certiModify(Certificate certi, Model model) throws Exception{
		model.addAttribute("certi", certi);
	}
	@RequestMapping(value="/updateCerti", method=RequestMethod.POST)
	public String updateCerti(Certificate certi) throws Exception{
		service.updateCerti(certi);
		return "redirect:/f_mypage/updateSuccess?where=2";
	}
	@RequestMapping(value="/deleteCerti", method=RequestMethod.GET)
	public String deleteCerti(@RequestParam("deleteCerti_num") int certi_num) throws Exception{
		service.deleteCerti(certi_num);
		return "redirect:/f_mypage/updateSuccess?where=2";
	}
	
	@RequestMapping(value="/portfolioAdd", method=RequestMethod.POST)
	public String portfolioAdd(PortfolioCommand portFolioCommand) throws Exception{
		System.out.println(portFolioCommand.getF_num());
		if(portFolioCommand.getPortfolio_num() == 0){
			
			System.out.println(portFolioCommand.getContents());
			System.out.println(portFolioCommand.getPortfile().getOriginalFilename());
			
			Portfolio portfolio = new Portfolio();
			portfolio.setPortfolio_num(service.getPortfolioNum()+1);
			portfolio.setPortfolio_title(portFolioCommand.getPortfolio_title());
			portfolio.setContents(portFolioCommand.getContents());
			portfolio.setF_num(portFolioCommand.getF_num());
			
			if(portFolioCommand.getPortfile().isEmpty()){
				portfolio.setPortfile("");
				portfolio.setPortfile_iden(0);
			}else{
				portfolio.setPortfile(portFolioCommand.getPortfile().getOriginalFilename());
				portfolio.setPortfile_iden(service.getPortfolio_iden(portfolio.getF_num())+1);
				MultipartFile portfile = portFolioCommand.getPortfile();
				int identy = fileService.getIdenty("portfile", portfolio.getF_num())+1;
				fileService.uploadFile(portfile, "portfile", portfolio.getF_num(), identy);
			}
			service.insertPortfolio(portfolio);
		
		}else{
			System.out.println("업데이트로 온 거 맞아요?");
			System.out.println(portFolioCommand.getPortfolio_num());
			System.out.println(portFolioCommand.getPortfile_iden());
			Portfolio portfolio = new Portfolio();
			portfolio.setPortfolio_num(portFolioCommand.getPortfolio_num());
			portfolio.setPortfolio_title(portFolioCommand.getPortfolio_title());
			portfolio.setF_num(portFolioCommand.getF_num());
			portfolio.setContents(portFolioCommand.getContents());
			if(portFolioCommand.getPortfile().isEmpty()){
				portfolio.setPortfile("");
				portfolio.setPortfile_iden(0);
			}else{
				portfolio.setPortfile(portFolioCommand.getPortfile().getOriginalFilename());
				portfolio.setPortfile_iden(portFolioCommand.getPortfile_iden());
				MultipartFile portfile = portFolioCommand.getPortfile();
				//	int identy = fileUploadService.getIdenty("portfile", portfolio.getF_num())+1;
				fileService.uploadFile(portfile, "portfile", portfolio.getF_num(), portfolio.getPortfile_iden());
			}
			service.updatePortfolio(portfolio);
			
			
		}
		return "redirect:/f_mypage/updateSuccess?where=3";
	}
	
	@RequestMapping(value="/deletePortfolio", method = RequestMethod.GET)
	public String deletePortfolio(@RequestParam("deletePortfolio_num") int portfolio_num) throws Exception{
		Portfolio portfolio = service.selectOnePortfolio(portfolio_num);
		fileService.deleteFile("portfile",  portfolio.getF_num(), portfolio.getPortfile_iden());
		service.deletePortfolio(portfolio_num);
		return "redirect:/f_mypage/updateSuccess?where=3";
	}

	@RequestMapping(value="/applyCancel", method=RequestMethod.POST)
	public String applyCancel(ApplyProject applyproject) throws Exception{
		service.deleteApplyProject(applyproject.getC_num());
		return "redirect:/f_mypage/updateSuccess?where=6";
	}
	
	@RequestMapping(value="/suggestCancel", method=RequestMethod.POST)
	public String suggestCancel(ApplyProject suggestproject) throws Exception{
		service.rejectSuggestProject(suggestproject.getC_num());
		return "redirect:/f_mypage/updateSuccess?where=6";
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
	public void scheduleAdd(@RequestParam("clickDate") String date, Model model) throws Exception{
		model.addAttribute("clickDate", date);
	}
	
	@RequestMapping(value="/scheduleAdd", method=RequestMethod.POST)
	public String scheduleAdd(Calendar calen, Model model) throws Exception{
		System.out.println("컨트롤러 들어오셨어요?");
		//c_login_freelancerVO freelancer = (c_login_freelancerVO) session.getAttribute("client");
		//int f_num = freelancer.getF_num();
		//calen.setF_num(f_num);
		calen.setCalendar_num(service.getScheduleNum()+1);
		service.insertMySchedule(calen);
		return "redirect:/f_mypage/scheduleManager";
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
		else{
			for(int i=0; i<spendList.size(); i++){
				spendList.get(i).setFormatMoney((String.format("%,d", spendList.get(i).getA_money())));		
			}
		}
		model.addAttribute("spendList", spendList);
		
		List<Accounting> incomeList = service.getIncomeAccounting(f_num);
		if(incomeList.size()==0){
			model.addAttribute("incomeListCheck", 0);
		}else{
			for(int i=0; i<incomeList.size(); i++){
				incomeList.get(i).setFormatMoney((String.format("%,d", incomeList.get(i).getA_money())));		
			}
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
			if(command.getProject_relation_check().equals("y")){
				accounting.setProject_relation_check("유");	
			}else{
				accounting.setProject_relation_check("무");			
			}
			accounting.setF_num(command.getF_num());
			accounting.setAccfile_iden(service.getAccounting_iden(accounting.getF_num())+1);
			if(command.getA_addfile().isEmpty()){
				accounting.setA_addfile("");
			}else{
				accounting.setA_addfile(command.getA_addfile().getOriginalFilename());
			}
			service.insertSpendAccounting(accounting);
			
			MultipartFile a_addfile = command.getA_addfile();
			int identy = fileService.getIdenty("accfile", accounting.getF_num())+1;
			fileService.uploadFile(a_addfile, "accfile", accounting.getF_num(),identy);
		
		}else{
			
			Accounting accounting = new Accounting();
			
			accounting.setA_num(command.getA_num());
			accounting.setDetail_usage(command.getDetail_usage());
			accounting.setA_money(command.getA_money());
			accounting.setA_using_date(command.getA_using_date());
			accounting.setMonet_state(command.getMonet_state());
			if(command.getProject_relation_check().equals("y")){
				accounting.setProject_relation_check("유");	
			}else{
				accounting.setProject_relation_check("무");			
			}
			accounting.setF_num(command.getF_num());
			accounting.setAccfile_iden(command.getAccfile_iden());
			
			if(command.getA_addfile().isEmpty()){
				accounting.setA_addfile("");
			}else{
				accounting.setA_addfile(command.getA_addfile().getOriginalFilename());
			}
			//service.insertSpendAccounting(accounting);
			service.updateSpendAccounting(accounting);
			MultipartFile a_addfile = command.getA_addfile();
			//int identy = fileUploadService.getIdenty("accfile", accounting.getF_num())+1;
			fileService.uploadFile(a_addfile, "accfile", accounting.getF_num(),accounting.getAccfile_iden());
		}

		return "redirect:/f_mypage/updateSuccess?where=8";
	}
	
	@RequestMapping(value="/deleteSpendList", method = RequestMethod.GET)
	public String deleteSpendList(@RequestParam("deleteSpendList_num") int a_num) throws Exception{
		Accounting accouting = service.selectOneAccounting(a_num);
	
		fileService.deleteFile("portfile",  accouting.getF_num(), accouting.getAccfile_iden());
		service.deleteAccounting(a_num);
		return "redirect:/f_mypage/updateSuccess?where=8";
	}

	
	
	
	@RequestMapping(value="/accountingManager", method=RequestMethod.POST)
	public void accountingSearch(Model model, @RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("f_num") int f_num) throws Exception{
		System.out.println(startDate);
		System.out.println(endDate);
		System.out.println(startDate.substring(5, 7));
		String searchMonth = startDate.substring(5, 7);
		model.addAttribute("search", "yes");
		model.addAttribute("searchMonth", searchMonth);
		HashMap<String, Object> searchDateMap = new HashMap<String, Object>();
		searchDateMap.put("startDate", startDate.substring(2));
		searchDateMap.put("endDate", endDate.substring(2));
		searchDateMap.put("f_num", f_num);
		List<Accounting>searchSpendList = service.searchSpendList(searchDateMap);
		int totalSpend=0;
		int totalIncome=0;
		if(searchSpendList.size()==0){
			model.addAttribute("spendListCheck", 0);
			model.addAttribute("totalSpendCount", 0);
			model.addAttribute("totalSpend", 0);
		}else{
			for(int i=0; i<searchSpendList.size(); i++){
				totalSpend += searchSpendList.get(i).getA_money();
				searchSpendList.get(i).setFormatMoney((String.format("%,d", searchSpendList.get(i).getA_money())));
			}
			model.addAttribute("totalSpendCount", searchSpendList.size());
			model.addAttribute("totalSpend", String.format("%,d", totalSpend));
		}
		model.addAttribute("spendList", searchSpendList);
		
		List<Accounting> searchIncomeList = service.searchIncomeList(searchDateMap);
		if(searchIncomeList.size()==0){
			model.addAttribute("incomeListCheck", 0);
			model.addAttribute("totalIncomeCount", 0);
			model.addAttribute("totalIncome", 0);
		}else{
			for(int i=0; i<searchIncomeList.size(); i++){
				totalIncome += searchIncomeList.get(i).getA_money();
				searchIncomeList.get(i).setFormatMoney((String.format("%,d", searchIncomeList.get(i).getA_money())));
			}
			model.addAttribute("totalIncomeCount", searchIncomeList.size());
			model.addAttribute("totalIncome", String.format("%,d", totalIncome));
		}
		model.addAttribute("incomeList", searchIncomeList);
	}
	
	
	@RequestMapping(value = "/suggestFinish", method=RequestMethod.GET)
	public String suggestFinish(@RequestParam("e_pr_num") int e_pr_num, @RequestParam("f_num") int f_num, @RequestParam("e_num") int e_num) throws Exception{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("e_pr_num", e_pr_num);
		map.put("f_num", f_num);
		service.suggestApply(map);
		
		String p_name = projectlistService.getProjectName(e_pr_num);
		String f_id = service.getF_id(f_num);
		String ment = p_name + "& "+ f_id + " &참여수락";
		alramService.insertAlramE(e_num, e_pr_num, ment);
		return "redirect:/f_mypage/matching";
	}
	
	@RequestMapping(value="/suggestReject", method=RequestMethod.GET)
	public String suggestReject(@RequestParam("e_pr_num") int e_pr_num, @RequestParam("f_num") int f_num, @RequestParam("e_num") int e_num) throws Exception{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("e_pr_num", e_pr_num);
		map.put("f_num", f_num);
		service.suggestReject(map);
		
		String p_name = projectlistService.getProjectName(e_pr_num);
		String f_id = service.getF_id(f_num);
		String ment = p_name + "& "+ f_id + " &참여거절";
		alramService.insertAlramE(e_num, e_pr_num, ment);
		return "redirect:/f_mypage/matchFail";
	}
	
	@RequestMapping(value="/matching", method=RequestMethod.GET)
	public void matching() throws Exception{
	}
	
	@RequestMapping(value="/matchFail", method=RequestMethod.GET)
	public void matchFail() throws Exception{
	}
	
	@RequestMapping(value="/gotoEval", method=RequestMethod.POST)
	public String gotoEval(E_grade e_grade, Model model) throws Exception{
		System.out.println(e_grade.getE_grade_star());
		System.out.println(e_grade.getE_num());
		System.out.println(e_grade.getE_pr_num());
		System.out.println(e_grade.getF_num());
		
		e_grade.setE_grade_num(service.countAllE_grade()+1);
		service.insertE_grade(e_grade);
		System.out.println("hellowordld");
		
		double avg = service.getAvgE_grade(e_grade.getE_num());
		System.out.println(avg);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("e_num", e_grade.getE_num());
		map.put("e_score", avg);
		service.updateE_grade(map);
		return "redirect:/c_projectlist/c_readpage?page=1&perPageNum=10&jobs&e_pr_num="+e_grade.getE_pr_num()+"&e_num="+e_grade.getE_num() + "&from=evalEnd";
	}
}
