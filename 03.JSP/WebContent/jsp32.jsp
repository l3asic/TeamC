<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP32</title>
</head>
<body>
<!-- jsp32.jsp?num1=100&num2=50 -->
○ JAVA<br/>
<%
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));

int max = num1, min = num1;
if(num1 > num2){
	max = num1;	
	min = num2;
}
if(num1 < num2){
	max = num2;
	min = num1;
}
%>
첫 번째 정수 : <%= num1 %><br/>
두 번째 정수 : <%= num2 %><br/>
최대값 : <%= max %><br/>
최소값 : <%= min %><br/>
<br/>

○ JSTL &amp; EL<br/>
첫 번째 정수 : ${param.num1}<br/>
두 번째 정수 : ${param.num2}<br/>

<%--
	<c:if test="조건식">실행문</c:if>
--%>
최대값 : <c:if test="${param.num1 - param.num2 gt 0}">${param.num1}</c:if>
		 <c:if test="${param.num1 - param.num2 lt 0}">${param.num2}</c:if><br/>
최소값 : <c:if test="${param.num1 - param.num2 gt 0}">${param.num2}</c:if>
		 <c:if test="${param.num1 - param.num2 lt 0}">${param.num1}</c:if><br/>
</body>
</html>
