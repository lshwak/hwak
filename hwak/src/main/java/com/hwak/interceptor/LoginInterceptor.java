package com.hwak.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.hwak.model.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static final String LOGIN = "login";
    // login 하기 전(preHandle 컨드롤러가 호출 되기 전에 실행)
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                  throws Exception {
    	System.out.println("Interceptor preHandle");
           HttpSession session = request.getSession();
           if(session.getAttribute(LOGIN)!=null) {         // 기존에 로그인이 되어 있다면
                  session.removeAttribute(LOGIN);                 // 로그아웃
                  System.out.println("로그인 되어있으면session : "+session);
           }
           return true;
    }
    // login 한 후 (postHandle 컨트롤러가 실행 된 후에 실행)
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                  ModelAndView mv) throws Exception {
    	System.out.println("Interceptor");
    	
    	// session에 member값을 저장.
           HttpSession session = request.getSession();
           MemberVO member = (MemberVO)mv.getModelMap().get("member");	// 객체를 명확하게 가져오기위해 Object타입이 아닌 MemberVO
           System.out.println("Interceptor postHandle!!!!! : "+member);	// 로그인할 회원정보 조회.
           
           if(member != null) { // 사용자가 회원가입을 했으면
        	   	  System.out.println("Interceptor post 성공");
                  //session.setAttribute("loginId",member.getId()); // 로그인 처리(session 회원정보 저장)
                  //session.setAttribute("loginName", member.getName());
        	   	  session.setAttribute(LOGIN, member);
                  System.out.println("Login session : "+session);
                  response.sendRedirect("/hwak/index");	// 로그인 성공 시 메인으로
           }else {	// 정보를 찾을 수 없으면 
        	   response.sendRedirect("/hwak/login");	
           }
    }
}
