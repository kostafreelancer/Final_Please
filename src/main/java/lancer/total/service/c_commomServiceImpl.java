package lancer.total.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.total.persistence.c_commonDAO;

@Service
public class c_commomServiceImpl implements c_commonService {
	@Inject
	c_commonDAO dao;
	
}
