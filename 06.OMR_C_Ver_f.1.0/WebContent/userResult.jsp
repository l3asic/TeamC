<%@page import="java.util.List"%>
<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.CorrectAnsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDAO"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("searchData");

	UserDAO dao = new UserDAO();
	ArrayList<UserDTO> u_list = dao.selectUser(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과 보여주는 페이지</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<style type="text/css">
body {
	background-color: #F3E7E7;
	display: flex;
	justify-content: center;
}

.omr {
	position: fixed;
	letter-spacing: 5px;
}

.check {
	background-color: #009900;
}

.btns {
	display: flex;
	justify-content: space-around;
}

.main {
	margin-top: 10%;
}
</style>
<body>
	<div align="center">
		<h3>[전체회원 목록보기]</h3>
		<table border="1">
			<tr>
				<th>수험번호</th>
				<th>성명</th>
				<th>점수</th>
				<th>문항별 정답 여부</th>
				<th>정답 문항 수</th>
				<th>합격여부</th>
			</tr>

			<%
				for (int i = 0; i < u_list.size(); i++) {
			%>
			<tr>
				<td><%=u_list.get(i).getId()%></td>
				<td><%=u_list.get(i).getName()%></td>
				<td><%=u_list.get(i).getScore()%></td>
				<td><%=u_list.get(i).getOx()%></td>
				<td><%=u_list.get(i).getPass()%></td>
				<td><%=u_list.get(i).getCnt()%></td>

			</tr>
			<%
				}
			%>



			<tr align="center">
				<td colspan="11"><input type="button" value="adminMain.jsp"
					onclick="location.href='adminMain.jsp'" /> <input type="button"
					value="OmrMain.html" onclick="location.href='OmrMain.html'" /></td>
			</tr>
		</table>
	</div>
</body>
</html>