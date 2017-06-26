package lancer.total.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.total.persistence.e_mainDAO;

@Service
public class e_MainServiceImpl implements e_MainService {

	@Inject
	e_mainDAO e_mainDao;
	
	@Override
	public int countFreelancer() throws Exception {
		
		return e_mainDao.countFreelancer();
	}

	@Override
	public int countProject() throws Exception {
		
		return e_mainDao.countProject();
	}

	@Override
	public int e_developer() throws Exception {
		
		return e_mainDao.e_developer();
	}

	@Override
	public int e_designer() throws Exception {
		
		return e_mainDao.e_designer();
	}

	@Override
	public int e_planner() throws Exception {
		
		return e_mainDao.e_planner();
	}

}
