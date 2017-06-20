package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.f_main.domain.alram;
import lancer.f_main.domain.member;
import lancer.f_main.domain.recommendProject;
import lancer.total.persistence.f_mainDAO;

@Service
public class f_mainServiceImpl implements f_mainService {

	@Inject
	f_mainDAO dao;

	@Override
	public void getF_info(member m) throws Exception{
		
		
		dao.getF_info(m);
	}
	
	@Override
	public int countFreelancer() throws Exception{
		
		return dao.countFreelancer();
	}
	
	@Override
	public int countProject() throws Exception{
		
		return dao.countProject();
	}
	
	@Override
	public List<recommendProject> recommendProject(int f_num) throws Exception{
		
		return dao.recommendProject(f_num);
	}
	
	@Override
	public int f_create() throws Exception{
		return dao.f_create();
	}
	
	@Override
	public int f_design() throws Exception{
		return dao.f_design();
	}
	
	@Override
	public int f_planner() throws Exception{
		return dao.f_planner();
	}
	
	@Override
	public int f_read(int f_num) throws Exception{
		return dao.f_read(f_num);
	}
	
	@Override
	public List<alram> alram(int f_num) throws Exception{
		return dao.alram(f_num);
	}
}
