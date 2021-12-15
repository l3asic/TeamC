<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String[] fruit = {"파인애플", "레몬", "사과", "딸기", "복숭아"};

//현재페이지에서 사용할 바인딩(연결) 객체 생성 : EL 표현식에서 사용
pageContext.setAttribute("fruit", fruit);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP35</title>
</head>
<body>
○ JAVA 반복문(단순 for문)<br/>
<ul>
	<%
		for(int i = 0; i < fruit.length; i++){
			out.println("<li>" + fruit[i] + "</li>");
		}
	%>
</ul>

○ JAVA 반복문(향상된 for문)<br/>
<ul>
	<%
		for(String str : fruit){
			out.println("<li>" + str + "</li>");
		}
	%>
</ul>

<%--
○ JSTL core Tag 반복문(배열) : <c:forEach>실행문</c:forEach>
	▶ <c:forEach var="반복변수명" items="${배열명}">실행문</c:forEach>
--%>
○ JSTL 반복문(배열)<br/>
<ul>
	<c:forEach var="i" items="${fruit}">
		<li>${i}</li>
	</c:forEach>
</ul>
</body>
</html>
