<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.CorrectAnsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

request.setParameter("id");

// ArrayList<OmrDTO> m_list = new ArrayList<>();  //사용자 정답 리스트
// ArrayList<CorrectAnsDTO> c_list = new ArrayList<>();  //정답 리스트
// ArrayList<UserDTO> ox_list = new ArrayList<>();  //OX 리스트
UserDAO dao = new UserDAO();
ArrayList<OmrDTO> m_list = dao.myAns("id");
ArrayList<CorrectAnsDTO> c_list = dao.CorrectAns();
ArrayList<UserDTO> ox_list = dao.OXOX("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과 보여주는 페이지</title>
</head>
<body>form -> mark.jsp
</body>
</html>