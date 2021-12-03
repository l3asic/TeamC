<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.CorrectAnsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	UserDAO dao = new UserDAO();

	ArrayList<OmrDTO> m_list = new ArrayList<>(); //사용자 정답 리스트
	ArrayList<CorrectAnsDTO> c_list = new ArrayList<>(); //정답 리스트
	ArrayList<UserDTO> ox_list = new ArrayList<>(); //OX 리스트

	dao.myAns("id");
	dao.correctAns();
	dao.OXOX("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과 보여주는 페이지</title>
</head>
<body>

	<tr align="center">
		<%
			if (list.size() == 0) {
		%>
		<td colspan="7">도서정보없음</td>
		<%
			} else {
		%>
		<%
			for (BookDTO dto : list) {
		%>
	
	<tr align="center">
		<td><%=dto.getTitle()%></td>
		<td><%=dto.getName()%></td>
		<td><%=dto.getIsbn()%></td>
		<td><%=dto.getComp()%></td>
		<td><%=dto.getCost()%></td>
		<td><%=dto.getQty()%></td>
		<td><%=dto.getPrice()%></td>
		<td><input type="button" value="삭제"
			onclick="fnDelete('<%=dto.getIsbn()%>')" /></td>
	</tr>
	<%
		}
	%>
	<%
		}
	%>

</body>
</html>