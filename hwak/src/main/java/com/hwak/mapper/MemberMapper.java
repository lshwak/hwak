package com.hwak.mapper;

import com.hwak.model.LoginVO;
import com.hwak.model.MemberVO;

public interface MemberMapper {
	// 회원가입
	public void memberJoin(MemberVO member) throws Exception;
	// 로그인
	public MemberVO login(LoginVO log) throws Exception;
	// 아이디 체크
	public int inChk(MemberVO member) throws Exception;
	
}
