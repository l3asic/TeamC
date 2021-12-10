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
body, td, th {
text-align: "center";
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
		<h3>[검색결과]</h3>
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
				if (u_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="6">[ERROR] 검색 결과가 존재하지 않습니다.</td>
			</tr>
			<%
				} else {
			%>

			<%
				for (int i = 0; i < u_list.size(); i++) {
						ArrayList<UserDTO> u_list2 = dao.newUl(u_list.get(i).getId());
			%>
			<tr>
				<td><%=u_list.get(i).getId()%></td>
				<td><%=u_list.get(i).getName()%></td>


				<td><%=u_list.get(i).getScore()%></td>
				<td><%=u_list2.get(0).getScore()%></td>

				<td><%=u_list.get(i).getOx()%></td>
				<td align="center">
					<%
						ArrayList<OmrDTO> ox_list = dao.OXOX(u_list.get(i).getId());
								for (OmrDTO oxdto : ox_list) {
					%> <%=oxdto.getAnswer1()%> <%=oxdto.getAnswer2()%> <%=oxdto.getAnswer3()%>
					<%=oxdto.getAnswer4()%> <%=oxdto.getAnswer5()%> <%=oxdto.getAnswer6()%>
					<%=oxdto.getAnswer7()%> <%=oxdto.getAnswer8()%> <%=oxdto.getAnswer9()%>
					<%=oxdto.getAnswer10()%>
				</td>

				<td><%=u_list.get(i).getCnt()%></td>
				<td><%=u_list.get(i).getPass()%></td>
				<td><%=u_list2.get(0).getCnt()%></td>
				<td><%=u_list2.get(0).getPass()%></td>

			</tr>
			<%
				}
					}
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