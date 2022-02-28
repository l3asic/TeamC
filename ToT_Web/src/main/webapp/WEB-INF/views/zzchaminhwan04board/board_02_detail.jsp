<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="board_list" method="post" name="updateForm">
		<input type="hidden" name="board_sn" value='${boardVO.board_sn}' />
		<input type="hidden" name="board_title" value='${boardVO.board_title}' />
		<input type="hidden" name="board_content" value='${boardVO.board_content}' />
		<!-- 	<input type="hidden" name="search" value="${page.search }" /> 검색조건 -->
		<!-- 	<input type="hidden" name="keyword" value="${page.keyword }" /> 검색어 -->
		<!-- 	<input type="hidden" name="curPage" value="${page.curPage }" /> 현재 페이지 -->
		<!-- 	<input type="hidden" name="pageList" value="${page.pageList }" /> 한 페이지당 보여질 목록 수 -->
		<!-- 	<input type="hidden" name="viewType" value="${page.viewType }" /> 게시판 형태 -->
	</form>
	<div class="container">
		<c:if test="${loginInfo.member_grade eq 'master' }">
			<a href="https://jsonlint.com/">정렬사이트</a>
			<p>${jsonVO}</p>
		</c:if>

		<div class="wishlist-box-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-12">
						<div class="table-main table-responsive">
							<table class="table">
								<thead>
									<tr>

										<th class="thumbnail-img"><img class="img-fluid"
											src="${boardVO.member_filepath}" alt="프사" /></th>

										<th class="   name-pr">
											<div>
												<a class=" list-group-item-action"
													onclick='go_detail(${boardVO.board_sn})'>${boardVO.board_title }
												</a>
											</div>
										</th>
										<th class="price-pr"><a class="btn hvr-hover"
											id='member_id' name='member_id'
											onclick=" go_mypage( '${boardVO.member_id}' ) ">${boardVO.member_id}</a>
											<p>${boardVO.member_grade}</p></th>
										<th class="quantity-box">${vo.board_class}</th>
										<th class="add-pr">
											<p>조회수 : ${boardVO.board_read_cnt}</p>
											<p>댓글수 : ${boardVO.board_cnt_reply}</p>
										</th>
										<th class="remove-pr">${boardVO.board_date_create }</th>

									</tr>
									<c:if
										test="${boardVO.member_id eq loginInfo.member_id or loginInfo.member_grade eq 'master'}">
										<tbody>
											<tr>
												<td>
													<div class="price-box-bar" style="margin-bottom: 0px;">
														<div class="cart-and-bay-btn">
															<a class="btn hvr-hover" data-fancybox-close=""
																id='btn_board_update-save' onclick='goUpdate();'>수정</a>
															<a class="btn hvr-hover" data-fancybox-close=""
																id='btn_board_delete-cancel'
																onclick='if ( confirm("게시물을 삭제합니다.") ) {href="board_delete?board_sn=${boardVO.board_sn}" }'>삭제</a>
														</div>
													</div>
												</td>
											</tr>
										</tbody>
									</c:if>
								<tbody>
									<tr>
										<td>${fn:replace( fn:replace( boardVO.board_content, lf, '<br>') , crlf, '<br>' )}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="col">
			<div class="col-xl-7 col-lg-7 col-md-6">
				<div class="single-product-details">
					<div class="add-to-btn">
						<div class="add-comp">
							<a class="btn hvr-hover" href="#"><i class="fas fa-heart"></i>
								좋아요 </a> <a class="btn hvr-hover" href="#"><i
								class="fas fa-sync-alt"></i> 새로고침 </a>
						</div>
					</div>
				</div>
			</div>
		</div>


		<div class='btnSet'>
			<a class='hvr-hover' onclick='history.back(-1)'>목록으로</a>
			<!-- 글쓴이만 수정/삭제 권한을 가짐 -->

		</div>


		<!-- Start 댓글  -->
		<%@include file="../zzchaminhwan04board/board_02_detail_reply.jsp"%>
		<!-- End 댓글  -->

	</div>
	<!-- ========================= -->
	<script type="text/javascript">
	function goUpdate() {
		
		   $('form[name="updateForm"]').attr("action", "board_go_update"); 
		   $('form[name="updateForm"]').submit();
	}
	</script>
	<!-- ========================= -->


</body>
</html>