package com.hwak.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwak.model.Criteria;
import com.hwak.model.MagazineVO;

@Repository
public class MagazineMapperImpl implements MagazineMapper {
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.hwak.mapper.MagazineMapper";
	
	// 매거진 목록
	@Override
	public List<MagazineVO> magazinePaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".magazinePage",cri);
		return list;
	}
	// magazines테이블 전체 갯수
	public int magazineCount(Criteria cri) throws Exception {
		int cnt = sqlSession.selectOne(namespace+".magazineCount",cri);
		return cnt;
	}
	// 매거진 상세내용
	@Override
	public MagazineVO magaDetail(int mno) throws Exception {
		MagazineVO magavo = sqlSession.selectOne(namespace+".magaDetail",mno);
		return magavo;
	}
	// 매거진 등록
	@Override
	public void mWrite(MagazineVO maga) throws Exception {
		sqlSession.insert(namespace+".mgWrite",maga);
	}
	// 매거진 수정
	@Override
	public void mModify(MagazineVO maga) throws Exception {
		sqlSession.update(namespace+".mgModify",maga);		
	}
	// 매거진 삭제
	@Override
	public void mDelete(MagazineVO maga) throws Exception {
		sqlSession.update(namespace+".mgDelete",maga);
	}
	// 매거진 등록 파일 업로드
	@Override
	public void addAttach(String mimage) throws Exception {
		sqlSession.insert(namespace+".addAttach",mimage);
	}
	// 상세페이지 파일
	@Override
	public List<String> getAttach(int mno) throws Exception {
		List<String> getAttachList =sqlSession.selectList(namespace+".getAttach",mno); 
		return getAttachList;
	}
	// 수정 시 파일삭제
	@Override
	public void delAttach(int mno) throws Exception {
		sqlSession.delete(namespace+".delAttach", mno);
		
	}
	// 파일 수정
	@Override
	public void modiAttach(int mno, String mimage) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("mno",mno);
		paramMap.put("mimage",mimage);
		System.out.println("mno : "+mno);
		System.out.println("filename : "+mimage);
		System.out.println("paramMap : "+paramMap);
		sqlSession.insert(namespace+".modiAttach",paramMap);
		
	}
}
