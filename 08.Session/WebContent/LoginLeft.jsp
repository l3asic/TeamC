<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%--
○ 로그인이 되어 있는 상태
	- 세션객체에 id 속성이 있다.
	- 해당값(id)을 가져와서 로그인 유지 상태를 보여준다.
○ 로그인이 되어 있지 않은 상태
	- 세션객체에 id 속성이 없다.
	- 로그인 할 수 있는 화면을 보여준다.
--%>
<%
String id = (String) session.getAttribute("id");	//세션객체에서 id 속성값을 가져온다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Left</title>
</head>
<body>
<%if(id != null){ //세션에 id값이 있다 : 로그인 상태를 유지하는 화면 %>
	<%=id %>님 방문을 환영합니다!<br/>
	<input type="button" value="로그아웃" onclick="location.href='Logout.jsp'"/>
<%}else{ //세션에 id값이 없다 : 로그인하는 화면을 보여준다. %>
<form action="LoginProcess.jsp" method="post">
<table border="1">
	<tr>
		<th>아이디</th>
		<td><input type="text" name="id" required="required"/></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="pw" required="required"/></td>
	</tr>
	<tr align="center">
		<td colspan="2">
			<input type="submit" value="로그인"/>
			<input type="button" value="ID/PW 찾기" onclick="fnFind()"/>
		</td>
	</tr>
</table>
</form>
<%}//if %>
</body>
</html>