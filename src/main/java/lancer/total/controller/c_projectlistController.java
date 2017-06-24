package lancer.total.controller;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lancer.c_freelancerlist.domain.c_freelancerlist_searchVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_projectlist.domain.Contract;
import lancer.c_projectlist.domain.PageMaker;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.c_projectlist.domain.SubmitVO;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_insertproject.domain.Enterprise;
import lancer.total.service.C_AlramService;
import lancer.total.service.c_projectlistService;

@Controller
@RequestMapping("/c_projectlist/*")
public class c_projectlistController {
	
	@Inject
	c_projectlistService service;
	
	@Inject
	C_AlramService alramService;
	
	@RequestMapping(value = "/c_projectlist")
	public void projectlistGET(@ModelAttribute("cri") SearchCriteria cri,Model model,HttpSession session,HttpServletRequest request) throws Exception{
		
		String[] job = request.getParameterValues("fm_new_keyword[]");
		String fr = request.getParameter("fr_new_keyword");
		String ft = request.getParameter("ft_new_keyword");
		if(cri.getJobs()==null){
			cri.setJobs(job);
		}
	/*	if(fr != null){
			cri.setFr(fr);
		}
		if(ft != null){
			cri.setFt(ft);
		}*/
		System.out.println(cri.getFr()+"이거이거");
		System.out.println(fr+"이건 fr");
		if(cri.getFr()==null){
			cri.setFr(fr);
		}
		
		if(cri.getFt()==null){
			cri.setFt(ft);
			
		}
		System.out.println(cri.getFr()+"야이거 나와");
		List<E_Insert> list = service.listSearch(cri);
		if(cri.getJobs()!=null){
			String str[] =cri.getJobs();
			for(int i=0;i<cri.getJobs().length;i++){
				
				System.out.println(str[i]);
			}
		}else{
			cri.setJobs(job);
		}
		System.out.println(service.listSearchCount(cri) + "갯수");
		model.addAttribute("list", list);
		PageMaker pageMaker =  new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
		
	}
	
	@RequestMapping(value="/c_readpage", method= RequestMethod.GET)
	public void readPage(@ModelAttribute("cri") SearchCriteria cri,HttpSession session,@RequestParam("e_pr_num") int e_pr_num,@RequestParam("e_num") int e_num, String from, Model model) throws Exception{
		int myRelation = 0;
		
		if(session.getAttribute("client") instanceof c_login_freelancerVO){
			c_login_freelancerVO freelancer = (c_login_freelancerVO) session.getAttribute("client");
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("f_num", freelancer.getF_num());
			map.put("e_pr_num", e_pr_num);
			System.out.println(e_pr_num);
			System.out.println(freelancer.getF_num());
			myRelation = service.getRelation(map);
			
			if(myRelation==2){
				double myEval = service.myEval(map);
				model.addAttribute("myEval", myEval);
			}
		}
		System.out.println(myRelation);
		model.addAttribute("myRelation", myRelation);

		
	
		
		//담당자정보 구하기
		Enterprise enterprise = service.selectEnterprise(e_num);
		model.addAttribute("enterprise", enterprise);
		model.addAttribute("e_pr_num", e_pr_num);
		String[] manager_hphone = enterprise .getManager_hphone().split("-");
		model.addAttribute("manager_hphone_1", manager_hphone[0]);
		model.addAttribute("manager_hphone_2", manager_hphone[1]);
		model.addAttribute("manager_hphone_3", manager_hphone[2]);
		
		String[] manager_mail = enterprise.getManager_mail().split("@");
		model.addAttribute("manager_mail_1", manager_mail[0]);
		model.addAttribute("manager_mail_2", manager_mail[1]);
		
		//프로젝트 정보구하기
		E_Insert project = service.read(e_pr_num);
	    model.addAttribute("project", project);
				
		//상세분야 구하기
		List<Integer> p_job = service.selectP_job(e_pr_num);
		model.addAttribute("p_job", p_job);
		
			if(from.equals("list")){
				model.addAttribute("from", "list");
			}else if(from.equals("mypage")){
				model.addAttribute("from", "mypage");
			}else if(from.equals("evaluate")){
				model.addAttribute("from", "evaluate");
			}
		
		
	}
	
	@RequestMapping(value = "/complete", method = RequestMethod.GET)
	public String readPagePOST(Contract contract, HttpSession session, Model model,@RequestParam("e_pr_num") int e_pr_num, RedirectAttributes rttr,@RequestParam("e_num") int e_num, String from) throws Exception{
	
		SubmitVO submitVO = new SubmitVO();
		
		c_login_freelancerVO freelancer = (c_login_freelancerVO)session.getAttribute("client");
        model.addAttribute("contract", session.getAttribute("contract"));
        
        submitVO.setF_num(freelancer.getF_num());
        submitVO.setE_pr_num(e_pr_num);
		
        c_freelancerlist_searchVO vo = new c_freelancerlist_searchVO();
		vo.setF_num(freelancer.getF_num());
		vo.setE_pr_num(e_pr_num);
        	
		int con = service.selectCon(vo);
		
		if(con!=0){
			rttr.addFlashAttribute("msg","conCheck");
			System.out.println("안와??!!!");
			return "redirect:/c_projectlist/c_readpage?e_pr_num="+e_pr_num+"&e_num="+e_num+"&from=list";
		}else{
			int c_num = service.getnum()+1;
			submitVO.setC_num(c_num);
			
			contract.setC_num(c_num);
			
			service.insertContract(submitVO);
			
			String p_name = service.getProjectName(e_pr_num);
			String ment = p_name + "& 에서 & 참가신청";
			alramService.insertAlramE(e_num, e_pr_num, ment);
		}
		return "/c_projectlist/complete";
		
        	/*int c_num = service.getnum()+1;
    		submitVO.setC_num(c_num);
    		
    		contract.setC_num(c_num);
    		
    		
    		service.insertContract(submitVO);

    		return "/c_projectlist/complete";*/
       
	}



	

}
