package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_projectlist.domain.Criteria;
import lancer.f_board.domain.F_BoardVO;
import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_PageMaker;
import lancer.f_board.domain.F_ReplyVO;
import lancer.f_board.domain.F_SearchCriteria;
import lancer.total.service.F_BoardReplyService;
import lancer.total.service.F_BoardService;

@Controller
@RequestMapping("/f_board/*")
public class F_BoardController {
	
	@Inject
	private F_BoardService service;
	
	@Inject
	private F_BoardReplyService r_service;
	
	@RequestMapping(value="/f_register", method=RequestMethod.GET)
	public void registerGet(F_BoardVO board, Model model)throws Exception{
		
	}
	
	@RequestMapping(value="/f_register", method=RequestMethod.POST)
	public String registerPost(F_BoardVO board, RedirectAttributes rttr)throws Exception{
		service.regist(board);
		rttr.addFlashAttribute("msg", "success");
		return "redirect:/f_board/f_list";
	}
	@RequestMapping(value="/f_list", method=RequestMethod.GET)
	public void f_list(@ModelAttribute("cri") F_SearchCriteria cri, Model model) throws Exception{
		model.addAttribute("list", service.listCriteria(cri));
		F_PageMaker pageMaker = new F_PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);	
	}
/*@RequestMapping(value="f_listPage", method=RequestMethod.GET)
	public void listAll(F_SearchCriteria cri, Model model)throws Exception{
		model.addAttribute("list", service.listCriteria(cri));
		F_PageMaker pageMaker = new F_PageMaker();
		pageMaker.setCri(cri);
		
		pageMaker.setTotalCount(service.listCountCriteria(cri));
		model.addAttribute("pageMaker", pageMaker);
	}*/
/*	@RequestMapping(value="read", method=RequestMethod.GET)
	public void readPage(@RequestParam("f_board_num") int  f_board_num, Model model)throws Exception{
		model.addAttribute("F_BoardVO", service.read(f_board_num));
	}*/
	
	@RequestMapping(value="/f_readPage", method = RequestMethod.GET)
	public void f_readPage(@RequestParam("f_board_num") int f_board_num, @ModelAttribute("cri") F_SearchCriteria cri, Model model, HttpSession sessions) throws Exception{
		model.addAttribute("F_BoardVO", service.read(f_board_num));
		//c_login_freelancerVO freelancer = (c_login_freelancerVO) sessions.getAttribute("client");
		//List<F_ReplyVO> mylist = r_service.list(f_board_num, freelancer.getF_id(), service.read(f_board_num).getF_id());
		//model.addAttribute("F_ReplyVO", r_service.list(f_board_num, freelancer.getF_id(), service.read(f_board_num).getF_id()));
		//System.out.println(r_service.list(f_board_num).get(0).get);
		//for(int i=0; i<mylist.size(); i++){
		//	System.out.println(mylist.get(i).getBoard_num());
		//}
		
	}

	@RequestMapping(value="/f_remove", method=RequestMethod.POST)
	public String remove(@RequestParam("f_board_num") int f_board_num, RedirectAttributes rttr, F_SearchCriteria cri)throws Exception{
		service.remove(f_board_num);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/f_board/f_list";
	}
	@RequestMapping(value="/f_modifyPage", method=RequestMethod.GET)
	public void f_modifyPage(@RequestParam("f_board_num") int f_board_num, @ModelAttribute("cri") F_SearchCriteria cri, Model model)throws Exception{
		/*System.out.println("들어오셧?");
		System.out.println(f_board_num);*/
		model.addAttribute("F_BoardVO", service.read(f_board_num));
		
	}
	@RequestMapping(value="/f_modifyPage", method=RequestMethod.POST)
	public String modifyPost(F_BoardVO board,F_SearchCriteria cri , RedirectAttributes rttr)throws Exception{
		service.modify(board);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		rttr.addFlashAttribute("msg", "SUCCESS");
		System.out.println("오이이이잉");
		return "redirect:/f_board/f_list";
	}
	

	

	
/*@RequestMapping(value="listCri", method=RequestMethod.GET)
	public void listAll(F_Criteria cri, Model model)throws Exception{
		System.out.println("dfdfd");
		model.addAttribute("list", service.listCriteria(cri));
	}*/
	
/*	@RequestMapping("/getAttach/{bno}")
	@ResponseBody
	public List<String> getAttach(@PathVariable("bno") Integer bno) throws Exception{
		return service.getAttach(bno);
	}*/
	

}
