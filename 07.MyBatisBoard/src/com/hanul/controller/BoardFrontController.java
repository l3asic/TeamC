package com.hanul.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanul.action.Action;
import com.hanul.action.ActionForward;
import com.hanul.action.BoardDeleteAction;
import com.hanul.action.BoardDetailAction;
import com.hanul.action.BoardInsertAction;
import com.hanul.action.BoardListAction;
import com.hanul.action.BoardSearchAction;
import com.hanul.action.BoardUpdateAction;
import com.hanul.action.BoardUpdateFormAction;

@WebServlet("/BoardFrontController.do")
public class BoardFrontController extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		//1. 클라이언트가 어떤 요청을 하였는지를 파악
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();			//uri-pattern 값 : /mbb/xxx.do
		String ctx = request.getContextPath();			//context root 값 : /mbb
		String command = uri.substring(ctx.length());	//실제 요청한 페이지 : /xxx.do
		
		//System.out.println("uri : " + uri);				//출력값 : /mbb/boardList.do
		//System.out.println("ctx : " + ctx);				//출력값 : /mbb
		//System.out.println("command : " + command);		//출력값 : /boardList.do
		
		//2. 클라이언트의 요청(*.do : command)과 실제 처리할 Action Class(비지니스 로직) 연결 ▶ BoardxxxAction.java
		Action action = null;
		ActionForward forward = null;
		if(command.equals("/boardList.do")) {
			action = new BoardListAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardWriteForm.do")) {
			//글을 작성하는 페이지로 화면전환만 필요
			forward = new ActionForward();
			forward.setPath("board/boardWriteForm.jsp");
			forward.setRedirect(false);
		}else if(command.equals("/boardInsert.do")) {
			action = new BoardInsertAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardDetail.do")) {
			action = new BoardDetailAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardDelete.do")) {
			action = new BoardDeleteAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardUpdateForm.do")) {
			action = new BoardUpdateFormAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardUpdate.do")) {
			action = new BoardUpdateAction();
			forward = action.execute(request, response);
		}else if(command.equals("/boardSearch.do")) {
			action = new BoardSearchAction();
			forward = action.execute(request, response);
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
	}//service()
}//class
