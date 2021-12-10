<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
UserDAO dao = new UserDAO();
ArrayList<UserDTO> u_list = dao.selectAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응시자 조회</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<style type="text/css">
table, th, td {
	border-collapse: collapse;
	border: 1px solid #333;
}

input {
	outline: none;
}

body {
	background-color: #F3E7E7;
}

.ans {
	background-color: #00ff00;
	text-color: #ffffff;
}

.main {
	margin-top: 10%;
}
</style>
</head>
<body>
	<div class="main" align="center">

		<h3>시험결과 목록</h3>
		<table border="1">


			<tr align="center">
				<td colspan="6">
					<form action="userResult.jsp" method="post">
						<select name="part">
							<option value="u_id">수험번호</option>
							<option value="u_name">성명</option>
						</select> <input type="text" name="searchData" required="required" /> <input
							class="btn btn-outline-primary btn-sm" type="submit" value="검색하기" />
						<input class="btn btn-outline-success btn-sm" type="button"
							value="관리자화면으로 돌아가기" onclick="location.href='adminMain.jsp'" />
					</form>
			<tr align="center">
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
				<td colspan="6">[ERROR] 응시자 목록을 불러올 수 없습니다.</td>
			</tr>
			<%
			} else {
			%>
			<%
			for (UserDTO dto : u_list) {
				ArrayList<UserDTO> u_list2 = dao.newUl(dto.getId());
			%>

			<tr>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=u_list2.get(0).getScore()%></td>
				<td align="center">
					<%
					ArrayList<OmrDTO> ox_list = dao.OXOX(dto.getId());
					for (OmrDTO oxdto : ox_list) {
					%> <%=oxdto.getAnswer1()%> <%=oxdto.getAnswer2()%> <%=oxdto.getAnswer3()%>
					<%=oxdto.getAnswer4()%> <%=oxdto.getAnswer5()%> <%=oxdto.getAnswer6()%>
					<%=oxdto.getAnswer7()%> <%=oxdto.getAnswer8()%> <%=oxdto.getAnswer9()%>
					<%=oxdto.getAnswer10()%>
				</td>
				<td><%=u_list2.get(0).getCnt()%></td>
				<td><%=u_list2.get(0).getPass()%></td>

			</tr>
			<%
			} //for
			} //for
			} //else
			%>


			<tr align="center">
				<td colspan="11"><input class="btn btn-outline-info btn-sm"
					type="button" value="관리자모드 종료" onclick="location.href='OmrMain.html'" />
					<input class="btn btn-outline-primary btn-sm" type="button"
					value="응시자격 목록 보기" onclick="location.href='admin_Testers.jsp'" />
				</td>
			</tr>
		</table>
	</div>
</body>
</html>