package com.mycom.mybatis0110.dao;

import com.mycom.mybatis0110.vo.Member;

public interface MemberMapper {
	
	public int insertMember(Member member);//회원 가입
	public Member loginMember(Member member);//회원 로그인
	
}
