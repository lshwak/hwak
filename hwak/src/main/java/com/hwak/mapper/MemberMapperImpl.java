package com.hwak.mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hwak.model.LoginVO;
import com.hwak.model.MemberVO;

@Repository
public class MemberMapperImpl implements MemberMapper{
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "com.hwak.mapper.MemberMapper";
	// 회원가입
	@Override
	public void memberJoin(MemberVO member) throws Exception {
		System.out.println("member = "+member);
		sqlSession.insert(namespace+".memberJoin",member);
	}
	// 로그인
	@Override
	public MemberVO login(LoginVO log) throws Exception {
		MemberVO member = sqlSession.selectOne(namespace+".login",log);
		return member;
	}
	// 아이디 중복체크
	@Override
	public int inChk(MemberVO member) throws Exception {
		int result = sqlSession.selectOne(namespace+".idChk",member);
		return result;
	}
	
}
