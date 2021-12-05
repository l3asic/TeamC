<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ArrayList<String> list = new ArrayList<>();
list.add("바나나");
list.add("오렌지");
list.add("두리안");
list.add("포도");
list.add("사과");

//현재 페이지에서 사용할 바인딩(연결) 객체 생성 : EL 표현식에서 사용
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP36</title>
</head>
<body>
○ JAVA 단순 for문<br/>
<ul>
	<%
		for(int i = 0; i < list.size(); i++){
			out.println("<li>" + list.get(i) + "</li>");
		}
	%>
</ul>

○ JAVA 향상된 for문<br/>
<ul>
	<%
		for(String str : list){
			out.println("<li>" + str + "</li>");
		}		
	%>
</ul>

○ EL 문법(표현식)<br/>
<ul>
	<li>${list[0]}</li>
	<li>${list[1]}</li>
	<li>${list[2]}</li>
	<li>${list[3]}</li>
	<li>${list[4]}</li>
</ul>

○ JSTL core Tag<br/>
<ul>
	<c:forEach var="i" items="${list}">
		<li>${i}</li>
	</c:forEach>
</ul>
</body>
</html>
