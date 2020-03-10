package com.hwak.mapper;

import java.util.List;

import com.hwak.model.AcademyVO;
import com.hwak.model.BoardVO;
import com.hwak.model.Criteria;
import com.hwak.model.MagazineVO;

public interface MainMapper {
	// 메인 event 출력
	public BoardVO eventSelect() throws Exception;
	// 메인 magazine 출력
	public MagazineVO magaSelect() throws Exception;
	// 메인 academy 출력
	public AcademyVO acaSelect() throws Exception;
}
