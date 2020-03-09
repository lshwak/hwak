package com.hwak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwak.mapper.BoardMapper;
import com.hwak.model.BoardVO;
import com.hwak.model.Criteria;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper bm;
	
	
	// 행사 등록
	@Transactional
	@Override
	public void boardWrite(BoardVO board) throws Exception {
		System.out.println("ServiceImpl board ... "+board.getEaddress());
		bm.boardWrite(board);
		System.out.println("여기는?"+board.getFilename());
		String[] files = board.getFilename();
		System.out.println(files);
		// 배열로 여러 포스터를 올릴때 (에러발생)
		//System.out.println("여기files="+files.length);
		if(files == null) {
			return;
		}
		 for(String filename : files){ 
			 System.out.println(filename+"향상된포문");
			 bm.addAttach(filename);
		 }
		 
		
		
	}
	// 이벤트 목록
	@Override
	public List<BoardVO> boardEventPaging(Criteria cri) throws Exception {
		return bm.boardEventPaging(cri);
	}
	// boards테이블 전체 갯수
	@Override
	public int boardCount(Criteria cri) throws Exception {
		return bm.boardCount(cri);
	}
	// 행사 상세내용
	@Override
	public BoardVO boardDetail(int eno) throws Exception {
		return bm.boardDetail(eno);
	}
	// 행사 수정
	@Override
	@Transactional
	public void boardModify(BoardVO board) throws Exception {
		bm.boardModify(board);
		int eno = board.getEno();
		bm.delAttach(eno);
		String[] files = board.getFilename();
		System.out.println("boardModify files:"+files);
		// 배열로 여러 포스터를 올릴때 (에러발생)
		//System.out.println("여기files="+files.length);
		if(files == null) {
			return;
		}
		 for(String filename : files){ 
			 System.out.println(filename+"향상된포문");
			 bm.modiAttach(eno, filename);
		 }
		
	}
	//행사 삭제
	@Override
	public void boardDelete(BoardVO board) throws Exception {
		bm.boardDelete(board);
		
	}
	// 파일 첨부
	@Override
	public List<String> getAttach(int eno) throws Exception {
		return bm.getAttach(eno);
	}
	
}	
