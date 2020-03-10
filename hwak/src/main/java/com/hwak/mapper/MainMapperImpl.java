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
public class MainMapperImpl implements MainMapper {
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.hwak.mapper.MainMapper";
	
	//메인출력
	@Override
	public BoardVO eventSelect() throws Exception {
		BoardVO board = sqlSession.selectOne(namespace+".eventSelect");
		return board;
	}
	
	
	
	
	
}
