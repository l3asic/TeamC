package com.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.action.Action;
import com.commons.action.ActionForward;


@WebServlet("/MemberFrontController.me")
public class MemberFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//1. 클라이언트가 어떤 요청을 하였는지를 파악
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();			//uri-pattern 값 : /10.Member_Board/xxx.me
		String ctx = request.getContextPath();			//context root 값 : /10.Member_Board
		String command = uri.substring(ctx.length());	//실제 요청한 페이지 : /xxx.me
		
		//System.out.println("uri : " + uri);				
		//System.out.println("ctx : " + ctx);				
		//System.out.println("command : " + command);
		
		//2. 클라이언트의 요청(*.me : command)과 실제 처리할 Action Class(비지니스 로직) 연결 ▶ MemberxxxAction.java
		Action action = null;
		ActionForward forward = null;
		if(command.equals("/memberLogin.me")) {
			//로그인 화면으로 이동 : member/memberLoginForm.jsp
			forward = new ActionForward();
			forward.setPath("member/memberLoginForm.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/memberJoin.me")) {
			//회원가입 화면으로 이동 : memberJoinForm.jsp
			forward = new ActionForward();
			forward.setPath("member/memberJoinForm.jsp");
			forward.setRedirect(false);
		}
		
		
		
		//3. 프리젠테이션 로직(결과출력) : 페이지 전환 → forward(), sendRedirect() ▶ ActionFoward.java
		if(forward != null) {
			if(forward.isRedirect()) {	//true : sendRedirect()
				response.sendRedirect(forward.getPath());
			}else {						//false : forward()
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}
		}//if
	}
}//class
