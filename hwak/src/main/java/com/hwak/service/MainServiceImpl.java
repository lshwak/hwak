package com.hwak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwak.mapper.BoardMapper;
import com.hwak.mapper.MainMapper;
import com.hwak.model.AcademyVO;
import com.hwak.model.BoardVO;
import com.hwak.model.Criteria;
import com.hwak.model.MagazineVO;

@Service
public class MainServiceImpl implements MainService{
	
	@Autowired
	MainMapper mm;
	// 메인 event 출력
	@Override
	public BoardVO eventSelect() throws Exception {
		return mm.eventSelect();
	}
	// 메일 magazine 출력
	@Override
	public MagazineVO magaSelect() throws Exception {
		return mm.magaSelect();
	}
	// 메인 academy 출력
	@Override
	public AcademyVO acaSelect() throws Exception {
		return mm.acaSelect();
	}
	
	
	
	
}	
