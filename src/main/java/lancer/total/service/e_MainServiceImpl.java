package lancer.total.service;

import java.awt.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.total.persistence.e_mainDAO;

@Service
public class e_MainServiceImpl implements e_MainService {

	@Inject
	e_mainDAO e_mainDao;
	
	@Override
	public Integer countFreelancer() throws Exception {
		
		return e_mainDao.countFreelancer();
	}

	@Override
	public Integer countProject() throws Exception {
		
		return e_mainDao.countProject();
	}

	@Override
	public Integer e_developer() throws Exception {
		
		return e_mainDao.e_developer();
	}

	@Override
	public Integer e_designer() throws Exception {
		
		return e_mainDao.e_designer();
	}

	@Override
	public Integer e_planner() throws Exception {
		
		return e_mainDao.e_planner();
	}

	@Override
	public Integer development() throws Exception {
		
		return e_mainDao.development();
	}

	@Override
	public Integer design() throws Exception {
		
		return e_mainDao.design();
	}

	@Override
	public Integer planning() throws Exception {
		
		return e_mainDao.planning();
	}
	
	
	

}
