package lancer.total.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_freelancerlist.domain.c_freelancerlist_SearchCriteria;
import lancer.c_freelancerlist.domain.c_freelancerlist_careerVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_schoolVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_searchVO;
import lancer.c_freelancerlist.domain.c_freelancerlist_totalVO;
import lancer.c_login.domain.c_login_freelancerVO;
import lancer.c_projectlist.domain.Contract;
import lancer.c_projectlist.domain.SearchCriteria;
import lancer.c_projectlist.domain.SubmitVO;
import lancer.e_insertproject.domain.E_Insert;
import lancer.e_mypage.domain.Project;
import lancer.f_mypage.domain.Career;
import lancer.f_mypage.domain.Certificate;
import lancer.f_mypage.domain.Freelancer;
import lancer.f_mypage.domain.NowProject;
import lancer.f_mypage.domain.Portfolio;
import lancer.f_mypage.domain.School;
import lancer.total.persistence.c_freelancerlistDAO;

@Service
public class c_freelancerlistServiceImpl implements c_freelancerlistService {
	@Inject
	c_freelancerlistDAO dao;
	@Override
	public List<c_freelancerlist_totalVO> c_freelancerlist_select_basic(c_freelancerlist_SearchCriteria cri) throws Exception {
		
		List<c_freelancerlist_totalVO> list = dao.c_freelancerlist_select_basic(cri);
		
		List<Integer> job_list =new ArrayList<Integer>();
		int count1 =0;
		int count2 =0;
		int count3=0;
		
		list = dao.c_freelancerlist_select_basic(cri);
		for(int i=0;i<list.size();i++){
			job_list = dao.selectF_job(list.get(i).getF_num());
			//프로젝트 번호로 분야를 배열로 가져온거
			for(int j=0;j<job_list.size();j++){ //그 분야 만큼 불러서 카운팅하고 
				if(job_list.get(j)<30){
					count1++;
				}else if(job_list.get(j)<41){
					count2++;
				}else{
					count3++;
				}
			}
			if(count1>count2&count1>count3){
				list.get(i).setF_field("개발");
			}else if(count2>count1&count2>count3){
				list.get(i).setF_field("디자인");
			}else if(count3>count1&count3>count2){
				list.get(i).setF_field("기획");
			}else{
				list.get(i).setF_field("공통");
			}
			count1=0;
			count2=0;
			count3=0;
		}
		
		List<c_freelancerlist_schoolVO> schoollist = new ArrayList<c_freelancerlist_schoolVO>();
		List<c_freelancerlist_careerVO> careerlist = new ArrayList<c_freelancerlist_careerVO>();
		for(int i=0;i<list.size();i++){
			int check1 = 0;
			int check2 = 0;
			int check3 = 0;
			int check4 = 0;
			int total_career=0;
			list.get(i).setList_career(dao.c_freelancerlist_select_career(list.get(i).getF_num()));
			list.get(i).setList_job(dao.c_freelancerlist_select_job(list.get(i).getF_num()));
			list.get(i).setList_portfolio(dao.c_freelancerlist_select_portfolio(list.get(i).getF_num()));
			list.get(i).setList_school(dao.c_freelancerlist_select_school(list.get(i).getF_num()));
			careerlist = list.get(i).getList_career();
			if(!careerlist.isEmpty()){
				for(int j=0;j<careerlist.size();j++){
					total_career += careerlist.get(j).getCareer_year();
				}
				list.get(i).setF_highest_career("경력: "+total_career+" 년 ");
			}
			schoollist = dao.c_freelancerlist_select_school(list.get(i).getF_num());
			if(schoollist.size()>0){
				
				for(int j=0;j<schoollist.size();j++){
					if(schoollist.get(j).getSchool_degree().equals("박사")){
						check1++;
					}else if(schoollist.get(j).getSchool_degree().equals("석사")){
						check2++;
					}else if(schoollist.get(j).getSchool_degree().equals("학사")){
						check3++;
					}else{
						check4++;
					}
				}
				if(check1!=0){
					list.get(i).setF_highest_school("박사");
				}else if(check2!=0){
					list.get(i).setF_highest_school("석사");
				}else if(check3!=0){
					list.get(i).setF_highest_school("학사");
				}else{
					list.get(i).setF_highest_school("전문 학사");
				}
			}
			
		}
		return list;
	}
	@Override
	public Integer c_freelancerlist_totalCount(c_freelancerlist_SearchCriteria cri) {
		return dao.c_freelancerlist_totalCount(cri);
	}
	
	@Override
	public c_freelancerlist_totalVO selectFreelancer(Integer f_num) throws Exception{
		return dao.selectFreelancer(f_num);
	}
	
	@Override
	public List<Integer> selectF_job(int f_num) throws Exception{
		return dao.selectF_job(f_num);
	}
	
	@Override
	public List<Career> showCareerInfo(int f_num) throws Exception {
		return dao.showCareerInfo(f_num);
	}
	@Override
	public List<School> showSchoolInfo(int f_num) throws Exception{
		return dao.showSchoolInfo(f_num);
	}
	@Override
	public List<Certificate> showCertiInfo(int f_num) throws Exception{
		return dao.showCertiInfo(f_num);
	}
	@Override
	public List<NowProject> getMyFinishProject(int f_num) throws Exception{
		return dao.getMyFinishProject(f_num);
	}
	
	@Override
	public List<String> getProjectP_job(int e_pr_num) throws Exception{
		return dao.getProjectP_job(e_pr_num);
	}
	
	@Override
	public int getnum() throws Exception{
		return dao.getnum();
	}

	@Override
	public void insertContract(SubmitVO submitVO) throws Exception {
		dao.insertContract(submitVO);
		
	}
	
	@Override
	public List<E_Insert> getProject(int e_num)throws Exception{
		return dao.getProject(e_num);
	}
	@Override
	public List<Portfolio> showPortfolioInfo(int f_num) throws Exception{
		return dao.showPortfolioInfo(f_num);
	}
	@Override
	public Portfolio selectOnePortfolio(int portfolio_num) throws Exception{
		return dao.selectOnePortfolio(portfolio_num);
	}
	@Override
	public int getPortfolioNum() throws Exception{
		return dao.getPortfolioNum();
	}
	@Override
	public int selectCon(c_freelancerlist_searchVO vo) throws Exception{
		return dao.selectCon(vo);
	}
	
	
	
}
