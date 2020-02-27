package com.hwak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwak.mapper.AcaMapper;
import com.hwak.model.AcademyVO;
import com.hwak.model.Criteria;

@Service
public class AcaServiceImpl implements AcaService {
	
	@Autowired
	AcaMapper am;
	// 학원리스트
	@Override
	public List<AcademyVO> acaPaging(Criteria cri) throws Exception {
		return am.acaPaging(cri);
	}
	// 학원 전체 갯수
	@Override
	public int acaCount(Criteria cri) throws Exception {
		return am.acaCount(cri);
	}
	// 학원 상세내용
	@Override
	public AcademyVO acaDetail(int ano) throws Exception {
		return am.acaDetail(ano);
	}
}
