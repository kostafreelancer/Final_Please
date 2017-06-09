package lancer.total.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/verification/*")
public class VerificationController {
	
	@RequestMapping(value = "/verificationPop", method = RequestMethod.GET)
	public void verificationpopGET() throws Exception{}
	
	@RequestMapping(value = "/verificationPop", method = RequestMethod.POST)
	public void verificationpopPOST(@RequestParam(value="name")String name, 
			@RequestParam(value="EmailId")String email) throws Exception{
			System.out.println("pop1" + name+email);
		
	}
	
	
	@RequestMapping(value = "/verificationPop2", method = RequestMethod.GET)
	public void verificationpopGET2() throws Exception{}
	
	@RequestMapping(value = "/verificationPop2", method = RequestMethod.POST)
	public void verificationpopPOST2(@RequestParam(value="id")String id, 
			@RequestParam(value="name")String name, 
			@RequestParam(value="EmailId")String email) throws Exception{
		System.out.println(id+name+email);
		
	}
}
