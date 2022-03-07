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
		<input type="hidden" name="board_sn" value='${boardVO.board_sn}' /> <input
			type="hidden" name="board_title" value='${boardVO.board_title}' /> <input
			type="hidden" name="board_content" value='${boardVO.board_content}' />
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
						<div class="table-main table-responsive" style="overflow: hidden;">
							<table class="table">
								<thead style="margin-bottom: 10px;">
									<tr style="background: #BDEDFF;">
										<th class="thumbnail-img"><c:if
												test="${boardVO.member_filepath ne null}">
												<img
													class="rounded-circle border p-1 picture_member_profile"
													src="${boardVO.member_filepath}" alt="프사" />
											</c:if> <c:if test="${boardVO.member_filepath eq null}">
												<img
													class="rounded-circle border p-1 picture_member_profile"
													src="images/tot_icon_profile_none.png" alt="프사" />
											</c:if><br> <a class="btn hvr-hover" style="background: #BDEDFF; color:#999999; padding-top:0px !important; font-size: 15px;" id='member_id' name='member_id'
											onclick=" go_mypage( '${boardVO.member_id}' ) ">${boardVO.member_id}
												<%-- <br> <span style="font-size: 15px;"> ${boardVO.member_grade}</span> --%>
										</a> <%-- 										 <a>${boardVO.board_title } </a> --%> <th style="color: #999999;">${boardVO.board_title }</th>
										<th style="text-align: right;">
											<p style=" display:block; margin-top: 5%; color: #999999; font-weight: lighter;">${boardVO.board_class}&nbsp|
												&nbsp ${boardVO.board_date_create }</p>
											<!-- 	<br> -->
											<p style=" font-size: 13px; font-weight: lighter; color: #999900; margin-top: 10px; display: block; ">
												[조회 : ${boardVO.board_read_cnt} 댓글 :
												${boardVO.board_cnt_reply}]</p>
										</th>
										
									</tr>
								</thead>
								</table>
								<c:if
									test="${boardVO.member_id eq loginInfo.member_id or loginInfo.member_grade eq 'master'}">
									<tbody>
										<tr>
											<td>
												<div class="price-box-bar" style="margin-bottom: 0px;">
													<%-- <div class="cart-and-bay-btn">
														<a class="btn hvr-hover" data-fancybox-close=""
															id='btn_board_update-save' onclick='goUpdate();'>수정</a> <a
															class="btn hvr-hover" data-fancybox-close=""
															id='btn_board_delete-cancel'
															onclick='if ( confirm("게시물을 삭제합니다.") ) {href="board_delete?board_sn=${boardVO.board_sn}" }'>삭제</a>
													</div> --%>
													<a onclick='goUpdate();' id='btn_board_update-save' style="font-size: 10px; cursor: pointer;">수정</a>
													<a onclick='if ( confirm("게시물을 삭제합니다.") ) {href="board_delete?board_sn=${boardVO.board_sn}" }' id='btn_board_delete-cancel' style="font-size: 10px; cursor: pointer;">삭제</a>
												</div>
											</td>
										</tr>
									</tbody>
								</c:if>
								<tbody>
									<tr>
										<c:if test="${! empty boardVO.picList}">
											<td style="width: 100%; display: flex; flex-wrap: wrap;">
												<!-- ================================ --> <c:forEach
													items="${boardVO.picList }" var="picVO">
													<div style="width: 300px; margin: 0 auto;">
														<img alt="pic" src="data:image/png;base64,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"
															style="width: 300px; height: 300px; margin: 10px;">
													</div>
												</c:forEach> <!-- ================================ -->
											</td>
										</c:if>
									</tr>
									<tr>
										<td><br>${fn:replace( fn:replace( boardVO.board_content, lf,
											'<br>') , crlf, '<br>' )}
										</td>
									</tr>
								</tbody>
				<!-- 			</table> -->
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- 		<div class="col"> -->
		<!-- 			<div class="col-xl-7 col-lg-7 col-md-6"> -->
		<!-- 				<div class="single-product-details"> -->
		<!-- 					<div class="add-to-btn"> -->
		<div>
			<div class="btn" style="cursor: pointer;">
				<a onclick="like_regist();"> <c:choose>
						<c:when test="${likeCheck eq 1 }">
							<img src="images/like.png" alt="" style="margin-right: 5px"
								id="like_img">
						</c:when>
						<c:otherwise>
							<img src="images/like_gray.png" alt="" style="margin-right: 5px"
								id="like_img">
						</c:otherwise>
					</c:choose>
				</a> 좋아요<strong id="like_count">${likeCount }</strong>
			</div>
		</div>
		<!-- 					</div> -->
		<!-- 				</div> -->
		<!-- 			</div> -->
		<!-- 		</div> -->
		<div class='btnSet'>

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
	<script type="text/javascript">
function like_regist() {

		$.ajax ({
		/* 경로 형태로 url 지정 */
		url: 'set_like'				//★★
		, data : {like_fn : ${boardVO.function_like}, board_sn : ${boardVO.board_sn}}
		, dataType : 'json'
			/* 원 글의 id, 입력한 댓글을 데이터로 보냄 */
		, success : function( response ) {
			if ( response ) {	// true
				if(response.isLogin == true){
					if(response.isLike){
						document.getElementById("like_img").src = "images/like.png";
					}else{
						document.getElementById("like_img").src = "images/like_gray.png";
					}
					$('#like_count').text(response.count);
				}else{
					alert("로그인 후 사용 할 수 있습니다.")
				}
				
			} else	// false
				alert('좋아요 실패 등록 실패!');
		}, error : function (req, text) {
			alert (text + ':' + req.status);
		}
	});
}
</script>

</body>
</html>