package lancer.total.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String registerPost(F_BoardVO board, Model model)throws Exception{
		service.regist(board);
		model.addAttribute("result", "success");
		return "/f_board/f_list";
	}
	
	@RequestMapping(value="f_list", method=RequestMethod.GET)
	public void listAll(F_BoardVO board, Model model)throws Exception{
		
	}
	@RequestMapping(value="f_readPage", method=RequestMethod.GET)
	public void readPage(F_BoardVO board, Model model)throws Exception{
		
	}
	@RequestMapping(value="f_modifyPage", method=RequestMethod.GET)
	public void modifyPage(F_BoardVO board, Model model)throws Exception{
		
	}
	

}
