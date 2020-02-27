package com.hwak.service;

import org.springframework.stereotype.Service;

import com.hwak.model.LoginVO;
import com.hwak.model.MemberVO;

@Service
public interface MemberService {
	// 회원가입
	public void memberJoin(MemberVO member) throws Exception;
	// 로그인
	public MemberVO login(LoginVO log) throws Exception;
	// 아이디 체크
	public int idChk(MemberVO member) throws Exception;
}
