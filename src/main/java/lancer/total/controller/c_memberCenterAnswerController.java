package lancer.total.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sun.mail.iap.Response;

import lancer.c_membercenter.domain.MemberCenterAnswerVO;
import lancer.total.service.c_membercenterASKService;

@RestController
@RequestMapping("/c_membercenter")
public class c_memberCenterAnswerController {

	@Inject
	private c_membercenterASKService service;
	
	@RequestMapping(value="/myanswer/{asknum}", method = RequestMethod.GET)
	public void myanswerGET(){
		System.out.println("GET");
	}
	
	@RequestMapping(value="/myanswer/{asknum}", method = RequestMethod.POST)
	public ResponseEntity<List<MemberCenterAnswerVO>> myAnswer(@PathVariable("asknum") int asknum){
		
		ResponseEntity<List<MemberCenterAnswerVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.myAnswer(asknum), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
