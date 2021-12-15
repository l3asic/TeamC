<%@ page import="com.hanul.study.SumMachine"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP02</title>
</head>
<body>
<%
SumMachine sm = new SumMachine();
int sum = sm.getSum(1, 1000);
pageContext.setAttribute("sum", sum);	//바인딩(연결) 객체 : Scope 설정
%>
두 수 사이의 누적합 : <%= sum %><br/>
두 수 사이의 누적합 : ${ sum }
</body>
</html>