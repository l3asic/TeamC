package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.commons.action.Action;
import com.commons.action.ActionForward;
import com.member.study.MemberDAO;
import com.member.study.MemberDTO;

//Servlet의 역할을 수행할 수 있도록, Action interface를 상속받고 execute() 메소드를 Override
public class MemberJoinAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//1. 클라이언트의 요청을 받는다 : 매개변수를 가져온다.
		request.setCharacterEncoding("utf-8");
		MemberDTO dto = new MemberDTO();
		dto.setMember_id(request.getParameter("member_id"));
		dto.setMember_pw(request.getParameter("member_pw"));
		dto.setMember_name(request.getParameter("member_name"));
		dto.setMember_age(Integer.parseInt(request.getParameter("member_age")));
		dto.setMember_gender(request.getParameter("member_gender"));
		dto.setMember_email(request.getParameter("member_email"));
		
		//2. 비지니스 로직 : DB와 연동하여 회원가입 처리
		MemberDAO dao = new MemberDAO();
		int succ = dao.joinMember(dto);
		
		//3. 프리젠테이션 로직 : 결과를 출력하고 페이지 전환
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(succ > 0) {
			out.println("<script>alert('회원가입 성공!');");
			out.println("location.href='memberLogin.me';</script>");
		}else {
			out.println("<script>alert('회원가입 실패!');");
			out.println("location.href='memberLogin.me';</script>");
		}
		
		return null;	//ActionForward 객체가 필요없다.
	}
}
