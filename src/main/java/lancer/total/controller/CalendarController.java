package lancer.total.controller;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lancer.total.service.F_MypageService;

@RestController
@RequestMapping("/f_mypage/schedule")
public class CalendarController {

	@Inject
	private F_MypageService service;
	
}
