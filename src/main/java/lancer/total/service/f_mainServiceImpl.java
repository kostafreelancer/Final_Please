package lancer.total.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.f_main.domain.member;
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
	
}
