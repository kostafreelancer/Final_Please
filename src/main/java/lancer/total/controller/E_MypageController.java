package lancer.total.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.e_mypage.domain.EnterpriseCommand;
import lancer.e_mypage.domain.Project;
import lancer.total.service.C_FileService;
import lancer.total.service.E_MypageService;
import lancer.total.util.FileUtils;

@Controller
@RequestMapping("/e_mypage/*")
public class E_MypageController {

	@Inject
	private E_MypageService service;
	
	@Inject
	private C_FileService fileService;

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
		HashMap<String, Object> e_ownerfileMap = fileService.selectFile("e_ownerfile", enterprise.getE_num());
		HashMap<String, Object> e_ownerfileMap2 = fileService.selectFileInfo((int) e_ownerfileMap.get("file_num"));
		model.addAttribute("e_ownerFileStoredName", e_ownerfileMap2.get("stored_file_name"));
		
		
		HashMap<String, Object> e_licensefileMap = fileService.selectFile("e_licensefile", enterprise.getE_num());
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
			System.out.println(pwd1);
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
			
		
		//파일 업로드
		if(command.getE_ownerfileExist().equals("true")){
			MultipartFile E_ownerfile = command.getE_ownerfile();	
			fileService.uploadImageFile(E_ownerfile, "e_ownerfile", enterprise.getE_num(), session);
		}
		if(command.getE_licensefileExist().equals("true")){
			MultipartFile e_licensefile = command.getE_licensefile();	
			fileService.uploadFile(e_licensefile, "e_licensefile", enterprise.getE_num(), session);
		}
		
		
		service.updateEnterprise(enterprise);
		session.setAttribute("client", enterprise);		
		return "redirect:/e_mypage/e_info";
	}
	
	
	@RequestMapping(value = "/e_project", method = RequestMethod.GET)
	public void e_projectGET(Model model, HttpSession session) throws Exception{
		
		c_login_enterpriseVO enterprise = (c_login_enterpriseVO)session.getAttribute("client");
		int e_num = enterprise.getE_num();
		System.out.println(e_num + "컨트롤러");
		List<Project> readyList = service.listProjectReady(e_num);
		List<Project> doingList = service.listProjectDoing(e_num);
		List<Project> doneList = service.listProjectDone(e_num);
		
		model.addAttribute("readyList", readyList);
		model.addAttribute("doingList", doingList);
		model.addAttribute("doneList", doneList);
		
	}
	
	@RequestMapping(value = "/e_projectInfo", method = RequestMethod.GET)
	public void e_projectInfoGET(@ModelAttribute("e_pr_num") int e_pr_num, Model model, HttpSession session) throws Exception {

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
	
	

	
}
