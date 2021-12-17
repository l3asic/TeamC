package com.member.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.commons.action.Action;
import com.commons.action.ActionForward;
import com.member.study.MemberDAO;
import com.member.study.MemberDTO;

public class MemberDeleteAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		if(id == null) {	//로그인이 되어 있지 않은 상태
			out.println("<script>alert('로그인 하시기 바랍니다!');");
			out.println("location.href='memberLogin.me';</script>");
			//return null;
		}else if(!id.equals("admin")) {	//admin이 아닌 다른 id로 로그인 된 경우
			out.println("<script>alert('관리자가 아니므로 접근권한이 없습니다!');");
			out.println("location.href='boardList.bo';</script>");
			//return null;
		}else {		//admin(관리자)으로 로그인 한 상태
			String member_id = request.getParameter("member_id");
			
			MemberDAO dao = new MemberDAO();
			int succ = dao.deleteMember(member_id);
			
			if(succ > 0) {
				out.println("<script>alert('삭제성공!');");
				out.println("location.href='memberListAction.me';</script>");
				//return null;
			}else {
				out.println("<script>alert('삭제실패!');");
				out.println("location.href='memberListAction.me';</script>");
				//return null;
			}
		}
		return null;
	}	
}//class
