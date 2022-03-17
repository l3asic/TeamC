<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="org.springframework.ui.Model"%>
<%@page import="java.net.http.HttpResponse"%>
<%@page import="org.springframework.http.HttpRequest"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="android.chaminhwan.ReplyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Gson gson = new Gson();
PrintWriter writer = response.getWriter();
String andJson = (String) request.getAttribute("andJson");
System.out.println(andJson);
writer.print(andJson);

// List<ReplyVO> list = new ArrayList<ReplyVO>();
// list = (ReplyVO) request.getAttribute("andJson");
// writer.print(gson.toJson(list));
%>

<%-- <c:forEach var="list" items="${list}" varStatus="status">
<p>
${status.index} : <c:out value="${list.member_id}" />
</p>
</c:forEach> --%> 

</body>
</html>