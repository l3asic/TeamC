package com.hanul.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.dao.BoardDAO;
import com.hanul.dto.BoardDTO;

public class BoardUpdateAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//클라이언트의 요청
		request.setCharacterEncoding("utf-8");
		BoardDTO dto = new BoardDTO();
		dto.setB_num(Integer.parseInt(request.getParameter("b_num")));
		dto.setB_writer(request.getParameter("b_writer"));
		dto.setB_subject(request.getParameter("b_subject"));
		dto.setB_content(request.getParameter("b_content"));
		dto.setB_pwd(request.getParameter("b_pwd"));
		
		//비지니스 로직
		BoardDAO dao = new BoardDAO();
		dao.boardUpdate(dto);
		
		//프리젠테이션 로직
		ActionForward forward = new ActionForward();
		forward.setPath("boardDetail.do?b_num=" + dto.getB_num());
		forward.setRedirect(true);
		return forward;
	}
}
