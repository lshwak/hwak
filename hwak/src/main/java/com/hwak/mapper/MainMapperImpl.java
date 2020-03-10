package com.hwak.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hwak.model.AcademyVO;
import com.hwak.model.BoardVO;
import com.hwak.model.Criteria;
import com.hwak.model.MagazineVO;

@Repository
public class MainMapperImpl implements MainMapper {
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.hwak.mapper.MainMapper";
	
	// 메인 event 출력
	@Override
	public BoardVO eventSelect() throws Exception {
		BoardVO board = sqlSession.selectOne(namespace+".eventSelect");
		return board;
	}
	// 메인 magazine 출력
	@Override
	public MagazineVO magaSelect() throws Exception {
		MagazineVO maga = sqlSession.selectOne(namespace+".magaSelect");
		return maga;
	}
	// 메인 academy 출력
	@Override
	public AcademyVO acaSelect() throws Exception {
		AcademyVO aca = sqlSession.selectOne(namespace+".acaSelect");
		return aca;
	}
	
}
