package com.hwak.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwak.model.Criteria;
import com.hwak.model.MagazineVO;
import com.hwak.model.PageVO;
import com.hwak.service.MagazineService;


@Controller
public class MagaController {
	@Autowired
	private MagazineService mgservice;
	private static final Logger logger = LoggerFactory.getLogger(MagaController.class);
	
	/*Magazine*/
	@RequestMapping(value="/magazine", method=RequestMethod.GET)
	public String magazineGet(Criteria cri, Model model) throws Exception {
		logger.info("MagaController magazine");
		int total = mgservice.magazineCount(cri);
		PageVO pv = new PageVO(cri, total);
		logger.info("keyword = "+cri.getKeyword());
		logger.info("pv = "+pv.getStartPage());
		logger.info("total = "+total);
		model.addAttribute("magazine", mgservice.magazinePaging(cri));
		logger.info("magazine="+mgservice.magazinePaging(cri));
		model.addAttribute("page", pv);
		return "maga/magazine";
	}
	
	/* 매거진 상세내용*/
	@RequestMapping(value="/magadetail", method=RequestMethod.GET)
	public String magadeatilGet(@RequestParam int mno, Model model) throws Exception {
		logger.info("magadetail get : "+mno);
		model.addAttribute("detail", mgservice.magaDetail(mno));
		logger.info("magadetail : "+mgservice.magaDetail(mno));
		
		List getAttachList = new ArrayList();
		getAttachList = mgservice.getAttach(mno);
		logger.info("getAttachList="+getAttachList);
		model.addAttribute("getAttachList",getAttachList);
		return "maga/magadetail";
	}
	/*매거진 등록*/
	@RequestMapping(value="/mregister", method=RequestMethod.GET)
	public String mregistGet() throws Exception {
		logger.info("mregist Get ...");
		return "maga/magawrite";
	}
	/*매거진 등록처리*/
	@RequestMapping(value="/mregister", method=RequestMethod.POST)
	public String mregistPost(MagazineVO maga) throws Exception {
		logger.info("mregist post ..."+maga);
		logger.info("mregist title"+maga.getMtitle());
		logger.info("파일 첨부..."+maga.getMimage());
		mgservice.mWrite(maga);
		return "redirect:magazine";
	}
	/*매거진 수정*/
	@RequestMapping(value="/magamodify", method=RequestMethod.GET)
	public String magamodifyGet(@RequestParam int mno,Model model) throws Exception {
		logger.info("magamodify Get : "+mno);
		model.addAttribute("magamodify", mgservice.magaDetail(mno));
		
		// 저장된 포스터 가져오기.
		List getAttachList = new ArrayList();
		getAttachList = mgservice.getAttach(mno);
		logger.info("getAttachList="+getAttachList);
		model.addAttribute("getAttachList",getAttachList);
		
		return "maga/magamodify";
	}
	/*매거진 수정처리*/
	@RequestMapping(value="/magamodify", method=RequestMethod.POST)
	public String magamodifyPost(@RequestParam int mno,MagazineVO maga)throws Exception {
		logger.info("modify post"+maga);
		mgservice.mModify(maga);
		logger.info("파일첨부 ... "+maga.getMimage());
		return "redirect:magadetail?mno="+maga.getMno();
	}
	/*매거진 삭제*/
	@RequestMapping(value="/magadelete", method=RequestMethod.GET)
	public String magadeleteGet(MagazineVO maga)throws Exception {
		logger.info("modify delete"+maga);
		mgservice.mDelete(maga);
		return "redirect:magazine";
	}
}
