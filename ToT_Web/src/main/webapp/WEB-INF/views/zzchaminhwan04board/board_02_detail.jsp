<%@page import="com.google.gson.Gson"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<c:if test="${loginInfo.member_grade eq 'master' }">
			<a href="https://jsonlint.com/">정렬사이트</a>
			<p>${jsonVO}</p>
		</c:if>
		<div class="col">
			<div class="col-xl-7 col-lg-7 col-md-6">
				<div class="single-product-details">
					<h2>${boardVO.board_title}</h2>
					<h5>							<img class="d-block w-100" src="${boardVO.member_filepath}"
								alt="프로필사진 안나옴">  ${boardVO.member_id}</h5>
				</div>
				<p class="available-stock">
					<span>작성일 : </span> <span> ${boardVO.board_date_create}</span> <span>댓글수
						: </span> <span> ${boardVO.board_cnt_reply}</span> <span>조회수 : </span> <span>
						${boardVO.board_read_cnt}</span>
				</p>
			</div>
			<div class="col-xl-5 col-lg-5 col-md-6">
				<div id="carousel-example-1"
					class="single-product-slider carousel slide" data-ride="carousel">
					<div class="carousel-inner" role="listbox">
						<div class="carousel-item active">
							<img class="d-block w-100" src="${boardVO.member_filepath}"
								alt="member_filepath">
						</div>
					</div>

				</div>
			</div>
			<div class="col-xl-7 col-lg-7 col-md-6">
				<div class="single-product-details">
<!-- 					<div class="single-product-details"> -->
<!-- 						<h2>${boardVO.board_title}</h2> -->
<!-- 						<h5>${boardVO.member_id}</h5> -->
<!-- 					</div> -->
<!-- 					<p class="available-stock"> -->
<!-- 						<span>작성일 : </span> <span> ${boardVO.board_date_create}</span> <span>댓글수 -->
<!-- 							: </span> <span> ${boardVO.board_cnt_reply}</span> <span>조회수 : </span> <span> -->
<!-- 							${boardVO.board_read_cnt}</span> -->
<!-- 					</p> -->
					<p>${boardVO.board_content}</p>

					<div class="price-box-bar">
						<div class="cart-and-bay-btn">
							<a class="btn hvr-hover" data-fancybox-close="" href="#">Buy
								New</a> <a class="btn hvr-hover" data-fancybox-close="" href="#">Add
								to cart</a>
						</div>
					</div>

					<div class="add-to-btn">
						<div class="add-comp">
							<a class="btn hvr-hover" href="#"><i class="fas fa-heart"></i>
								Add to wishlist</a> <a class="btn hvr-hover" href="#"><i
								class="fas fa-sync-alt"></i> Add to Compare</a>
						</div>
						<div class="share-bar">
							<a class="btn hvr-hover" href="#"><i class="fab fa-facebook"
								aria-hidden="true"></i></a> <a class="btn hvr-hover" href="#"><i
								class="fab fa-google-plus" aria-hidden="true"></i></a> <a
								class="btn hvr-hover" href="#"><i class="fab fa-twitter"
								aria-hidden="true"></i></a> <a class="btn hvr-hover" href="#"><i
								class="fab fa-pinterest-p" aria-hidden="true"></i></a> <a
								class="btn hvr-hover" href="#"><i class="fab fa-whatsapp"
								aria-hidden="true"></i></a>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class='btnSet'>
			<a class='btn-fill' onclick='$("form").submit()'>목록으로</a>
			<!-- 글쓴이만 수정/삭제 권한을 가짐 -->
			<c:if
				test="${boardVO.member_id eq loginInfo.member_id or loginInfo.member_grade eq 'master'}">
				<a class='btn-fill'
					onclick='$("form").attr("action", "board_update"); $("form").submit()'>수정</a>
				<a class='btn-fill'
					onclick='if ( confirm("정말 삭제?") ) {href="board_delete?board_sn=${boardVO.board_sn}" }'>삭제</a>
			</c:if>
		</div>

<!-- 목록 요청에 필요한 데이터를 post 방식으로 전달하는 방법 -->
<form action="board_list" method="post">
	<input type="hidden" name="board_sn" value="${boardVO.board_sn }" />	<!-- 해당 글의 id  -->
<!-- 	<input type="hidden" name="search" value="${page.search }" /> 검색조건 -->
<!-- 	<input type="hidden" name="keyword" value="${page.keyword }" /> 검색어 -->
<!-- 	<input type="hidden" name="curPage" value="${page.curPage }" /> 현재 페이지 -->
<!-- 	<input type="hidden" name="pageList" value="${page.pageList }" /> 한 페이지당 보여질 목록 수 -->
<!-- 	<input type="hidden" name="viewType" value="${page.viewType }" /> 게시판 형태 -->
</form>
		<!-- Start 댓글  -->

		<%@include file="../zzchaminhwan04board/board_02_detail_reply.jsp"%>
		<!-- End 댓글  -->

	</div>

</body>
</html>