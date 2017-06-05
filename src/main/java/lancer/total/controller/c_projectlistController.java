package lancer.total.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/c_projectlist/*")
public class c_projectlistController {
	
	@RequestMapping(value = "/c_projectlist", method = RequestMethod.GET)
	public void projectlistGET() throws Exception{
	
	}
	

}
