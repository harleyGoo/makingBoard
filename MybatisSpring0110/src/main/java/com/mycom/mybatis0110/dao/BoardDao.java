package com.mycom.mybatis0110.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mybatis0110.vo.Board;


@Repository//@Autowired를 통해 주입받아야 하기 때문에 레퍼지토리에 등록해둔다.
public class BoardDao {
	@Autowired
	SqlSession session;
	
	public int insertBoard(Board board) {//게시물등록
		int result = 0;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			return 0;//e.printstack()을 적으면 관리용 log에 오류처리가 다 된 오류까지 나타난다.
		}
		
		return result;
	}
	
	public ArrayList<Board> boardList(){
		ArrayList<Board> result = null;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.boardList();
		} catch (Exception e) {
			return result;
		}
		return result;
	}
	
	//특정 게시글의 정보를 가져오는 메서드
	public Board boardDetail(String boardseq) {
		Board result = null;
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			result = mapper.boardDetail(boardseq);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
	
	//조회수 증가시키기
	public void increaseHit(String boardseq) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.increaseHit(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 삭제하기
	public void deleteBoard(String boardseq) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.deleteBoard(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//게시글 수정하기
	public void updateContent(Board board) {
		BoardMapper mapper = session.getMapper(BoardMapper.class);
		try {
			mapper.updateContent(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
