package com.mycom.mybatis0110;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycom.mybatis0110.dao.BoardDao;
import com.mycom.mybatis0110.vo.Board;
import com.mycom.mybatis0110.vo.Member;

@Controller
public class BoardController {
	@Autowired
	BoardDao dao;
	
	@RequestMapping(value="/goBoard", method=RequestMethod.GET)
	public String goBoard() {
		return "redirect:/boardList";
	}
	
	@RequestMapping(value="/writeBoard", method=RequestMethod.GET)
	public String writeBoard(HttpSession session, Model model) {
		if (session.getAttribute("loginId") == null) {//로그인 된 유저인지 session검사
			return "login";
		}
		return "boardWrite";
	}
	
	@RequestMapping(value="/insertBoard", method=RequestMethod.POST)
	public String insertBoard(Board board, Model model, HttpSession session) {
		if (session.getAttribute("loginId") == null) {//로그인 session이 만료되지 않았는지 session검사
			return "login";
		}
		
		//board.setHitcount(0);
		board.setId((String) session.getAttribute("loginId"));
		int result = dao.insertBoard(board);
		
		if (result == 0) {
			model.addAttribute("warning", " 게시글이 등록되지 않았습니다.");
			return "boardWrite";
		}
		
		return "redirect:/boardList";
	}
	
	@RequestMapping(value="/boardList", method=RequestMethod.GET)
	public String boardList(Model model) {//반복되는 게시글 전체출력 메소드
		ArrayList<Board> bList = dao.boardList();
		model.addAttribute("bList", bList);
		return "board";
	}
	
	//get방식일 때는 클라이언트가 어떤 값을 넘길지 모른다. 값을 String으로 받아 Integer.parseInt()시킨다.
	@RequestMapping(value="/boardDetail", method=RequestMethod.GET)
	public String boardDetail(String boardseq, Model model) {
		try {
			Integer.parseInt(boardseq);
		} catch (Exception e) {
			return "redirect:/boardList";
		}
		
		dao.increaseHit(boardseq);
		Board board = dao.boardDetail(boardseq);
		if (board == null || board.getId().length() < 1) {
			return "redirect:/boardList";
		}
		
		model.addAttribute("board", board);
		
		return "boardDetail";
	}
	
	@RequestMapping(value="/deleteBoard", method=RequestMethod.POST)
	public String deleteBoard(String boardseq, HttpSession session) {
		try {
			Integer.parseInt(boardseq);
		} catch (Exception e) {
			return "redirect:/boardList";
		}
		
		if (session.getAttribute("loginId") == null) {
			return "login";
		}
		Board board = dao.boardDetail(boardseq);

		if(board.getId().equals((String)session.getAttribute("loginId"))) {
			dao.deleteBoard(boardseq);
		}
		
		return "redirect:/boardList";
	}
	
	@RequestMapping(value="/updateBoard", method=RequestMethod.POST)
	public String updateBoard(String boardseq, Model model, HttpSession session) {
		if (session.getAttribute("loginId") == null) {
			return "login";
		}
		
		Board board = dao.boardDetail(boardseq);
		
		if (!board.getId().equals((String)session.getAttribute("loginId"))) {
			return "redirect:/boardList";
		}
		
		model.addAttribute("board", board);
		
		return "boardWrite";
	}
	
	@RequestMapping(value="/updateContent", method=RequestMethod.POST)
	public String updateBoard(Board board, HttpSession session) {
		if (session.getAttribute("loginId") == null) {
			return "login";
		}
		
		dao.updateContent(board);
		
		return "redirect:/boardList";
	}
}
