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

import lancer.c_login.domain.c_login_freelancerVO;
import lancer.f_board.domain.F_Criteria;
import lancer.f_board.domain.F_PageMaker;
import lancer.f_board.domain.F_ReplyVO;
import lancer.total.service.F_BoardReplyService;
import lancer.total.service.F_BoardService;

@RestController
@RequestMapping("/reply/")
public class F_BoardReplyController {

	@Inject
	private F_BoardReplyService service;
	
	@Inject
	private F_BoardService bs;
    
    @RequestMapping(value="insertRest.do", method=RequestMethod.POST)
    public ResponseEntity<String> insertRest(@RequestBody F_ReplyVO vo, HttpSession sessions)throws Exception{
        ResponseEntity<String> entity = null;
        int count = service.count(vo.getBoard_num())+1; 
        System.out.println("참도~햇겟다~");
        try {
        	//세션의 회원아이디 가져오기
        	c_login_freelancerVO freelancer = (c_login_freelancerVO) sessions.getAttribute("client");
            vo.setF_id(freelancer.getF_id());
            System.out.println(freelancer.getF_id());
            //댓글카운트
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
	
/*    // 댓글 목록(@Controller방식 : veiw(화면)를 리턴)
    @RequestMapping("list.do")
    public ModelAndView list(@RequestParam int board_num,
                            ModelAndView mav,
                            HttpSession sessions) throws Exception{
        List<F_ReplyVO> list = service.list(board_num, sessions);
        // 뷰이름 지정
        mav.setViewName("f_board/replyList");
        // 뷰에 전달할 데이터 지정
        mav.addObject("list", list);
        // replyList.jsp로 포워딩
        return mav;
    }
    */
    
    // 댓글 목록(@RestController Json방식으로 처리 : 데이터를 리턴)
    @RequestMapping("listJson.do")
    @ResponseBody // 리턴데이터를 json으로 변환(생략가능)
    public List<F_ReplyVO> listJson(@RequestParam("bno") int board_num, HttpSession sessions)throws Exception{
    	System.out.println("ㄴ리바보");
    	c_login_freelancerVO freelancer = (c_login_freelancerVO) sessions.getAttribute("client");
    	System.out.println(freelancer.getF_id()+"으알ㄴㅇㄹㅇ");
    	System.out.println(board_num+"이것은 보드넘");
    	System.out.println(bs.read(board_num));
    	System.out.println(bs.read(board_num).getF_id());
        List<F_ReplyVO> list = service.list(board_num, freelancer.getF_id(), bs.read(board_num).getF_id());
        return list;
    }

    
    // 4. 댓글 수정 처리 - PUT:전체 수정, PATCH:일부수정
    // RequestMethod를 여러 방식으로 설정할 경우 {}안에 작성
    @RequestMapping(value="update/{reply_num}", method={RequestMethod.PUT, RequestMethod.PATCH})
    public ResponseEntity<String> replyUpdate(@PathVariable("reply_num") Integer reply_num, @RequestBody F_ReplyVO vo){
        ResponseEntity<String> entity = null;
        System.out.println("여기는?!!?!??");
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
    @RequestMapping(value="delete/{reply_num}")
    public ResponseEntity<String> replyDelete(@PathVariable("reply_num") Integer reply_num){
        ResponseEntity<String> entity = null;
        System.out.println(reply_num);
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
    


