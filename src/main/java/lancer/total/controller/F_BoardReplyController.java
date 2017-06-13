package lancer.total.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_PageMaker;
import lancer.f_board.domain.F_ReplyVO;
import lancer.total.service.F_BoardReplyService;

@RestController
@RequestMapping("/replies")
public class F_BoardReplyController {

	@Inject
	private F_BoardReplyService service;
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody F_ReplyVO vo){
		ResponseEntity<String> entity = null;
		try {
			service.addReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/all/{board_num}", method=RequestMethod.GET)
	public ResponseEntity<List<F_ReplyVO>> list(@PathVariable("board_num") Integer board_num){
		ResponseEntity<List<F_ReplyVO>> entity = null;
		try {
			entity = new ResponseEntity<>(service.listReply(board_num), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{reply_num}", method={RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> update(@PathVariable("reply_num") Integer reply_num, @RequestBody F_ReplyVO vo){
		ResponseEntity<String> entity = null;
		try {
			vo.setReply_num(reply_num);
			service.modifyReply(vo);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	@RequestMapping(value="/{reply_num}", method=RequestMethod.DELETE)
	public ResponseEntity<String> remove(@PathVariable("reply_num") Integer reply_num){
		ResponseEntity<String> entity = null;
		try {
			service.removeReply(reply_num);
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value="/{board_num}/{page}", method=RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> listPage(@PathVariable("board_num") Integer board_num, @PathVariable("page") Integer page){
		ResponseEntity<Map<String, Object>> entity = null;
		
		try {
			F_Criteria cri = new F_Criteria();
			cri.setPage(page);
			
			F_PageMaker pageMaker = new F_PageMaker();
			pageMaker.setCri(cri);
			
			Map<String, Object> map = new HashMap<String, Object>();
			List<F_ReplyVO> list = service.listReplyPage(board_num, cri);
			map.put("list", list);
		
			int replyCount = service.count(board_num);
			pageMaker.setTotalCount(replyCount);
			map.put("pageMaker", pageMaker);
			
			entity = new ResponseEntity<Map<String,Object>>(map, HttpStatus.OK);

		
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<Map<String,Object>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
