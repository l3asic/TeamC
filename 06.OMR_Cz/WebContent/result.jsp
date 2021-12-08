<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.CorrectAnsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");

	UserDAO dao = new UserDAO();
	ArrayList<CorrectAnsDTO> c_list = dao.CorrectAns();
	ArrayList<OmrDTO> m_list = dao.myAns(id);
	OmrDTO dtozz = dao.OXOX("970528");
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
				<th>ㅁㅁ</th>
				<th>&nbsp;Q. 01&nbsp;</th>
				<th>&nbsp;Q. 02&nbsp;</th>
				<th>&nbsp;Q. 03&nbsp;</th>
				<th>&nbsp;Q. 04&nbsp;</th>
				<th>&nbsp;Q. 05&nbsp;</th>
				<th>&nbsp;Q. 06&nbsp;</th>
				<th>&nbsp;Q. 07&nbsp;</th>
				<th>&nbsp;Q. 08&nbsp;</th>
				<th>&nbsp;Q. 09&nbsp;</th>
				<th>&nbsp;Q. 10&nbsp;</th>
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
			<%
				if (c_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="9">등록된 회원목록이 없습니다!</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (CorrectAnsDTO dto : c_list) {
			%>
			<tr align="center">
				<td>정답</td>
				<td><%=dto.getCa1()%></td>
				<td><%=dto.getCa2()%></td>
				<td><%=dto.getCa3()%></td>
				<td><%=dto.getCa4()%></td>
				<td><%=dto.getCa5()%></td>
				<td><%=dto.getCa6()%></td>
				<td><%=dto.getCa7()%></td>
				<td><%=dto.getCa8()%></td>
				<td><%=dto.getCa9()%></td>
				<td><%=dto.getCa10()%></td>

			</tr>
			<%
				} //for
			%>
			<%
				} //if
			%>
			<%
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
				// 				if (ox_list.size() == 0) {
				if (false) {
			%>
			<tr align="center">
				<td colspan="11">등록된 회원목록이 없습니다!</td>
			</tr>
			<%
				} else {
			%>
			<tr align="center">
				<%-- 				<% --%>
				<!-- 				// for (OmrDTO dto : ) { -->
				<%-- 				%> --%>

				<td>맞으면O 틀리면X</td>
				<td><%=dtozz.getAnswer1()%></td>
				<td><%=dtozz.getAnswer2()%></td>
				<td><%=dtozz.getAnswer3()%></td>
				<td><%=dtozz.getAnswer4()%></td>
				<td><%=dtozz.getAnswer5()%></td>
				<td><%=dtozz.getAnswer6()%></td>
				<td><%=dtozz.getAnswer7()%></td>
				<td><%=dtozz.getAnswer8()%></td>
				<td><%=dtozz.getAnswer9()%></td>
				<td><%=dtozz.getAnswer10()%></td>


				<!-- 	${ox_list.ox}			<td>12</td> -->
				<!-- 				<td>12</td> -->
				<!-- 				<td>12</td> -->
				<!-- 				<td>12</td> -->
				<!-- 				<td>12</td> -->
				<!-- 				<td>12</td> -->
				<!-- 				<td>12</td> -->
				<!-- 				<td>12</td> -->
				<!-- 				<td>12</td> -->
				<!-- 				<td>12</td> -->
				<!-- 				<td>12</td> -->
				<%-- 				<td><%=dto.ox_list()%></td> --%>
				<%-- 				<td><%=dto.getOx1()%></td> --%>
				<%-- 				<td><%=dto.getOx2()%></td> --%>
				<%-- 				<td><%=dto.getOx3()%></td> --%>
				<%-- 				<td><%=dto.getOx4()%></td> --%>
				<%-- 				<td><%=dto.getOx5()%></td> --%>
				<%-- 				<td><%=dto.getOx6()%></td> --%>
				<%-- 				<td><%=dto.getOx7()%></td> --%>
				<%-- 				<td><%=dto.getOx8()%></td> --%>
				<%-- 				<td><%=dto.getOx9()%></td> --%>
				<%-- 				<td><%=dto.getOx10()%></td> --%>

			</tr>
			<%
				} //for
			%>
			<%
				// 				} //if
			%>

			<tr align="center">
				<td colspan="11"><input type="button" value="처음으로"
					onclick="location.href='OmrMain.html'" /></td>
			</tr>
		</table>
	</div>
</body>
</html>