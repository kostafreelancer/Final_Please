package lancer.total.controller;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lancer.total.service.VerificationService;
import lancer.total.service.e_MainService;

@Controller
@RequestMapping("/verification/*")
public class VerificationController {
	
	@Inject
	private VerificationService verificationService;
	
	@RequestMapping(value = "/verificationPop", method = RequestMethod.GET)
	public void verificationpopGET() throws Exception{}
	
	@RequestMapping(value = "/verificationPop", method = RequestMethod.POST)
	public String verificationpopPOST(@RequestParam("name")String name, 
			@RequestParam("EmailId")String emailId, @RequestParam("EmailDomain")String emailDomain, @RequestParam("sort")String sort, Model model) throws Exception{

			String emailAddr = emailId+"@"+emailDomain;
			
			HashMap<String, String> into_map = new HashMap<String, String>();
			into_map.put("name", name);
			into_map.put("EmailAddr", emailAddr);
			
			Integer f_count = verificationService.checking_freelancer(into_map);
			Integer e_count = verificationService.checking_enterprise(into_map);
			
			String f_id = verificationService.verifying_freelancer_id(into_map);
			String e_id = verificationService.verifying_enterprise_id(into_map);

			String page = "";
			
			if(sort.equals("f")){//프리랜서면
				if(f_count==1){//회원이 있는 것으로 판명. 아이디 확인되었습니다.
					model.addAttribute("f_id", f_id);
					page = "/verification/verified";

				}else{
					model.addAttribute("fail", "true");
					page = "/verification/verificationPop";
				}
			}else{//기업이면
				if(e_count==1){//회원이 있는 것으로 판명. 아이디 확인되었습니다.
					model.addAttribute("e_id", e_id);
					page = "/verification/verified";
				}else{
					model.addAttribute("fail", "true");
					page = "/verification/verificationPop";
				}
			}
			return page;
	}
	
	
	@RequestMapping(value = "/verificationPop2", method = RequestMethod.GET)
	public void verificationpopGET2() throws Exception{}
	
	@RequestMapping(value = "/verificationPop2", method = RequestMethod.POST)
	public String verificationpopPOST2(@RequestParam("id")String id, @RequestParam("name")String name, 
			@RequestParam("EmailId")String emailId, @RequestParam("EmailDomain")String emailDomain, @RequestParam("sort")String sort, Model model) throws Exception{
			System.out.println("아이디: "+id+"이름: "+name+" 이메일: "+emailId+"@"+emailDomain+" 분류: "+sort);
			String emailAddr = emailId+"@"+emailDomain;
			
			HashMap<String, String> into_map = new HashMap<String, String>();
			into_map.put("id", id);
			into_map.put("name", name);
			into_map.put("EmailAddr", emailAddr);
			
			Integer f_count = verificationService.checking_freelancer(into_map);
			Integer e_count = verificationService.checking_enterprise(into_map);
			
			String f_pwd = verificationService.verifying_freelancer_pwd(into_map);
			String e_pwd = verificationService.verifying_enterprise_pwd(into_map);
			
			String page = "";
			
			if(sort.equals("f")){//프리랜서면
				if(f_count==1){//회원이 있는 것으로 판명. 아이디 확인되었습니다.
					page = "/verification/emailVerification";
					
				}else{
					model.addAttribute("fail", "true");
					page = "/verification/verificationPop";
				}
			}else{//기업이면
				if(e_count==1){//회원이 있는 것으로 판명. 아이디 확인되었습니다.
					page = "/verification/emailVerification";
					
				}else{
					model.addAttribute("fail", "true");
					page = "/verification/verificationPop";
				}
			}
			return page;	
	}
}
