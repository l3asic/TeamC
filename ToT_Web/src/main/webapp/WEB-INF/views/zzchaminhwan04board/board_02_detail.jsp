<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="list-group">
		<a onclick='go_detail(${boardVO.board_sn})'
			class="list-group-item list-group-item-action d-flex gap-3 py-3"
			aria-current="true"> <img src="${boardVO.member_filepath}"
			alt="twbs" width="32" height="32"
			class="rounded-circle flex-shrink-0">
			<div class="d-flex gap-2 w-100 justify-content-between">
				<!-- 				<div> -->
				<%-- 					<p class="mb-0">${empty boardVO.member_filepath ? '사진없음' : '외않됌'  }</p> --%>
				<!-- 				</div> -->
				<!-- 				<div> -->
				<%-- 					<h3 class="mb-0">글제목 : ${boardVO.board_title }</h3> --%>
				<%-- 					<p class="mb-0 opacity-75">작성 : ${boardVO.member_id}</p> --%>
				<!-- 				</div> -->
				<!-- 				<div> -->
				<%-- 					<p class="mb-0 opacity-75">게시판 : ${boardVO.board_class}</p> --%>
				<%-- 					<p class="mb-0">조회수 : ${boardVO.board_read_cnt }</p> --%>
				<!-- 				</div> -->
				<!-- 				<div> -->
				<%-- 					<p class="mb-0 opacity-75">게시판분류 : ${boardVO.board_class}</p> --%>
				<%-- 					<p class="mb-0">내용 : ${boardVO.board_content }</p> --%>
				<!-- 				</div> -->
				<%-- 				<small class="opacity-50 text-nowrap">${boardVO.board_date_create }</small> --%>
				<h3>게시물 내용 들어갈 자리</h3>
			</div>
		</a>
		<c:if test="${loginInfo.member_grade eq 'master' }">
			<a href="https://jsonlint.com/">정렬사이트</a>
			<p>${jsonVO}</p>
		</c:if>
	</div>
	<div class='btnSet'>
		<a class='btn-fill' onclick='$("form").submit()'>목록으로</a>
		<!-- 글쓴이만 수정/삭제 권한을 가짐 -->
		<c:if
			test="${boardVO.member_id eq loginInfo.member_id or loginInfo.member_grade eq 'master'}">
			<a class='btn-fill'
				onclick='$("form").attr("action", "modify.bo"); $("form").submit()'>수정</a>
			<a class='btn-fill'
				onclick='if ( confirm("정말 삭제?") ) {href="board_delete?board_sn=${boardVO.board_sn}" }'>삭제</a>
		</c:if>
	</div>


	<!-- Start header  -->
	<%@include file="../zzchaminhwan04board/board_02_detail_reply.jsp"%>
	<!-- End header  -->



</body>
</html>