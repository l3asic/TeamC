<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String name = request.getParameter("name");
UserDAO dao = new UserDAO();

//dao.removeTester("id", "name");
int succ = dao.removeTester(id);

if (succ > 0) {
	out.println("<script>alert('응시자격 박탈 완료');");
	out.println("location.href='admin_Testers.jsp';</script>");
} else {
	out.println("<script>alert('응시자격 박탈 실패');");
	out.println("location.href='admin_Testers.jsp';</script>");
}
%>
