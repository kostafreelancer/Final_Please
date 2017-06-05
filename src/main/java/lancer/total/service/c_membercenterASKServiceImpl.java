package lancer.total.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.c_membercenter.domain.MembercenterASKVO;
import lancer.total.persistence.c_membercenterASKDAO;

@Service
public class c_membercenterASKServiceImpl implements c_membercenterASKService {

	
	@Inject
	private c_membercenterASKDAO dao;
	
	@Override
	public void insertAsk(MembercenterASKVO vo) throws Exception {
		dao.insertAsk(vo);

	}

}
