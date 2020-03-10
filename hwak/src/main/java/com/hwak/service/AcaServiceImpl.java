package com.hwak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hwak.mapper.AcaMapper;
import com.hwak.model.AcademyVO;
import com.hwak.model.Criteria;

@Service
public class AcaServiceImpl implements AcaService {
	
	@Autowired
	AcaMapper am;
	// 학원리스트
	@Override
	public List<AcademyVO> acaPaging(Criteria cri) throws Exception {
		return am.acaPaging(cri);
	}
	// 학원 전체 갯수
	@Override
	public int acaCount(Criteria cri) throws Exception {
		return am.acaCount(cri);
	}
	// 학원 상세내용
	@Override
	public AcademyVO acaDetail(int ano) throws Exception {
		return am.acaDetail(ano);
	}
	// 학원 등록
	@Transactional
	@Override
	public void acaWrite(AcademyVO aca) throws Exception {
		am.acaWrite(aca);
		System.out.println("여기는?"+aca.getAimage());
		String[] files = aca.getAimage();
		System.out.println(files);
		// 배열로 여러 포스터를 올릴때 (에러발생)
		//System.out.println("여기files="+files.length);
		if(files == null) {
			return;
		}
		 for(String filename : files){ 
			 System.out.println(filename+"향상된포문");
			 am.addAttach(filename);
		 }
	}
	// 학원 수정
	@Override
	public void acaModify(AcademyVO aca) throws Exception {
		am.acaModify(aca);
		
		int ano = aca.getAno();
		am.delAttach(ano);
		String[] files = aca.getAimage();
		System.out.println("boardModify files:"+files);
		// 배열로 여러 포스터를 올릴때 (에러발생)
		//System.out.println("여기files="+files.length);
		if(files == null) {
			return;
		}
		 for(String filename : files){ 
			 System.out.println(filename+"향상된포문");
			 am.modiAttach(ano, filename);
		 }	
	}
	// 학원 삭제
	@Override
	public void acaDelelte(AcademyVO aca) throws Exception {
		am.acaDelete(aca);
	}
	// 파일 첨부
	@Override
	public List<String> getAttach(int ano) throws Exception {
		return am.getAttach(ano);
	}
	
}
