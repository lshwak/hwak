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
	public void main (Locale locale, Model model) throws Exception {
		model.addAttribute("eventSelect",ms.eventSelect());
		logger.info("MainController : ",locale);
		
		
		
		
	}
	
}
