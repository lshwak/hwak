package com.hwak.mapper;

import java.util.List;

import com.hwak.model.BoardVO;
import com.hwak.model.Criteria;

public interface BoardMapper {
	// 행사등록
	public void boardWrite(BoardVO board) throws Exception;
	// 이벤트 목록
	public List<BoardVO> boardEventPaging(Criteria cri) throws Exception;
	// boards테이블 전체 갯수
	public int boardCount(Criteria cri) throws Exception;
	// 행사 상세내용
	public BoardVO boardDetail(int eno) throws Exception;
	// 행사 수정
	public void boardModify(BoardVO board) throws Exception;
	// 행사 삭제
	public void boardDelete(BoardVO board) throws Exception;
	// 게시판 글 쓰기 할 때 파일 업로드
	public void addAttach(String filename) throws Exception;
	//게시판 첨부파일 가져오기
	public List<String> getAttach(int eno) throws Exception;
	// 파일 수정시 삭제
	public void delAttach(int eno) throws Exception;
	// 파일 수정
	public void modiAttach(int eno, String filename) throws Exception;
	
}
