<%@page import="java.util.List"%>
<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.CorrectAnsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDAO"%>
<<<<<<< HEAD
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%-- <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
>>>>>>> d8baf047f15f4885b4fd1c9d4e036ca9abdcf38f
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
</head>
<body>
	<div align="center">
		<h3>[전체회원 목록보기]</h3>
		<table border="1">
			<tr>
				<th>수험번호</th>
				<th>성명</th>
				<th>점수</th>
				<th>정답여부</th>
				<th>합격여부</th>
				<th>맞은갯수</th>
<<<<<<< HEAD
=======
				<th>맞은갯수ㅋㅋ</th>
>>>>>>> d8baf047f15f4885b4fd1c9d4e036ca9abdcf38f
			</tr>

			<%-- 단순 for문을 이용한 출력
	<%for(int i = 0; i < list.size(); i++){ %>
		<tr align="center">
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getId() %></td>
			<td><%= list.get(i).getPw() %></td>
			<td><%= list.get(i).getAge() %></td>
			<td><%= list.get(i).getAddr() %></td>
			<td><%= list.get(i).getTel() %></td>
		</tr>	
	<%}//for %>
	--%>

			<%-- 향상된 for문을 이용한 출력 --%>
			<%-- <%
				if (u_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="6">해당하는 수험생이 없습니다</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (UserDTO dto : u_list) {
			%>
			<tr align="center">
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getScore()%></td>
				<td><%=dto.getOx() %></td>
				<td><%=dto.getPass() %></td>
				<td><%=dto.getCnt()%></td>

			</tr>
			<%
				} //for
			%>
			<%
				} //if
			%> --%>
<<<<<<< HEAD


			<%-- 	*********************<tr>
=======
			
			
		<%-- 	*********************<tr>
>>>>>>> d8baf047f15f4885b4fd1c9d4e036ca9abdcf38f
				<td>${u_list.id}</td>
				<td>${u_list.name}</td>
				<td>${u_list.score}</td>
				<td>${u_list.ox}</td>
				<td>${u_list.pass}</td>
				<td>${u_list.cnt}</td>
			</tr> --%>

<<<<<<< HEAD
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
















			<%-- 		<%
=======
			<%for(int i = 0; i < u_list.size(); i++){ %>
			<tr>
				<td>ㅁㄴㅇㄹ</td>
				<td><%= u_list.get(i).getId() %></td>
				<td><%= u_list.get(i).getId() %></td>
				<td><%= u_list.get(i).getId() %></td>
				<td><%= u_list.get(i).getId() %></td>
				<td><%= u_list.get(i).getId() %></td>
				
			</tr>
			<%} %>
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	<%-- 		<%
>>>>>>> d8baf047f15f4885b4fd1c9d4e036ca9abdcf38f
				if (m_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="10">등록된 회원목록이 없습니다!</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (OmrDTO dto : m_list) {
			%>
			<tr align="center">
				<td><%=dto.getId()%></td>
				<td><%=dto.getAnswer1()%></td>
				<td><%=dto.getAnswer2()%></td>
				<td><%=dto.getAnswer3()%></td>
				<td><%=dto.getAnswer4()%></td>
				<td><%=dto.getAnswer5()%></td>
				<td><%=dto.getAnswer6()%></td>
				<td><%=dto.getAnswer7()%></td>
				<td><%=dto.getAnswer8()%></td>
				<td><%=dto.getAnswer9()%></td>
				<td><%=dto.getAnswer10()%></td>

			</tr>
			<%
				} //for
			%>
			<%
				} //if
			%>
			<%
				if (ox_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="11">등록된 회원목록이 없습니다!</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (UserDTO dto : ox_list) {
			%>
			<tr align="center">
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
				<td>1</td>
								<td><%=dto.ox_list()%></td>
								<td><%=dto.getOx1()%></td>
								<td><%=dto.getOx2()%></td>
								<td><%=dto.getOx3()%></td>
								<td><%=dto.getOx4()%></td>
								<td><%=dto.getOx5()%></td>
								<td><%=dto.getOx6()%></td>
								<td><%=dto.getOx7()%></td>
								<td><%=dto.getOx8()%></td>
								<td><%=dto.getOx9()%></td>
								<td><%=dto.getOx10()%></td>

			</tr>
			<%
				} //for
			%>
			<%
				} //if
			%> --%>

			<tr align="center">
<<<<<<< HEAD
				<td colspan="11"><input type="button" value="adminMain.jsp"
					onclick="location.href='adminMain.jsp'" /> <input type="button"
					value="OmrMain.html" onclick="location.href='OmrMain.html'" /></td>
=======
				<td colspan="11"><input type="button" value="처음으로"
					onclick="location.href='OmrMain.html'" /></td>
>>>>>>> d8baf047f15f4885b4fd1c9d4e036ca9abdcf38f
			</tr>
		</table>
	</div>
</body>
</html>