<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	//ArrayList<OmrDTO> list = dao.markQna(입력값);
	request.setCharacterEncoding("utf-8");

	OmrDTO dto = new OmrDTO();

	dto.setId(request.getParameter("id"));
	dto.setAnswer1(Integer.parseInt(request.getParameter("answer1")));
	dto.setAnswer2(Integer.parseInt(request.getParameter("answer2")));
	dto.setAnswer3(Integer.parseInt(request.getParameter("answer3")));
	dto.setAnswer4(Integer.parseInt(request.getParameter("answer4")));
	dto.setAnswer5(Integer.parseInt(request.getParameter("answer5")));
	dto.setAnswer6(Integer.parseInt(request.getParameter("answer6")));
	dto.setAnswer7(Integer.parseInt(request.getParameter("answer7")));
	dto.setAnswer8(Integer.parseInt(request.getParameter("answer8")));
	dto.setAnswer9(Integer.parseInt(request.getParameter("answer9")));
	dto.setAnswer10(Integer.parseInt(request.getParameter("answer10")));

	UserDAO dao = new UserDAO();
	int succ = dao.insertOmr(dto);
	if(succ > 0){
		out.println("<script>alert('답안제출 성공!');");
		out.println("location.href='OmrMain.html';</script>");
	}else{
		out.println("<script>alert('답안제출 실패!');");
		out.println("location.href='OmrMain.html';</script>");
	}
%>