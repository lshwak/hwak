package com.hwak.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/*메인*/
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public void main (Locale locale, Model model) {
		logger.info("MainController : ",locale);
		
	}
	
}
