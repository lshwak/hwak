package com.hwak.service;

import java.util.List;

import com.hwak.model.Criteria;
import com.hwak.model.MagazineVO;

public interface MagazineService {
	// 매거진 리스트
	public List<MagazineVO> magazinePaging(Criteria cri) throws Exception;
	// magazine테이블 전체 갯수
	public int magazineCount(Criteria cri) throws Exception;
	// 매거진 상세내용
	public MagazineVO magaDetail(int mno) throws Exception;
	// 매거진 등록
	public void mWrite (MagazineVO maga) throws Exception;
	// 매거진 수정
	public void mModify(MagazineVO maga) throws Exception;
	// 매거진 삭제
	public void mDelete(MagazineVO maga) throws Exception;
	//게시판 첨부파일 가져오기
	public List<String> getAttach(int mno) throws Exception;
}
