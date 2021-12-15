package com.hanul.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.dao.BoardDAO;
import com.hanul.dto.BoardDTO;

//BoardListAction Class : Action Interface 상속
// ▶ Servlet의 역할 수행 : 클라이언트의 요청, 비지니스 로직, 프리젠테이션 로직
public class BoardListAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//① 클라이언트의 요청을 받는다 : 전달되는 매개변수가 없다.

		//② 비지니스 로직 : DAO 연동하여 게시판의 전체 목록을 가져오는 작업
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.boardSearchAll();
		request.setAttribute("list", list);	//바인딩(연결) 객체 생성
		
		//③ 프리젠테이션 로직 : 페이지 전환(*.jsp) ▶ ActionForward.java : ViewPage, 페이지 전환방식
		//View Page(path) : board/boardList.jsp
		//페이지 전환방식(isRedirect) : forward() → false
		ActionForward forward = new ActionForward();
		forward.setPath("board/boardList.jsp");
		forward.setRedirect(false);		
		return forward;
	}
}
