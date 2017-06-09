package lancer.total.controller;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
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
			@RequestParam("EmailId")String email, @RequestParam("sort")String sort) throws Exception{
			System.out.println("이름: "+name+" 이메일: "+email+" 분류: "+sort);
		
			HashMap<String, String> into_map = new HashMap<String, String>();
			into_map.put("name", name);
			into_map.put("EmailId", email);
			
			Integer freelancer_count = verificationService.checking_freelancer(into_map);
			Integer enterprise_count = verificationService.checking_enterprise(into_map);
			
			System.out.println(freelancer_count+"카운트");
			String page = "";
			
			if(sort.equals("f")){//프리랜서면
				System.out.println(freelancer_count+"2번");
				if(freelancer_count==1){
					System.out.println(freelancer_count+"3번");
					page = "redirect:/verification/verified";
				}else{
					page = "redirect:/verification/verificationPop?fail=true";
				}
			}else{//기업이면
				if(enterprise_count==1){
					page = "redirect:/verification/verified";
				}else{
					page = "redirect:/verification/verificationPop?fail=true";
				}
			}
			return page;
	}
	
	
	@RequestMapping(value = "/verificationPop2", method = RequestMethod.GET)
	public void verificationpopGET2() throws Exception{}
	
	@RequestMapping(value = "/verificationPop2", method = RequestMethod.POST)
	public void verificationpopPOST2() throws Exception{
		
	}
}
