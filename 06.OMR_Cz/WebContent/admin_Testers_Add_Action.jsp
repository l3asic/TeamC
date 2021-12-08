<%@page import="java.io.PrintWriter"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String name = request.getParameter("name");

	UserDTO dto = new UserDTO(id, name, 0, null, null);

	UserDAO dao = new UserDAO();

	boolean ck = dao.checkId(dto);

	if (ck == true) {
		out.println("<script>alert('이미 등록된 사람임');");
		out.println("location.href='admin_Testers.jsp'</script>");
	} else {
		if (dao.addTester(id, name) > 0) {
			out.println("<script>alert('방금 입력한사람 등록 성공');");
			out.println("location.href='admin_Testers.jsp'</script>");
		} else {
			out.println("<script>alert('방금 입력한사람 등록 실패 (dao.addTester 에러)');");
			out.println("location.href='admin_Testers.jsp'</script>");
		}
	}
%>
