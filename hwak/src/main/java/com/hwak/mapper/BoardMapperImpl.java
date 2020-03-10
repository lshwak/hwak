package com.hwak.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwak.model.BoardVO;
import com.hwak.model.Criteria;

@Repository
public class BoardMapperImpl implements BoardMapper {
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.hwak.mapper.BoardMapper";
	
	
	// 행사등록
	@Override
	public void boardWrite(BoardVO board) throws Exception {
		System.out.println("boardWrite : "+board);
		sqlSession.insert(namespace+".boardWrite",board);
	}
	// 이벤트 목록
	@Override
	public List<BoardVO> boardEventPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".boardEventPage",cri);
		return list;
	}
	// boards 테이블 전체 갯수
	public int boardCount(Criteria cri) throws Exception {
		int cnt = sqlSession.selectOne(namespace+".boardCount",cri);
		return cnt;
	}
	// 행사 상세내용
	@Override
	public BoardVO boardDetail(int eno) throws Exception {
		BoardVO boardvo = sqlSession.selectOne(namespace+".boardDetail",eno);
		return boardvo;
	}
	// 행사 수정
	@Override
	public void boardModify(BoardVO board) throws Exception {
		sqlSession.update(namespace+".boardModify",board);
	}
	// 행사 삭제
	@Override
	public void boardDelete(BoardVO board) throws Exception {
		sqlSession.update(namespace+".boardDelete",board);
	}
	// 파일첨부
	@Override
	public void addAttach(String filename) throws Exception {
		sqlSession.insert(namespace+".addAttach",filename);
	}
	// 상세페이지 파일
	@Override
	public List<String> getAttach(int eno) throws Exception {
		List<String> getAttachList =sqlSession.selectList(namespace+".getAttach",eno); 
		return getAttachList;
	}
	// 수정 시 파일삭제
	@Override
	public void delAttach(int eno) throws Exception {
		sqlSession.delete(namespace+".delAttach", eno);
		
	}
	// 파일 수정
	@Override
	public void modiAttach(int eno, String filename) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("eno",eno);
		paramMap.put("filename",filename);
		System.out.println("eno : "+eno);
		System.out.println("filename : "+filename);
		System.out.println("paramMap : "+paramMap);
		sqlSession.insert(namespace+".modiAttach",paramMap);
		
	}
	// 조회수 증가
	@Override
	public void boardCnt(int eno) throws Exception {
		sqlSession.update(namespace+".boardCnt",eno);
	}
	
	
}
