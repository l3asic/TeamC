<%@page import="com.hanul.study.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//바인딩 객체를 받는다 : Class Type, Casting
MemberDTO dto = (MemberDTO) request.getAttribute("dto");
%>

<jsp:useBean id="actionDTO" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="actionDTO"/>
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP12</title>
</head>
<body>
<h3>[jsp11.jsp에서 넘겨준 바인딩(연결) 객체의 값을 출력]</h3>
<%-- getProperty Action Tag는 반드시 useBean Action Tag로 객체가 생성되야만 사용 가능 --%>
이름(JAVA) : <%= dto.getName() %><br/>
아이디(Action) : <jsp:getProperty property="id" name="actionDTO"/><br/>
주소(EL) : ${dto.addr}<br/>
전화번호(actionDTO JAVA) : <%= actionDTO.getTel() %><br/>
전화번호(actionDTO EL) : ${actionDTO.tel }
</body>
</html>
