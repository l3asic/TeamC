<%@ page import="com.hanul.dto.BoardDTO"%>
<%@ page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
request.setCharacterEncoding("utf-8");
List<BoardDTO> list = (List<BoardDTO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Search List</title>
</head>
<body>
<div align="center">
<h3>[검색결과]</h3>
<table border="1" style="width: 80%">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	
	<c:if test="${empty list}">
		<tr align="center">
			<td colspan="5">검색된 글이 없습니다!</td>
		</tr>
	</c:if>
	<c:if test="${!empty list}">
		<c:forEach var="i" begin="0" end="${fn:length(list) - 1}" step="1">
			<tr align="center">
				<td>${fn:length(list) - i}</td>
				<td><a href="boardDetail.do?b_num=${list[i].b_num}">${list[i].b_subject}</a></td>
				<td>${list[i].b_writer}</td>
				<td>${list[i].b_date}</td>
				<td>${list[i].b_readcount}</td>
			</tr>
		</c:forEach>
	</c:if>
	
	<tr align="center">
		<td colspan="5">
			<input type="button" value="목록보기" onclick="location.href='boardList.do'"/>
			<input type="button" value="글쓰기" onclick="location.href='boardWriteForm.do'"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>
