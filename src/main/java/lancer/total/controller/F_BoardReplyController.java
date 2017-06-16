package lancer.total.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_PageMaker;
import lancer.f_board.domain.F_ReplyVO;
import lancer.total.service.F_BoardReplyService;

@RestController
@RequestMapping("/reply/")
public class F_BoardReplyController {

	@Inject
	private F_BoardReplyService service;
	

	@RequestMapping(value="insert.do", method=RequestMethod.POST)
    public void insert(@ModelAttribute F_ReplyVO vo, HttpSession session) throws Exception{
       /* Integer userId = (Integer) session.getAttribute("f_num");
        vo.setF_num(userId);*/
        service.create(vo);
    }
    
    @RequestMapping(value="insertRest.do", method=RequestMethod.POST)
    public ResponseEntity<String> insertRest(@RequestBody F_ReplyVO vo, HttpSession session)throws Exception{
        ResponseEntity<String> entity = null;
        int count = service.count(vo.getBoard_num())+1; 
        System.out.println("참도~햇겟다~");
        try {
           // String userId = (String) session.getAttribute("userId");
            //vo.setReplyer(userId);
        	vo.setReply_num(count);
            service.create(vo);
            // 댓글입력이 성공하면 성공메시지 저장
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // 댓글입력이 실패하면 실패메시지 저장
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        // 입력 처리 HTTP 상태 메시지 리턴
        return entity;
    }
	
    // 댓글 목록(@Controller방식 : veiw(화면)를 리턴)
    @RequestMapping("list.do")
    public ModelAndView list(@RequestParam int board_num,
                            ModelAndView mav,
                            HttpSession session) throws Exception{
        // **페이징 처리 
       // 댓글 갯수

        List<F_ReplyVO> list = service.list(board_num);
        // 뷰이름 지정
        mav.setViewName("f_board/replyList");
        // 뷰에 전달할 데이터 지정
        mav.addObject("list", list);
        // replyList.jsp로 포워딩
        return mav;
    }
    
    // 댓글 목록(@RestController Json방식으로 처리 : 데이터를 리턴)
    @RequestMapping("listJson.do")
    @ResponseBody // 리턴데이터를 json으로 변환(생략가능)
    public List<F_ReplyVO> listJson(@RequestParam("bno") int board_num)throws Exception{
    	System.out.println("ㄴ리바보");
        List<F_ReplyVO> list = service.list(board_num);
        return list;
    }
    
    // 4. 댓글 수정 처리 - PUT:전체 수정, PATCH:일부수정
    // RequestMethod를 여러 방식으로 설정할 경우 {}안에 작성
    @RequestMapping(value="/update/{reply_num}", method={RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<String> replyUpdate(@PathVariable("reply_num") Integer reply_num, @RequestBody F_ReplyVO vo){
        ResponseEntity<String> entity = null;
        try {
            vo.setReply_num(reply_num);
            service.update(vo);
            // 댓글 수정이 성공하면 성공 상태메시지 저장
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // 댓글 수정이 실패하면 실패 상태메시지 저장
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        // 수정 처리 HTTP 상태 메시지 리턴
        return entity;
    }
    
    // 5. 댓글 삭제처리
    @RequestMapping(value="/delete/{reply_num}")
    public ResponseEntity<String> replyDelete(@PathVariable("reply_num") Integer reply_num){
        ResponseEntity<String> entity = null;
        try {
            service.delete(reply_num);
            // 댓글 삭제가 성공하면 성공 상태메시지 저장
            entity = new ResponseEntity<String>("success", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            // 댓글 삭제가 실패하면 실패 상태메시지 저장
            entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        // 삭제 처리 HTTP 상태 메시지 리턴
        return entity;
    }
}
    
    
	/*@RequestMapping(value="/test", method=RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody F_ReplyVO vo){
		System.out.println("잘가..광명아...ㅜ");
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
	public ResponseEntity<List<F_ReplyVO>> list(@PathVariable("board_num") Integer board_num, Model model) throws Exception{
		model.addAttribute("test_list", service.listReply(board_num));
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
	}*/

