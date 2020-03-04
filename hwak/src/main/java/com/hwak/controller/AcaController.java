package com.hwak.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwak.model.AcademyVO;
import com.hwak.model.Criteria;
import com.hwak.model.PageVO;
import com.hwak.service.AcaService;

@Controller
public class AcaController {
	@Autowired
	private AcaService aservice;
	private static final Logger logger = LoggerFactory.getLogger(AcaController.class);
	
	/*Academy*/
	@RequestMapping(value="/academy", method=RequestMethod.GET)
	public String academyGet(Criteria cri, Model model) throws Exception {
		logger.info("AcaController academy");
		int total = aservice.acaCount(cri);
		PageVO pv = new PageVO(cri, total);
		logger.info("keyword = "+cri.getKeyword());
		logger.info("pv = "+pv.getStartPage());
		logger.info("total = "+total);
		model.addAttribute("academy", aservice.acaPaging(cri));
		logger.info("academy="+aservice.acaPaging(cri));
		model.addAttribute("page", pv);
		return "aca/academy";
	}
	
	/*학원 상세내용*/
	@RequestMapping(value="/acadetail", method=RequestMethod.GET)
	public String acadetailGet(@RequestParam int ano, Model model) throws Exception {
		logger.info("acadetail get : "+ano);
		model.addAttribute("detail", aservice.acaDetail(ano));
		logger.info("acadetail  :"+aservice.acaDetail(ano));
		return "aca/acadetail";
	}
	/*학원 등록*/
	@RequestMapping(value="/aregister", method=RequestMethod.GET)
	public String aregistGet() throws Exception {
		logger.info("acawrite Get ...");
		return "aca/acawrite";
	}
	/*학원 등록 처리*/
	@RequestMapping(value="/aregister", method=RequestMethod.POST)
	public String aregistPost(AcademyVO aca) throws Exception {
		logger.info("academy regist post : "+aca);
		aservice.acaWrite(aca);
		return "redirect:academy";
	}
	/*학원 수정*/
	@RequestMapping(value="/acamodify", method=RequestMethod.GET)
	public String acamodifyGet(@RequestParam int ano, Model model)throws Exception {
		logger.info("acamodify Get ...");
		model.addAttribute("acamodify",aservice.acaDetail(ano));
		return "aca/acamodify";
	}
	/*학원 수정 처리*/
	@RequestMapping(value="/acamodify", method=RequestMethod.POST)
	public String acamodify(AcademyVO aca) throws Exception{
		logger.info("acamodify post...");
		aservice.acaModify(aca);
		return "redirect:acadetail?ano="+aca.getAno();
	}
	/*학원 삭제*/
	@RequestMapping(value="/acadelete", method=RequestMethod.GET)
	public String acaDelete(AcademyVO aca) throws Exception {
		logger.info("학원 번호 : "+aca.getAno());
		aservice.acaDelelte(aca);
		return "redirect:academy";
	}
}
