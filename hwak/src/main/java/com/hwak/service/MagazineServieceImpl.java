package com.hwak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwak.mapper.MagazineMapper;
import com.hwak.model.Criteria;
import com.hwak.model.MagazineVO;

@Service
public class MagazineServieceImpl implements MagazineService {
	
	@Autowired
	MagazineMapper mgm;
	
	//매거진 목록
	@Override
	public List<MagazineVO> magazinePaging(Criteria cri) throws Exception {
		return mgm.magazinePaging(cri);
	}
	//magazines테이블 전체 갯수
	@Override
	public int magazineCount(Criteria cri) throws Exception {
		return mgm.magazineCount(cri);
	}
	// 매거진 상세내용
	@Override
	public MagazineVO magaDetail(int mno) throws Exception {
		return mgm.magaDetail(mno);
	}
	//매거진 등록
	@Transactional
	@Override
	public void mWrite(MagazineVO maga) throws Exception {
		mgm.mWrite(maga);
		System.out.println("여기는?"+maga.getMimage());
		String[] files = maga.getMimage();
		System.out.println(files);
		// 배열로 여러 포스터를 올릴때 (에러발생)
		//System.out.println("여기files="+files.length);
		if(files == null) {
			return;
		}
		 for(String filename : files){ 
			 System.out.println(filename+"향상된포문");
			 mgm.addAttach(filename);
		 }
		
	}
	// 매거진 수정
	@Override
	public void mModify(MagazineVO maga) throws Exception {
		mgm.mModify(maga);
		int mno = maga.getMno();
		mgm.delAttach(mno);
		String[] files = maga.getMimage();
		System.out.println("boardModify files:"+files);
		// 배열로 여러 포스터를 올릴때 (에러발생)
		//System.out.println("여기files="+files.length);
		if(files == null) {
			return;
		}
		 for(String filename : files){ 
			 System.out.println(filename+"향상된포문");
			 mgm.modiAttach(mno, filename);
		 }	
	
	}
	// 매거진 삭제
	@Override
	public void mDelete(MagazineVO maga) throws Exception {
		mgm.mDelete(maga);
	}
	// 파일 첨부
	@Override
	public List<String> getAttach(int mno) throws Exception {
		return mgm.getAttach(mno);
	}
	
}
