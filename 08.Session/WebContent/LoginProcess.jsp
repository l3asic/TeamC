<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");

//id 존재유무, pw 일치성 ▶ DAO를 통해 DB와 연동해서 이상이 없으면
session.setAttribute("id", id);	//session 바인딩(연결) 객체를 생성
session.setMaxInactiveInterval(60 * 10 * 1 * 1);	//session 유지시간(초단위 : 초 * 분 * 시 * 일)

response.sendRedirect("LoginMain.jsp");
%>