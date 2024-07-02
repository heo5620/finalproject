package spring.mybatis.board;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MemberMybatisController {
	
	@Autowired
	MemberService service;
	
	//
	@GetMapping("boardlogin")
	String loginform(){
		return "board/loginform";
	}
	
	//
	@PostMapping("boardlogin")
	String loginprocess(String id, int pw, HttpSession session){
		MemberDTO dto = service.oneMember(id); //id에 맞는 회원 정보 가져오기
		if (dto != null) { //회원이 있다면
			if (dto.getPw() == pw) { //비밀번호가 맞다면
				session.setAttribute("sessionid",dto.getId()); //세션 설정
			}
		}
		return "board/start";
	}
	
	@RequestMapping("/boardlogout")
	String logout(HttpSession session){
		if (session.getAttribute("sessionid") != null) { //세션이 있다면(로그인 상태)
			session.removeAttribute("sessionid"); //세션 삭제
		}
		return "board/start";
	}
	
}
