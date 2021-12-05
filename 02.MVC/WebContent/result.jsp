<%@page import="com.hanul.study.CalcDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//Controller(Servlet02.java)에서 넘겨준 바인딩(연결) 객체를 받는다.
request.setCharacterEncoding("utf-8");	//인코딩 설정
CalcDTO dto = (CalcDTO) request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>누적합 결과</title>
</head>
<body>
첫 번째 정수 : <%= dto.getNum1() %><br/>
두 번째 정수 : <%= dto.getNum2() %><br/>
두 정수 사이의 누적합 : <%= dto.getSum() %>
</body>
</html>