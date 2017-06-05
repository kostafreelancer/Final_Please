package lancer.total.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.total.persistence.A_MainDAO;

@Service
public class A_MainService {
	@Inject
	private A_MainDAO dao;
}
