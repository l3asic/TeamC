<%@ page import="com.hanul.study.MemberDTO"%>
<%@ page import="java.util.List"%>
<%@ page import="com.hanul.study.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
request.setCharacterEncoding("utf-8");
MemberDAO dao = new MemberDAO();
List<MemberDTO> list = dao.memberSearchAll();

//현재 페이지에서 사용할 바인딩(연결) 객체 : EL 표현식에서 사용
pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List JSP</title>
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
<h3>[전체회원 목록보기]</h3>
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
	//단순 for문을 이용한 출력
	for(int i = 0; i < list.size(); i++){
		out.println("<tr align='center'>");
		out.println("<td>" + list.get(i).getName() + "</td>");
		out.println("<td>" + list.get(i).getId() + "</td>");
		out.println("<td>" + list.get(i).getPw() + "</td>");
		out.println("<td>" + list.get(i).getAge() + "</td>");
		out.println("<td>" + list.get(i).getAddr() + "</td>");
		out.println("<td>" + list.get(i).getTel() + "</td>");
		out.println("</tr>");
	}
	--%>
	
	<%--
	//향상된 for문을 이용한 출력
	for(MemberDTO dto : list){
		out.println("<tr align='center'>");
		out.println("<td>" + dto.getName() + "</td>");
		out.println("<td>" + dto.getId() + "</td>");
		out.println("<td>" + dto.getPw() + "</td>");
		out.println("<td>" + dto.getAge() + "</td>");
		out.println("<td>" + dto.getAddr() + "</td>");
		out.println("<td>" + dto.getTel() + "</td>");		
		out.println("</tr>");
	}
	--%>
	
	<%-- JSTL core Tag와 EL표현식을 이용한 출력 : 라이브러리 등록, 지시자 작성 --%>
	<%-- 
	<c:forEach var="i" begin="0" end="${fn:length(list) - 1}" step="1">
		<tr align="center">
			<td>${list[i].name}</td>
			<td>${list[i].id}</td>
			<td>${list[i].pw}</td>
			<td>${list[i].age}</td>
			<td>${list[i].addr}</td>
			<td>${list[i].tel}</td>
		</tr>
	</c:forEach>
	--%>
	
	<c:if test="${empty list}">
		<tr align="center">
			<td colspan="8">등록된 회원목록이 없습니다!</td>
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
			<form action="search.jsp" method="post">
				<select name="part">
					<option value="name">이름</option>
					<option value="id">아이디</option>
					<option value="addr">주소</option>
					<option value="tel">전화번호</option>
				</select>
				<input type="text" name="searchData" required="required"/>
				<input type="submit" value="검색하기"/>
				<input type="button" value="회원가입" onclick="location.href='memberMain.html'"/>
			</form>
		</td>
	</tr>
</table>
</div>
</body>
</html>
