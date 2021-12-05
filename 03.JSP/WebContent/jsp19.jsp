<%@page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//jsp18.jsp에서 넘겨준 바인딩(연결) 객체를 받는다
request.setCharacterEncoding("utf-8");
MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP19</title>
</head>
<body>
○ 이름(JAVA) : <%= dto.getName() %><br/>
○ 전화번호(EL) : ${dto.tel }
</body>
</html>