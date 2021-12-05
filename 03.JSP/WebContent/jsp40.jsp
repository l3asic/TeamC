<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP40</title>
</head>
<body>
<c:set var="str" value="   How   Are   You?   "/>
○ 원래 문자열(공백제거) : ${str}<br/>
○ 공백포함한 문자열 : How&nbsp;&nbsp;&nbsp;Are&nbsp;&nbsp;&nbsp;You?<br/>
○ 대문자로 출력 : ${fn:toUpperCase(str)}<br/>
○ 소문자로 출력 : ${fn:toLowerCase(str)}<br/>
○ 문자열의 길이 : ${fn:length(str)}<br/>
○ 좌우공백을 제거 : ${fn:trim(str)}<br/>
○ 좌우공백을 제거한 후 문자열의 길이 : ${fn:length(fn:trim(str))}<br/>
○ 특정문자의 위치 : ${fn:indexOf(str, "A")}<br/>
○ 문자를 변경(치환) : ${fn:replace(str, "Are", "Were")}<br/>
<br/>
<%
String test = "How Are You?";
%>
○ JAVA : <%= test %><br/>
○ JAVA Method : <%= test.toUpperCase() %>
</body>
</html>