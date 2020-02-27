package com.hwak.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
}
