package lancer.total.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c_using/*")
public class c_usingController {
	@RequestMapping("/service")
	public void service(){
		
	}
	@RequestMapping("/e_service")
	public void e_service(){
		
	}
	@RequestMapping("f_service")
	public void f_service(){
		
	}
}
