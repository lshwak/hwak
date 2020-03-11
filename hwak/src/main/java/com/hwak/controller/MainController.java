package com.hwak.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hwak.service.MainService;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	MainService ms;
	
	/*메인*/
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public void main (Model model) throws Exception {
		// 각 최근게시물 출력.
		model.addAttribute("eventSelect",ms.eventSelect());
		model.addAttribute("magaSelect",ms.magaSelect());
		model.addAttribute("acaSelect", ms.acaSelect());
		logger.info("MainController : ", model);
		
		
		
		
	}
	
}
