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
	// 학원 등록
	@Override
	public void acaWrite(AcademyVO aca) throws Exception {
		sqlSession.insert(namespace+".acaWrite",aca);
	}
	// 학원 수정
	@Override
	public void acaModify(AcademyVO aca) throws Exception {
		sqlSession.update(namespace+".acaModify",aca);
	}
	// 학원 삭제
	@Override
	public void acaDelete(AcademyVO aca) throws Exception {
		sqlSession.update(namespace+".acaDelete",aca);
	}
}
