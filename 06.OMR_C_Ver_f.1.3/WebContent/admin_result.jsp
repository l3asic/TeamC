<%@page
	import="com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array"%>
<%@page import="com.hanul.study.OmrDTO"%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	UserDAO dao = new UserDAO();

	ArrayList<UserDTO> u_list = dao.searchUser(request.getParameter("searchData"));

	// 	dao.OXOX(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

.main {
	margin-top: 10%;
}
</style>
<script type="text/javascript">
	function fnDelete(id) {
		//alert("ID : " + id);
		if (confirm("정말 삭제하시겠습니까?")) {
			location.href = "delete.jsp?id=" + id;
		}
		return false;
	}

	function fnUpdate(id) {
		//alert("ID : " + id);
		location.href = "detail.jsp?id=" + id;
	}
</script>
</head>
<body>
	<div class="main" align="center">
		<h3>응시자 정보</h3>
		<table border="1">
			<tr>
				<th>시험 응시여부</th>
				<th>수험번호</th>
				<th>성명</th>
				<th>점수</th>
				<th>O / X</th>
				<th>합격여부</th>
				<th>맞춘 문항 수</th>
			</tr>
			<%
				if (u_list.size() == 0) {
			%>
			<tr align="center">
				<td colspan="11">등록된 회원목록이 없습니다!</td>
			</tr>
			<%
				} else {
			%>
			<%
				for (int i = 0; i < u_list.size(); i++) {
			%>
			<tr>
				<%
					if (dao.checkTried(u_list.get(i).getId()) > 0) {
				%>
				<td>응시 완료</td>
				<%
					} else {
				%>
				<td>미응시</td>
				<%
					}
				%>
				<td><%=u_list.get(i).getId()%></td>
				<td><%=u_list.get(i).getName()%></td>

				<%
					ArrayList<UserDTO> u_list2 = dao.newUl(u_list.get(i).getId());
							// 				String[] oxlist = { dto.getAnswer1(), dto.getAnswer2(), dto.getAnswer3(), dto.getAnswer4(),
							//  						dto.getAnswer5(), dto.getAnswer6(), dto.getAnswer7(), dto.getAnswer8(),
							//  						dto.getAnswer9(), dto.getAnswer10() };
				%>


				<td><%=u_list2.get(0).getScore()%></td>


				<td>
					<%
						ArrayList<OmrDTO> ox_list = dao.OXOX(u_list.get(i).getId());
								for (OmrDTO dto : ox_list) {
					%> <%
 	
 %> <%=dto.getAnswer1()%> <%=dto.getAnswer2()%> <%=dto.getAnswer3()%> <%=dto.getAnswer4()%>
					<%=dto.getAnswer5()%> <%=dto.getAnswer6()%> <%=dto.getAnswer7()%> <%=dto.getAnswer8()%>
					<%=dto.getAnswer9()%> <%=dto.getAnswer10()%> <%
 	//  							ArrayList<UserDTO> u_list3 = dao.newUl(oxlist);

 				//  							u_list2.get(index);
 				//  							u_list3.get(index);
 %> <%
 	} //foreach
 %>

				</td>


				<td><%=u_list2.get(0).getPass()%></td>
				<!-- 합불 -->
				<td><%=u_list2.get(0).getCnt()%></td>
				<!-- 갯수 -->
				<td><input class="btn btn-outline-danger" type="button"
					value="삭제" onclick="fnDelete(<%=u_list.get(i).getId()%>)" /></td>
			</tr>
			<%
				} //for
			%>
			<%
				} //else
			%>
			<tr>
				<td colspan="10" align="center"><input
					class="btn btn-outline-success btn-sm" type="button" value="응시자 추가"
					onclick="location.href='admin_Testers_Add.jsp'" /> <input
					class="btn btn-outline-warning btn-sm" type="button" value="응시자 결과"
					onclick="location.href='admin_Select.jsp'" /> <input
					class="btn btn-outline-info btn-sm" type="button" value="처음으로"
					onclick="location.href='OmrMain.html'" /></td>
			</tr>
		</table>
	</div>
</body>
</html>