package com.hwak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hwak.mapper.MagazineMapper;
import com.hwak.model.Criteria;
import com.hwak.model.MagazineVO;

@Service
public class MagazineServieceImpl implements MagazineService {
	
	@Autowired
	MagazineMapper mgm;
	
	//매거진 목록
	@Override
	public List<MagazineVO> magazinePaging(Criteria cri) throws Exception {
		return mgm.magazinePaging(cri);
	}
	//magazines테이블 전체 갯수
	@Override
	public int magazineCount(Criteria cri) throws Exception {
		return mgm.magazineCount(cri);
	}
	// 매거진 상세내용
	@Override
	public MagazineVO magaDetail(int mno) throws Exception {
		return mgm.magaDetail(mno);
	}
	//매거진 등록
	@Override
	public void mWrite(MagazineVO maga) throws Exception {
		mgm.mWrite(maga);
		
	}
	// 매거진 수정
	@Override
	public void mModify(MagazineVO maga) throws Exception {
		mgm.mModify(maga);
		
	}
	// 매거진 삭제
	@Override
	public void mDelete(MagazineVO maga) throws Exception {
		mgm.mDelete(maga);
	}
	
}
