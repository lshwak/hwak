package com.hwak.mapper;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwak.model.AcademyVO;
import com.hwak.model.Criteria;

@Repository
public class AcaMapperImpl implements AcaMapper {
	
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.hwak.mapper.AcaMapper";
	// 학원목록
	public List<AcademyVO> acaPaging(Criteria cri) throws Exception {
		List list = sqlSession.selectList(namespace+".acaPage",cri);
		return list;
	}
	// 학원 전체 갯수
	public int acaCount (Criteria cri) throws  Exception {
		int cnt = sqlSession.selectOne(namespace+".acaCount",cri);
		return cnt;
	}
	// 학원 상세내용
	@Override
	public AcademyVO acaDetail(int ano) throws Exception {
		AcademyVO acavo = sqlSession.selectOne(namespace+".acaDetail",ano);
		return acavo;
	}
	
}
