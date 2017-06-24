package lancer.total.controller;

import java.util.HashMap;
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
import org.springframework.web.multipart.MultipartFile;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.e_mypage.domain.Criteria;
import lancer.e_mypage.domain.EnterpriseCommand;
import lancer.e_mypage.domain.Member;
import lancer.e_mypage.domain.PageMaker;
import lancer.e_mypage.domain.Project;
import lancer.total.service.C_AlramService;
import lancer.total.service.C_DropService;
import lancer.total.service.C_FileService;
import lancer.total.service.E_MypageService;

@Controller
@RequestMapping("/e_mypage/*")
public class E_MypageController {

	@Inject
	private E_MypageService service;
	
	@Inject
	private C_FileService fileService;
	
	@Inject
	private C_DropService dropService;
	
	@Inject
	private C_AlramService alramService;

	@RequestMapping(value = "/e_info", method = RequestMethod.GET)
	public void e_infoGET(Model model,HttpSession session) throws Exception{
		
		c_login_enterpriseVO enterprise = (c_login_enterpriseVO)session.getAttribute("client");
		model.addAttribute("client", enterprise);
		
		String[] e_mail = enterprise.getE_mail().split("@");
		model.addAttribute("e_mail_1", e_mail[0]);
		model.addAttribute("e_mail_2", e_mail[1]);
				
		String[] regno = enterprise.getE_regno().split("-");
		model.addAttribute("regno_1", regno[0]);
		model.addAttribute("regno_2", regno[1]);
		model.addAttribute("regno_3", regno[2]);
				
		String[] e_phone = enterprise.getE_phone().split("-");
		model.addAttribute("e_phone_1", e_phone[0]);
		model.addAttribute("e_phone_2", e_phone[1]);
		model.addAttribute("e_phone_3", e_phone[2]);
				
		String[] manager_hphone = enterprise.getManager_hphone().split("-");
		model.addAttribute("manager_hphone_1", manager_hphone[0]);
		model.addAttribute("manager_hphone_2", manager_hphone[1]);
		model.addAttribute("manager_hphone_3", manager_hphone[2]);
				
		String[] manager_mail = enterprise.getManager_mail().split("@");
		model.addAttribute("manager_mail_1", manager_mail[0]);
		model.addAttribute("manager_mail_2", manager_mail[1]);
			
		String[] e_address = enterprise.getE_address().split("&");
		model.addAttribute("e_address_1", e_address[0]);
		model.addAttribute("e_address_2", e_address[1]);
		model.addAttribute("e_address_3", e_address[2]);
		
		// 파일 정보 구해서 표시하기
		HashMap<String, Object> e_ownerfileMap = fileService.selectFile("e_ownerfile", enterprise.getE_num(), 0);
		
		if(e_ownerfileMap.get("file_num") != null){
			HashMap<String, Object> e_ownerfileMap2 = fileService.selectFileInfo((Integer)e_ownerfileMap.get("file_num"));
			model.addAttribute("e_ownerFileStoredName", e_ownerfileMap2.get("stored_file_name"));
		}
		
		
		HashMap<String, Object> e_licensefileMap = fileService.selectFile("e_licensefile", enterprise.getE_num(), 0);
		
		model.addAttribute("e_licenseFileNum", e_licensefileMap.get("file_num"));
		model.addAttribute("e_licenseFileName", e_licensefileMap.get("original_file_name"));
		model.addAttribute("e_licenseFileSize", e_licensefileMap.get("file_size"));
		

	}
	
	@RequestMapping(value = "/e_info", method = RequestMethod.POST)
	public String e_infoUpdatePOST(EnterpriseCommand command, Model model, HttpSession session) throws Exception {

		//기존 기업정보
		c_login_enterpriseVO enterprise = (c_login_enterpriseVO)session.getAttribute("client");
	
		String pwd1 = command.getE_pwd_1();
		String pwd2 = command.getE_pwd_2();
		
		if(pwd1.equals(pwd2)){
			// 비밀번호와 비밀번호 확인이 일치할 경우 변경
			enterprise.setE_pwd(pwd1);
		}else{
			// 일치하지 않을 경우 실패
			return "redirect:/e_mypage/e_info";
		}
		
		
		//회사이메일
		String email1 = command.getE_mail_1();
		String email2 = command.getE_mail_2();
		String e_email = email1+"@"+email2;
		enterprise.setE_mail(e_email);
		
		enterprise.setE_name(command.getE_name());
		
		enterprise.setE_ename(command.getE_ename());
		
		enterprise.setE_owner(command.getE_owner());
		
		//사업자번호
		String regno_1 = command.getE_regno_1();
		String regno_2 = command.getE_regno_2();
		String regno_3 = command.getE_regno_3();
		String e_regno = regno_1 + "-" + regno_2 + "-" + regno_3;
		enterprise.setE_regno(e_regno);
		
		//대표번호
		String e_phone_1 = command.getE_phone_1();
		String e_phone_2 = command.getE_phone_2();
		String e_phone_3 = command.getE_phone_3();
		String e_phone = e_phone_1 + "-" + e_phone_2 + "-" + e_phone_3;
		enterprise.setE_phone(e_phone);
		
		enterprise.setE_bf(command.getE_bf());
		
		enterprise.setManager_name(command.getManager_name());
		
		//담당자 핸드폰번호
		String manager_hphone_1 = command.getManager_hphone_1();
		String manager_hphone_2 = command.getManager_hphone_2();
		String manager_hphone_3 = command.getManager_hphone_3();
		String manager_hphone = manager_hphone_1 + "-" + manager_hphone_2 + "-" + manager_hphone_3;
		enterprise.setManager_hphone(manager_hphone);
		
		//매니저이메일
		String manager_mail_1 = command.getManager_mail_1();
		String manager_mail_2 = command.getManager_mail_2();
		String manager_mail = manager_mail_1 + "@" + manager_mail_2;
		enterprise.setManager_mail(manager_mail);
		
		//회사 주소
		String e_address_1 = command.getE_address_1();
		String e_address_2 = command.getE_address_2();
		String e_address_3 = command.getE_address_3();
		String e_address = e_address_1 + "&" + e_address_2 + "&" + e_address_3;
		enterprise.setE_address(e_address);
		
		enterprise.setE_homepage(command.getE_homepage());
		
		enterprise.setStart_year(command.getStart_year());

		enterprise.setE_enum(command.getE_enum());	
				
		enterprise.setE_listing(command.getE_listing());		
				
		enterprise.setE_capital(command.getE_capital());
				
		enterprise.setE_sales(command.getE_sales());		
				
		enterprise.setE_scale(command.getE_scale());		
			
		enterprise.setE_ownerfilenum(0);
		enterprise.setE_licensefilenum(0);
		
		//파일 업로드
		if(command.getE_ownerfileExist().equals("true")){
			MultipartFile E_ownerfile = command.getE_ownerfile();	
			Integer e_ownerfileNum = fileService.uploadImageFile(E_ownerfile, "e_ownerfile", enterprise.getE_num(), 0);
			enterprise.setE_ownerfilenum(e_ownerfileNum);
		}
		if(command.getE_licensefileExist().equals("true")){
			MultipartFile e_licensefile = command.getE_licensefile();	
			Integer e_licensefileNum = fileService.uploadFile(e_licensefile, "e_licensefile", enterprise.getE_num(), 0);
			enterprise.setE_licensefilenum(e_licensefileNum);
		}
		
		service.updateEnterprise(enterprise);
		session.setAttribute("client", enterprise);		
		return "redirect:/e_mypage/e_info";
	}
	
	@RequestMapping(value="/dropEnterprise", method=RequestMethod.GET)
	public String dropEnterprise(@RequestParam("e_num") int e_num, HttpSession session) throws Exception{
		dropService.deleteEnterprise(e_num);
		session.invalidate();
		return "redirect:/e_main/e_main";
	}	
	
	@RequestMapping(value = "/e_project", method = RequestMethod.GET)
	public String e_projectGET(@ModelAttribute("cri") Criteria cri, Model model, HttpSession session) throws Exception{
		
		c_login_enterpriseVO enterprise = (c_login_enterpriseVO)session.getAttribute("client");
		int e_num = enterprise.getE_num();
		List<Project> readyList = service.listProjectReady(e_num, cri);
		List<Project> doingList = service.listProjectDoing(e_num, cri);
		List<Project> doneList = service.listProjectDone(e_num, cri);
		
		model.addAttribute("readyList", readyList);
		model.addAttribute("doingList", doingList);
		model.addAttribute("doneList", doneList);
		

		PageMaker pageMakerReady =  new PageMaker();
		pageMakerReady.setCri(cri);
		pageMakerReady.setTotalCount(service.countProjectReady(e_num));
		
		PageMaker pageMakerDoing =  new PageMaker();
		pageMakerDoing.setCri(cri);
		pageMakerDoing.setTotalCount(service.countProjectDoing(e_num));
		
		PageMaker pageMakerDone =  new PageMaker();
		pageMakerDone.setCri(cri);
		pageMakerDone.setTotalCount(service.countProjectDone(e_num));
		
		model.addAttribute("pageMakerReady", pageMakerReady);
		model.addAttribute("pageMakerDoing", pageMakerDoing);
		model.addAttribute("pageMakerDone", pageMakerDone);
		
		return "/e_mypage/e_project";
	}
	
	@RequestMapping(value = "/e_projectInfo", method = RequestMethod.GET)
	public void e_projectInfoGET(int e_pr_num, @ModelAttribute("cri") Criteria cri, Model model, HttpSession session) throws Exception {

		c_login_enterpriseVO enterprise = (c_login_enterpriseVO)session.getAttribute("client");
		
		// 기업 정보 구하기
		String[] manager_hphone = enterprise.getManager_hphone().split("-");
		model.addAttribute("manager_hphone_1", manager_hphone[0]);
		model.addAttribute("manager_hphone_2", manager_hphone[1]);
		model.addAttribute("manager_hphone_3", manager_hphone[2]);
		
		String[] manager_mail = enterprise.getManager_mail().split("@");
		model.addAttribute("manager_mail_1", manager_mail[0]);
		model.addAttribute("manager_mail_2", manager_mail[1]);
		

		// 프로젝트 정보 구하기
		
		int e_num = enterprise.getE_num();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("e_num", e_num);
		map.put("e_pr_num", e_pr_num);

		Project project = service.selectProject(map);
		
		model.addAttribute("project", project);
		
		//상세분야 구하기
		List<Integer> p_job = service.selectP_job(e_pr_num);
		model.addAttribute("p_job", p_job);
		
		
		// 멤버, 신청, 제안 리스트 구하기
		
		List<Member> memberList = service.selectMember(e_pr_num, cri);
		List<Member> applicantList = service.selectApplicant(e_pr_num, cri);
		List<Member> scoutList = service.selectScout(e_pr_num, cri);
		
		model.addAttribute("memberList", memberList);
		model.addAttribute("applicantList", applicantList);
		model.addAttribute("scoutList", scoutList);
		

		PageMaker pageMakerMember =  new PageMaker();
		pageMakerMember.setCri(cri);
		pageMakerMember.setTotalCount(service.countMember(e_pr_num));
		
		PageMaker pageMakerApplicant =  new PageMaker();
		pageMakerApplicant.setCri(cri);
		pageMakerApplicant.setTotalCount(service.countApplicant(e_pr_num));
		
		PageMaker pageMakerScout =  new PageMaker();
		pageMakerScout.setCri(cri);
		pageMakerScout.setTotalCount(service.countScout(e_pr_num));
		
		model.addAttribute("pageMakerMember", pageMakerMember);
		model.addAttribute("pageMakerApplicant", pageMakerApplicant);
		model.addAttribute("pageMakerScout", pageMakerScout);
	}
	
	@RequestMapping(value = "/e_projectInfo", method = RequestMethod.POST)
	public String e_projectInfoPOST(int e_pr_num, MultipartFile contractFile, int f_num) throws Exception {
		if(contractFile == null){
			return "redirect:/e_mypage/e_projectInfo?e_pr_num=" + e_pr_num;
		}
		
		int c_num = service.selectC_num(f_num, e_pr_num);
		fileService.uploadFile(contractFile, "contractfile", c_num, 0);
		
		return "redirect:/e_mypage/e_projectInfo?e_pr_num=" + e_pr_num;
	}
	
	@RequestMapping(value = "/e_projectUpdate", method = RequestMethod.GET)
	public void e_projectUpdateGET(int e_pr_num, Model model, HttpSession session) throws Exception {	
		c_login_enterpriseVO enterprise = (c_login_enterpriseVO)session.getAttribute("client");
		
		// 기업 정보 구하기
		String[] manager_hphone = enterprise.getManager_hphone().split("-");
		model.addAttribute("manager_hphone_1", manager_hphone[0]);
		model.addAttribute("manager_hphone_2", manager_hphone[1]);
		model.addAttribute("manager_hphone_3", manager_hphone[2]);
		
		String[] manager_mail = enterprise.getManager_mail().split("@");
		model.addAttribute("manager_mail_1", manager_mail[0]);
		model.addAttribute("manager_mail_2", manager_mail[1]);
		

		// 프로젝트 정보 구하기
		
		int e_num = enterprise.getE_num();
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("e_num", e_num);
		map.put("e_pr_num", e_pr_num);

		Project project = service.selectProject(map);
		
		model.addAttribute("project", project);
		
		//상세분야 구하기
		List<Integer> p_job = service.selectP_job(e_pr_num);
		model.addAttribute("p_job", p_job);
		
	}
	
	@RequestMapping(value = "/e_projectUpdate", method = RequestMethod.POST)
	public String e_projectUpdatePOST(Project project, HttpServletRequest request, HttpSession session, 
			@ModelAttribute("p_location1") String p_location1, @ModelAttribute("p_location2") String p_location2) throws Exception {		
		
		// project
		int e_pr_num = project.getE_pr_num();
		project.setP_location(p_location1+" "+p_location2);
		
		service.updateProject(project);
		
		
		// p_job
		dropService.deleteP_job(e_pr_num);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("e_pr_num", e_pr_num);
		
		String check[] = request.getParameterValues("check");
		for(int i=0;i<check.length;i++)
		{
			if(map.get("job_id") == null){
				map.put("job_id", Integer.parseInt(check[i]));
			}else{
				map.replace("job_id", Integer.parseInt(check[i]));
			}
			service.insertP_Job(map);
		}
	
		
		List<Member> list = service.selectMemberWithoutCri(e_pr_num);
		for(int i=0; i<list.size(); i++){
			alramService.insertAlramF(list.get(i).getF_num(), e_pr_num, "수정");
		}
		
		return "redirect:/e_mypage/e_projectInfo?e_pr_num=" + project.getE_pr_num();
	}
	
	@RequestMapping(value = "/e_startProject", method = RequestMethod.POST)
	public String e_startProjectPOST(int e_pr_numStart, String p_nameStart) throws Exception {
		service.startProject(e_pr_numStart);
		
		List<Member> list = service.selectMemberWithoutCri(e_pr_numStart);
		for(int i=0; i<list.size(); i++){
			alramService.insertAlramF(list.get(i).getF_num(), e_pr_numStart, "시작");
		}
		
		return "redirect:/e_mypage/e_projectInfo?e_pr_num=" + e_pr_numStart;
	}
	
	@RequestMapping(value = "/e_additionalRecruit", method = RequestMethod.POST)
	public String e_additionalRecruitPOST(int e_pr_numAddition) throws Exception {
		service.additionalRecruit(e_pr_numAddition);
		
		return "redirect:/e_mypage/e_projectInfo?e_pr_num=" + e_pr_numAddition;
	}
	
	@RequestMapping(value = "/e_endProject", method = RequestMethod.POST)
	public String e_endProjectPOST(int e_pr_numEnd, String p_nameEnd) throws Exception {
		service.endProject(e_pr_numEnd);
		
		List<Member> list = service.selectMemberWithoutCri(e_pr_numEnd);
		for(int i=0; i<list.size(); i++){
			alramService.insertAlramF(list.get(i).getF_num(), e_pr_numEnd, "완료");
		}
		
		return "redirect:/e_mypage/e_projectInfo?e_pr_num=" + e_pr_numEnd;
	}
	
	@RequestMapping(value = "/e_deleteProject", method = RequestMethod.POST)
	public String e_deleteProjectPOST(int e_pr_numDelete) throws Exception {
		dropService.deleteProject(e_pr_numDelete);
		
		return "redirect:/e_mypage/e_project";
	}
	
	
	
	@RequestMapping(value = "/e_acceptApplicant", method = RequestMethod.POST)
	public String e_acceptApplicantPOST(int f_numAccept, int e_pr_numAccept, String p_nameAccept) throws Exception {
		service.acceptApplicant(f_numAccept, e_pr_numAccept);
		alramService.insertAlramF(f_numAccept, e_pr_numAccept, "수락");

		return "redirect:/e_mypage/e_projectInfo?e_pr_num=" + e_pr_numAccept;
	}
	
	@RequestMapping(value = "/e_rejectApplicant", method = RequestMethod.POST)
	public String e_rejectApplicantPOST(int f_numReject, int e_pr_numReject, String p_nameReject) throws Exception {
		service.rejectApplicant(f_numReject, e_pr_numReject);
		alramService.insertAlramF(f_numReject, e_pr_numReject, "거절");	
		
		return "redirect:/e_mypage/e_projectInfo?e_pr_num=" + e_pr_numReject;
	}
	
	@RequestMapping(value = "/e_cancelScout", method = RequestMethod.POST)
	public String e_cancelScoutPOST(int f_numCancel, int e_pr_numCancel) throws Exception {
		service.cancelScout(f_numCancel, e_pr_numCancel);
		
		return "redirect:/e_mypage/e_projectInfo?e_pr_num=" + e_pr_numCancel;
	}
}
