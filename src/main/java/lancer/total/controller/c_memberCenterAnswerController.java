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
@RequestMapping("/answer")
public class c_memberCenterAnswerController {

	@Inject
	private c_membercenterASKService service;
	
	@RequestMapping(value="/a", method = RequestMethod.POST)
	public ResponseEntity<String> get(@PathVariable("asknum") int asknum){
		ResponseEntity<String> entity = null;
		
		try {
			service.myAnswer(asknum);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/all/{asknum}", method = RequestMethod.GET)
	public ResponseEntity<List<MemberCenterAnswerVO>> myanswerGET(@PathVariable("asknum") int asknum){
		System.out.println("GET");
		
		ResponseEntity<List<MemberCenterAnswerVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.myAnswer(asknum), HttpStatus.OK);
			System.out.println("ajax");
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/myanswer/{asknum}", method = RequestMethod.POST)
	public ResponseEntity<List<MemberCenterAnswerVO>> myAnswer(@PathVariable("asknum") int asknum){
		System.out.println("^^1");
		ResponseEntity<List<MemberCenterAnswerVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.myAnswer(asknum), HttpStatus.OK);
			System.out.println("^^2");
			System.out.println(asknum + "asknum");
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

}
