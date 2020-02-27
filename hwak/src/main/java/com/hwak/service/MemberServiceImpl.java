package com.hwak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwak.mapper.MemberMapper;
import com.hwak.model.LoginVO;
import com.hwak.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{
	
	@Autowired
	private MemberMapper mm;
	// 회원가입
	
	@Override
	public void memberJoin(MemberVO member) throws Exception {
		mm.memberJoin(member);
		
	}
	// 로그인
	@Override
	public MemberVO login(LoginVO log) throws Exception {
		return mm.login(log);
	}
	// 아이디 체크
	@Override
	public int idChk(MemberVO member) throws Exception {
		int result = mm.inChk(member);
		return result;
	}
	
}
