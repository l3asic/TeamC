package com.member.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commons.action.Action;
import com.commons.action.ActionForward;

public class MemberLogout implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//session 객체를 제거
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		
		//프리젠테이션 로직
		ActionForward forward = new ActionForward();
		forward.setPath("memberLogin.me");
		forward.setRedirect(true);
		return forward;
	}	
}
