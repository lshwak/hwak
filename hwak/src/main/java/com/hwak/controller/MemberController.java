package com.hwak.controller;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hwak.model.LoginVO;
import com.hwak.model.MemberVO;
import com.hwak.service.MemberService;


@Controller
public class MemberController {
	
	@Autowired
	private MemberService mservice;
	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	/*로그인*/
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login () {
		logger.info("MemberController login : ");
	}
	/*로그인 처리*/
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public String loginPost (LoginVO log, Model model,HttpServletRequest request) throws Exception {
		MemberVO member = mservice.login(log);
		HttpSession session = request.getSession();
		// 위에 정의되어 있는 member 변수의 값을 model에 저장.
		model.addAttribute("member", member);
		logger.info("MemberController login : "+log +member);
		System.out.println("MemberController LOGIN session="+session.getAttribute("LOGIN"));
		// 세션에 값이 있으면
		if(session.getAttribute("LOGIN")!=null) {
			return "index";// index.jsp로 가라. 
		}else {// 아니면
			return "login";// login.jsp로 가라.
		}
	}
	/*로그아웃*/
	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		logger.info("MemberController logout ");
		ModelAndView mv = new ModelAndView("redirect:/index");
		return mv;
	}
	
	/*회원가입*/
	@RequestMapping(value="/member", method=RequestMethod.GET)
	public void memberGet() {
		logger.info("MemberController member : ");	
	}
	/*회원가입 처리*/
	@RequestMapping(value="/member", method=RequestMethod.POST)
	public String memberPost(MemberVO member) throws Exception {
		logger.info("MemberController memberPost : "+member);
		mservice.memberJoin(member);
		return "redirect:login";	// redirect하여 controller loginGet으로.
	}
	
	/*아이디 중복체크*/
	@ResponseBody
	@RequestMapping(value="/idChk", method=RequestMethod.POST)
	public int idChk(MemberVO member)throws Exception {
		int result = mservice.idChk(member);
		return result;
	}
	
	/*이메일 인증*/
	@ResponseBody
	@RequestMapping(value="mail", method=RequestMethod.POST)
	public String mailSending(String tomail) {
		int ran = (int)(Math.random()*10000)+10000;
		logger.info("ran : "+ran);
		logger.info("email"+tomail);
		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			
			messageHelper.setFrom("lshwak5170@gmail.com");
			messageHelper.setTo(tomail);
			messageHelper.setSubject("댄스모아 인증번호입니다.");
			messageHelper.setText("인증번호 [ "+ran+" ] 를 입력해주세요.");
			
			mailSender.send(message);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return ran+"";
	}
}




















