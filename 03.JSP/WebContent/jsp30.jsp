<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP30</title>
</head>
<body>
<%-- JSTL core Tag를 활용하여 변수를 선언한 후, jsp31.jsp로 넘겨서 출력 : forward() --%>
<c:set var="code" value="abc1234" scope="request"/>
<c:set var="name" value="컴퓨터" scope="request"/>
<c:set var="price" value="500000" scope="request"/>
<jsp:forward page="jsp31.jsp"/>

<%--
String code = "abc1234";
String name = "컴퓨터";
int price = 500000;

request.setAttribute("code", code);
request.setAttribute("name", name);
request.setAttribute("price", pirce);

RequestDispatcher rd = request.getRequestDispatcher("jsp31.jsp");
rd.forward(request, response);
--%>
</body>
</html>