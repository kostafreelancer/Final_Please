package lancer.total.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lancer.f_board.domain.F_BoardVO;
import lancer.total.service.F_BoardService;

@Controller
@RequestMapping("/f_board/*")
public class F_BoardController {
	
	@Inject
	private F_BoardService service;
	
	@RequestMapping(value="f_register", method=RequestMethod.GET)
	public void registerGet(F_BoardVO board, Model model)throws Exception{
		
	}
	
	@RequestMapping(value="f_register", method=RequestMethod.POST)
	public String registerPost(F_BoardVO board, RedirectAttributes rttr)throws Exception{
		service.regist(board);
		rttr.addAttribute("msg", "success");
		return "redirect:/f_board/f_list";
	}
	
	@RequestMapping(value="f_list", method=RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		model.addAttribute("list", service.listAll());
	}
	@RequestMapping(value="f_readPage", method=RequestMethod.GET)
	public void readPage(@RequestParam("f_board_num") int  f_board_num, Model model)throws Exception{
		model.addAttribute(service.read(f_board_num));
	}
	@RequestMapping(value="f_modifyPage", method=RequestMethod.GET)
	public void modifyPage(F_BoardVO board, Model model)throws Exception{
		
	}
	

}
