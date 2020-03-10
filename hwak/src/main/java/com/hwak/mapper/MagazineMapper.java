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
	// 매거진 등록
	public void mWrite(MagazineVO maga) throws Exception;
	// 매거진 수정
	public void mModify(MagazineVO maga) throws Exception;
	// 매거진 삭제
	public void mDelete(MagazineVO maga) throws Exception;
	// 매거진 등록 파일 업로드
	public void addAttach(String mimage) throws Exception;
	//게시판 첨부파일 가져오기
	public List<String> getAttach(int mno) throws Exception;
	// 파일 수정시 삭제
	public void delAttach(int mno) throws Exception;
	// 파일 수정
	public void modiAttach(int mno, String mimage) throws Exception;
}
