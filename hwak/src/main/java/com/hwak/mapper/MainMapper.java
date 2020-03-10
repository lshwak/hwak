package com.hwak.mapper;

import java.util.List;

import com.hwak.model.BoardVO;
import com.hwak.model.Criteria;

public interface MainMapper {
	// 메일 출력
	public BoardVO eventSelect() throws Exception;
}
