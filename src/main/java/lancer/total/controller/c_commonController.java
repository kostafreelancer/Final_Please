package lancer.total.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c_common/*")
public class c_commonController {
	
	@RequestMapping("iframe_remove")
	public void footer(){
		System.out.println("야이 드와! ");
	}
}
