<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="dto" class="com.hanul.study.MemberDTO">
	<jsp:setProperty property="*" name="dto"/>
</jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP10</title>
</head>
<body>
<h3>[JAVA 코드를 이용한 출력]</h3>
이름(JAVA) : <%= dto.getName() %><br/>
아이디(JAVA) : <%= dto.getId() %><br/>
주소(JAVA) : <%= dto.getAddr() %><br/>

<h3>[Action Tag를 이용한 출력]</h3>
이름(Action) : <jsp:getProperty property="name" name="dto"/><br/>
아이디(Action) : <jsp:getProperty property="id" name="dto"/><br/>
주소(Action) : <jsp:getProperty property="addr" name="dto"/><br/>

<h3>[EL(Expression Language)을 이용한 출력]</h3>
이름(EL) : ${dto.name}<br/>
아이디(EL) : ${dto.id}<br/>
주소(EL) : ${dto.addr}
</body>
</html>
