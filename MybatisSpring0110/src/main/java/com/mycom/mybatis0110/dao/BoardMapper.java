package com.mycom.mybatis0110.dao;

import java.util.ArrayList;

import com.mycom.mybatis0110.vo.Board;

public interface BoardMapper {
	
	public int insertBoard(Board board);//게시글 등록
	public ArrayList<Board> boardList();//게시글 가져오기
	public Board boardDetail(String boardseq);//특정 게시글 가져오기
	public void increaseHit(String boardseq);//조회수 올리기
	public void deleteBoard(String boardseq);//게시글 삭제하기
	public void updateContent(Board board);//게시글 수정하기
}
