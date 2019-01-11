package com.mycom.mybatis0110.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mybatis0110.vo.Member;


@Repository
public class MemberDao {
	
	@Autowired
	SqlSession sqlSession;
	
	public int insertMember(Member member) {
		int result = 0;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {//입력값에 문제가 있을 시 서버가 멈추는 것을 방지하기 위해 트라이캐치를 건다
			result = mapper.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}
	
	public Member loginMember(Member member) {
		Member result = null;
		MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
		try {
			result = mapper.loginMember(member);
		} catch (Exception e) {
			return null;
		}
		return result;
	}
}
