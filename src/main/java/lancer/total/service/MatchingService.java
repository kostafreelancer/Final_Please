package lancer.total.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import lancer.total.persistence.MatchingDAO;

@Service
public class MatchingService {
	
	@Inject
	private MatchingDAO dao;
}
