package lancer.total.service;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lancer.c_login.domain.c_login_enterpriseVO;
import lancer.e_mypage.domain.Project;
import lancer.total.persistence.E_MypageDao;

@Service
public class E_MypageService{

	@Inject
	private E_MypageDao dao;
	
	public List<Project> listProjectReady(int e_num) throws Exception {
		return dao.listProjectReady(e_num);
	}
	
	public List<Project> listProjectDoing(int e_num) throws Exception {
		return dao.listProjectDoing(e_num);
	}
	
	public List<Project> listProjectDone(int e_num) throws Exception {
		return dao.listProjectDone(e_num);
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


}
