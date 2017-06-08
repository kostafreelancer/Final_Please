package lancer.total.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/verification/*")
public class VerificationController {
	
	@RequestMapping(value = "/verificationPop", method = RequestMethod.GET)
	public void verificationpopGET() throws Exception{
		
		
	}
	
	@RequestMapping(value = "/verificationPop", method = RequestMethod.POST)
	public void verificationpopPOST() throws Exception{
		
		
	}
}
