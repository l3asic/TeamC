<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");	//인코딩 설정

//바인딩(연결) 객체를 받자 : getAttribute(); ▶ Class Type, Casting 필수
String pageContextName = (String) pageContext.getAttribute("pageContextName");
String requestName = (String) request.getAttribute("requestName");
String sessionName = (String) session.getAttribute("sessionName");
String applicationName = (String) application.getAttribute("applicationName");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ScopeUse JSP</title>
</head>
<body>
<ul>
	<li>pageContext : <%=pageContextName %></li>
	<li>request : <%=requestName %></li>
	<li>session : <%=sessionName %></li>
	<li>application : <%=applicationName %></li>
</ul>
</body>
</html>