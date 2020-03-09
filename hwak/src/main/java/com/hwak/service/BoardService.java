package com.hwak.service;

import java.util.List;

import com.hwak.model.BoardVO;
import com.hwak.model.Criteria;

public interface BoardService {
	// 행사 등록
	public void boardWrite(BoardVO board) throws Exception;
	// 이벤트 리스트
	public List<BoardVO> boardEventPaging(Criteria cri) throws Exception;
	// boards테이블 전체 갯수
	public int boardCount(Criteria cri) throws Exception;
	// 이벤트 상세내용
	public BoardVO boardDetail(int eno) throws Exception;
	// 행사 글 수정
	public void boardModify(BoardVO board) throws Exception;
	// 행사 삭제
	public void boardDelete(BoardVO board) throws Exception;
	//게시판 첨부파일 가져오기
	public List<String> getAttach(int eno) throws Exception;
}
