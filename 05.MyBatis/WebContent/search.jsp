<%@page import="com.hanul.study.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.hanul.study.MemberDAO"%>
<%@page import="com.hanul.study.SearchDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("utf-8");
String part = request.getParameter("part");
String searchData = request.getParameter("searchData");

SearchDTO dto = new SearchDTO();
dto.setPart(part);
dto.setSearchData("%" + searchData + "%");

MemberDAO dao = new MemberDAO();
List<MemberDTO> list = dao.memberSearch(dto);
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search JSP</title>
<script type="text/javascript">
function fnDelete(id){
	//alert("ID : " + id);
	if(confirm("정말 삭제하시겠습니까?")){
		location.href = "delete.jsp?id=" + id;
	}
	return false;
}

function fnUpdate(id){
	//alert("ID : " + id);
	location.href = "detail.jsp?id=" + id;
}
</script>
</head>
<body>
<div align="center">
<h3>[검색결과]</h3>
<table border="1">
	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>나이</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<%--
	if(list.size() == 0){
		out.println("<tr align='center'><td colspan='8'>");
		out.println("검색결과가 없습니다!</td></tr>");
	}else{
		for(MemberDTO mdto : list){
			out.println("<tr align='center'>");
			out.println("<td>" + mdto.getName() + "</td>");
			out.println("<td>" + mdto.getId() + "</td>");
			out.println("<td>" + mdto.getPw() + "</td>");
			out.println("<td>" + mdto.getAge() + "</td>");
			out.println("<td>" + mdto.getAddr() + "</td>");
			out.println("<td>" + mdto.getTel() + "</td>");		
			out.println("</tr>");
		}
	}
	--%>
	
	<c:if test="${empty list}">
		<tr align="center">
			<td colspan="8">검색결과가 없습니다!</td>
		</tr>
	</c:if>
	<c:if test="${!empty list}">
		<c:forEach var="i" items="${list}">
			<tr align="center">
				<td>${i.name}</td>
				<td>${i.id}</td>
				<td>${i.pw}</td>
				<td>${i.age}</td>
				<td>${i.addr}</td>
				<td>${i.tel}</td>
				<td><input type="button" value="삭제" onclick="fnDelete('${i.id}')"/></td>
				<td><input type="button" value="수정" onclick="fnUpdate('${i.id}')"/></td>
			</tr>
		</c:forEach>
	</c:if>
	
	<tr align="center">
		<td colspan="8">
			<input type="button" value="목록보기" onclick="location.href='list.jsp'"/>
			<input type="button" value="회원가입" onclick="location.href='memberMain.html'"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>
