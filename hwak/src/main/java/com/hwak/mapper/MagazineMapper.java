package com.hwak.mapper;

import java.util.List;

import com.hwak.model.Criteria;
import com.hwak.model.MagazineVO;

public interface MagazineMapper {
	// 매거진 목록
	public List<MagazineVO> magazinePaging(Criteria cri) throws Exception;
	// magazines테이블 전체 갯수
	public int magazineCount(Criteria cri) throws Exception;
	// 매거진 상세내용
	public MagazineVO magaDetail(int mno) throws Exception;
}
