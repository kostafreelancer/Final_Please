package lancer.total.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lancer.total.service.MatchingService;

@Controller
@RequestMapping("/matching")
public class MatchingController {

	@Inject
	private MatchingService service;
}
