package lancer.total.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.e_mypage.domain.Criteria;
import lancer.e_mypage.domain.Member;
import lancer.e_mypage.domain.Project;
import lancer.total.persistence.E_MypageDao;

@Service
public class E_MypageService{

	@Inject
	private E_MypageDao dao;

		public List<Project> listProjectReady(int e_num, Criteria cri) throws Exception {
			return dao.listProjectReady(e_num, cri);
		}
		
		public List<Project> listProjectDoing(int e_num, Criteria cri) throws Exception {
			return dao.listProjectDoing(e_num, cri);
		}
		
		public List<Project> listProjectDone(int e_num, Criteria cri) throws Exception {
			return dao.listProjectDone(e_num, cri);
		}
	
		public Integer countProjectReady(int e_num) throws Exception {
			return dao.countProjectReady(e_num);
		}
		
		public Integer countProjectDoing(int e_num) throws Exception {
			return dao.countProjectDoing(e_num);
		}
		
		public Integer countProjectDone(int e_num) throws Exception {
			return dao.countProjectDone(e_num);
		}
		
		
		
		
		
	public Project selectProject(HashMap<String, Integer> map) throws Exception {
		return dao.selectProject(map);
	}
	
	public List<Integer> selectP_job(int e_pr_num) throws Exception {
		return dao.selectP_job(e_pr_num);
	}

	public void updateEnterprise(c_login_enterpriseVO enterprise) throws Exception {
		dao.updateEnterprise(enterprise);
	}
	
	public List<Member> selectMember(int e_pr_num, Criteria cri) throws Exception {
		return dao.selectMember(e_pr_num, cri);
	}
	
	public List<Member> selectApplicant(int e_pr_num, Criteria cri) throws Exception {
		return dao.selectApplicant(e_pr_num, cri);
	}
	
	public List<Member> selectScout(int e_pr_num, Criteria cri) throws Exception {
		return dao.selectScout(e_pr_num, cri);
	}
	
	public Integer countMember(int e_pr_num) throws Exception {
		return dao.countMember(e_pr_num);
	}
	
	public Integer countApplicant(int e_pr_num) throws Exception {
		return dao.countApplicant(e_pr_num);
	}
	
	public Integer countScout(int e_pr_num) throws Exception {
		return dao.countScout(e_pr_num);
	}

	
	public void acceptApplicant(int f_num, int e_pr_num) throws Exception {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("f_num", f_num);
		map.put("e_pr_num", e_pr_num);
		
		dao.acceptApplicant(map);
	}
	
	public void rejectApplicant(int f_num, int e_pr_num) throws Exception {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("f_num", f_num);
		map.put("e_pr_num", e_pr_num);
		
		dao.rejectApplicant(map);
	}
	
	public void cancelScout(int f_num, int e_pr_num) throws Exception {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("f_num", f_num);
		map.put("e_pr_num", e_pr_num);
		
		dao.cancelScout(map);
	}

}
