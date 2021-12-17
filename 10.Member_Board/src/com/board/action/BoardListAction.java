package com.board.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commons.action.Action;
import com.commons.action.ActionForward;

public class BoardListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//클라이언트 요청 : 세션객체를 가져온다.
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		//비지니스 로직 : DB에 접속 후 전체글 목록 검색, 페이징 처리
		
		
		//프리젠테이션 로직 : board/boardList.jsp
		if(id == null) {	//로그인이 되어 있지 않은 상태
			//ActionForward forward = new ActionForward();
			//forward.setPath("memberLogin.me");
			//forward.setRedirect(true);
			//return forward;
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('정상적인 접근방식이 아닙니다!');");
			out.println("location.href='memberLogin.me';</script>");
			return null;
		}else {
			ActionForward forward = new ActionForward();
			forward.setPath("board/boardList.jsp");
			forward.setRedirect(false);
			return forward;
		}
	}
}
