package com.mycom.mybatis0110;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.mybatis0110.dao.MemberDao;
import com.mycom.mybatis0110.vo.Member;


@Controller
public class MemberController {
	@Autowired
	MemberDao dao;
	
	@RequestMapping(value="/signUp", method=RequestMethod.GET)
	public String signUp() {
		return "signup";
	}
	
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public String insertMember(Member member, Model model) {
		int result = dao.insertMember(member);
		
		if (result == 0) {//실패했다면 그대로 signup 페이지에 머무른다.
			model.addAttribute("warning", "중복된 ID입니다.");
			model.addAttribute("member", member);
			return "signup";
		}
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value="/loginMember", method=RequestMethod.POST)
	public String loginMember(Member member, Model model, HttpSession session) {
		Member result = dao.loginMember(member);
		
		if (result == null) {//로그인 실패
			model.addAttribute("warning", "존재하지 않는 ID입니다.");
			model.addAttribute("member", member);
			return "login";
		}
		session.setAttribute("loginId", member.getId());
		System.out.println(result.getId() + "님이 접속하셨습니다.");
		
		return "home";		
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		//session.invalidate();//세션날리기, 로그인 관련 정보를 넣은 경우
		//값을 저장했던 세션을 null 처리하기, 로그인 정보와는 무관한 전영역에서 사용하는 정보(운영데이터)를 세션에 넣어둔 경우
		session.setAttribute("loginId", null);
		return "home";
	}
}
