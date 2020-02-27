package com.hwak.mapper;

import java.util.List;

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
	
}
