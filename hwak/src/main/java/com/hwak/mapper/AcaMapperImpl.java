package com.hwak.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	// 학원 등록 파일 업로드
	@Override
	public void addAttach(String aimage) throws Exception {
		sqlSession.insert(namespace+".addAttach",aimage);
	}
	// 상세페이지 파일
	@Override
	public List<String> getAttach(int ano) throws Exception {
		List<String> getAttachList =sqlSession.selectList(namespace+".getAttach",ano); 
		return getAttachList;
	}
	// 수정 시 파일삭제
	@Override
	public void delAttach(int ano) throws Exception {
		sqlSession.delete(namespace+".delAttach", ano);
		
	}
	// 파일 수정
	@Override
	public void modiAttach(int ano, String aimage) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("ano",ano);
		paramMap.put("aimage",aimage);
		System.out.println("ano : "+ano);
		System.out.println("filename : "+aimage);
		System.out.println("paramMap : "+paramMap);
		sqlSession.insert(namespace+".modiAttach",paramMap);
		
	}
}
