package com.hanul.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.dao.BoardDAO;
import com.hanul.dto.BoardDTO;

public class BoardDetailAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//클라이언트의 요청
		request.setCharacterEncoding("utf-8");	//인코딩설정
		int b_num = Integer.parseInt(request.getParameter("b_num"));	//매개변수를 받는다
		
		//비지니스 로직
		BoardDAO dao = new BoardDAO();	//DAO 객체 생성
		dao.boardReadCountUpdate(b_num);//조회수 증가
		BoardDTO dto = dao.boardDetail(b_num);	//메소드 호출하고 결과(BoardDTO)를 리턴받는다
		request.setAttribute("dto", dto);	//바인딩(연결) 객체 생성
		
		//프리젠테이션 로직
		ActionForward forward = new ActionForward();	//페이지전환을 담당하는 객체를 생성
		forward.setPath("board/boardDetail.jsp");	//출력할 페이지를 호출
		forward.setRedirect(false);	//페이지 전환방식 결정 : false → forward()
		return forward;	//최종결과를 리턴
	}
}
