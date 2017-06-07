package lancer.total.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lancer.c_join.domain.E_join;
import lancer.c_join.domain.F_join;
import lancer.f_mypage.domain.F_job;
import lancer.total.persistence.C_JoinDAO;
import lancer.total.service.C_JoinService;

@Controller
@RequestMapping("/c_join/*")
public class C_JoinController {

	@Inject
	private C_JoinService service;
	
	   @RequestMapping(value = "duplicationCheck")
	   public @ResponseBody boolean duplicationCheck(@RequestParam("id") String f_id) throws Exception {
	      System.out.println("들어와떠");
	      System.out.println(f_id);
	      
	      if(service.f_idcheck(f_id)==1){
	    	  return false;
	      }else{
/*	    	  if((f_id < "0" || f_id > "9") 
						 && (f_id < "A" || f_id > "Z") 
						 && (f_id < "a" || f_id > "z")
						 && (f_id="-")
						 && (f_id="_")){ 
				        alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
				        return false;
				 }
				 
				 if(f_id.length < 5){
					 alert("길이확인");
					 return false;
				 } */
	    	  return true;
	      }
     
	   }
	   @RequestMapping(value = "duplicationCheck2")
	   public @ResponseBody boolean duplicationCheck2(@RequestParam("id") String e_id) throws Exception {
		   System.out.println("들어와떠");
		   System.out.println(e_id);
		   
		   
		   
		   if(service.e_idcheck(e_id)==1){
			   return false;
		   }else{
			   return true;
		   }
		   
	   }

	
	@RequestMapping(value="c_join_step1")
	public void joinstep1()throws Exception{
	}
	
	@RequestMapping(value="f_join_step2")
	public void f_joinstep2()throws Exception{
	}
	
	@RequestMapping(value="e_join_step2")
	public void e_joinstep2()throws Exception{
	}
	
	@RequestMapping(value="c_join_step4")
	public void joinstep4()throws Exception{
	}
	@RequestMapping(value="f_join_step3", method=RequestMethod.GET)
	public void f_joinstep3()throws Exception{
		
	}
	@RequestMapping(value="e_join_step3", method=RequestMethod.GET)
	public void e_joinstep3()throws Exception{
		
	}
	
	@RequestMapping(value="f_join_step3", method=RequestMethod.POST)
	public String f_joinstep3(F_join f_join, Model model, HttpServletRequest request)throws Exception{
				System.out.println("남과시...ㄱ....");
		String f_hphone1 = f_join.getF_hphone1();
		String f_hphone2 = f_join.getF_hphone2();
		String f_hphone3 = f_join.getF_hphone3();
		String f_hphone = f_hphone1 +"-"+ f_hphone2 +"-"+ f_hphone3;
		f_join.setF_hphone(f_hphone);
		System.out.println(f_join.getF_hphone());
		
		String f_phone1 = f_join.getF_phone1();
		String f_phone2 = f_join.getF_phone2();
		String f_phone3 = f_join.getF_phone3();
		String f_phone = f_phone1 +"-"+ f_phone2 +"-"+ f_phone3;
		f_join.setF_phone(f_phone);
		System.out.println(f_join.getF_phone());
		
		String f_email1 = f_join.getF_email1();
		String f_email2 = f_join.getF_email2();
		String f_email = f_email1+"@"+f_email2;
		f_join.setF_email(f_email);

		String f_address1=f_join.getF_address1();
		String f_address2=f_join.getF_address2();
		String f_address3=f_join.getF_address3();
		String f_address=f_address1+"&"+f_address2+"&"+f_address3;
		f_join.setF_address(f_address);
		System.out.println(f_join.getF_address());
		
		//f_join.setF_birth(f_join.getF_birth());
		f_join.setF_fname("/사진");
		//f_join.setF_id(f_join.getF_id());
		//f_join.setF_major(request.getParameter("f_major"));
/*		f_join.setF_name(f_join.getF_name());*/
		f_join.setF_nowstate("활동");
		f_join.setF_num(service.getF_num()+1);
		System.out.println(f_join.getF_num());
/*		f_join.setF_pwd(f_join.getF_pwd());*/
		f_join.setF_recentlogin("2017/01/05");
		f_join.setF_score(0);
/*		f_join.setF_major(f_join.getF_major());*/
		if(f_join.getF_sex().equals("1")){
			f_join.setF_sex("남");
		}else{
			f_join.setF_sex("여");
		}
		System.out.println(f_join.getF_sex());
		service.insertF_join(f_join);
		
		String[] checkBasic = request.getParameterValues("fm_new_keyword");
		int mynum = service.getF_num();
		System.out.println(mynum);
		for(int i=0;i<checkBasic.length;i++)
		{
			service.insertF_Job(new F_job(mynum, Integer.parseInt(checkBasic[i])));
			System.out.println(checkBasic[i]);
		}
		
		
		
		return "redirect:/c_join/c_join_step4";
	}


	@RequestMapping(value="e_join_step3", method=RequestMethod.POST)
	public String e_joinstep3(E_join e_join, Model model)throws Exception{

		//회사이메일
		String email1 = e_join.getE_mail1();
		String email2 = e_join.getE_mail2();
		String e_email = email1+"@"+email2;
		e_join.setE_mail(e_email);
		System.out.println(e_join.getE_mail());
		
		//매니저이메일
		String managermail1 = e_join.getManager_mail1();
		String managermail2 = e_join.getManager_mail2();
		String manager_mail = managermail1+"@"+managermail2;
		e_join.setManager_mail(manager_mail);
		System.out.println(e_join.getManager_mail());
		
		//담당자 핸드폰번호
		String managerhphone1 = e_join.getManager_hphone1();
		String managerhphone2 = e_join.getManager_hphone2();
		String managerhphone3 = e_join.getManager_hphone3();
		String manager_hphone=managerhphone1+"-"+managerhphone2+"-"+managerhphone3;
		e_join.setManager_hphone(manager_hphone);
		System.out.println(e_join.getManager_hphone());
		
		//대표번호e_phone1
		String e_phone1 = e_join.getE_phone1();
		String e_phone2 = e_join.getE_phone2();
		String e_phone3 = e_join.getE_phone3();
		String e_phone=e_phone1+"-"+e_phone2+"-"+e_phone3;
		e_join.setE_phone(e_phone);
		System.out.println(e_join.getE_phone());
		
		//사업자번호
		String e_regno1 = e_join.getE_regno1();
		String e_regno2 = e_join.getE_regno2();
		String e_regno3 = e_join.getE_regno3();
		String e_regno=e_regno1+"-"+e_regno2+"-"+e_regno3;
		e_join.setE_regno(e_regno);
		System.out.println(e_join.getE_regno());
		
		//주소
		String address1=e_join.getE_address1();
		String address2=e_join.getE_address2();
		String address3=e_join.getE_address3();
		String e_address=address1+"&"+address2+"&"+address3;
		e_join.setE_address(e_address);
		System.out.println(e_join.getE_address());
		
		e_join.setE_num(service.getE_num()+1);
		System.out.println(e_join.getE_num()+1);
		e_join.setManager_name(e_join.getManager_name());
		e_join.setE_bf(e_join.getE_bf());
		e_join.setE_capital(e_join.getE_capital());	
		//e_join.setE_check(request.getParameter("e_check"));
		e_join.setE_check("미승인");
		e_join.setE_ename(e_join.getE_ename());
		e_join.setE_enum(e_join.getE_enum());
		e_join.setE_homepage(e_join.getE_homepage());
		e_join.setE_id(e_join.getE_id());
		//e_join.setE_licensefile(request.getParameter("e_licensefile"));
		e_join.setE_licensefile("jj");
		e_join.setE_score(0);
		e_join.setE_listing(e_join.getE_listing());
		e_join.setE_name(e_join.getE_name());
		e_join.setE_owner(e_join.getE_owner());
		e_join.setE_ownerfile(e_join.getE_ownerfile());
		e_join.setE_pwd(e_join.getE_pwd());
		e_join.setE_sales(e_join.getE_sales());
		e_join.setE_scale(e_join.getE_scale());
		e_join.setStart_year(e_join.getStart_year());
		
		service.insertE_join(e_join);
		
		return "redirect:/c_join/c_join_step4";
	}

}
