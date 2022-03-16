<%@page import="com.google.gson.Gson"%> <%@ page language="java"
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib
prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${boardVO.board_title}</title>
</head>
<body>



	<form action="board_list" method="post" name="updateForm">
		<input type="hidden" name="board_sn" value='${boardVO.board_sn}' /> <input
			type="hidden" name="board_title" value='${boardVO.board_title}' /> <input
			type="hidden" name="board_content" value='${boardVO.board_content}' />

	</form>
	<div class="container">
<!-- 		<c:if test="${loginInfo.member_grade eq 'master' }">
			<a href="https://jsonlint.com/">정렬사이트</a>
			<p>${jsonVO}</p>
		</c:if> -->

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
											</c:if> <a class="btn hvr-hover user_name_tag"
											style="font-size: 15px;" id='member_id' name='member_id'
											onclick=" go_mypage( '${boardVO.member_id}' ) ">${boardVO.member_id}
												[${boardVO.member_grade}] <%-- <br> <span
												style="font-size: 15px;"> ${boardVO.member_grade}</span>
												--%>
										</a> <a
											style="color: #666666; vertical-align: middle; font-size: 25px; margin-left: 10px;">${boardVO.board_title
												} </a> <!-- <th style="color: #999999;">${boardVO.board_title }</th> -->
										<th style="text-align: right;">
											<p
												style="display: block; margin-top: 5%; color: #999999; font-weight: lighter;">${boardVO.board_class}&nbsp|
												&nbsp ${boardVO.board_date_create }</p> <!-- 	<br> -->
											<p
												style="font-size: 13px; font-weight: lighter; color: #999999; margin-top: 10px; display: block;">
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
											<div class="price-box-bar"
												style="margin-bottom: 0px; float: right;">
												<a onclick='goUpdate();' id='btn_board_update-save'
													style="font-size: 10px; cursor: pointer;">수정</a> <a
													onclick='if ( confirm("게시물을 삭제합니다.") ) {href="board_delete?board_sn=${boardVO.board_sn}" }'
													id='btn_board_delete-cancel'
													style="font-size: 10px; cursor: pointer;">삭제</a>
											</div>
										</td>
									</tr>
								</tbody>
							</c:if>
							<tbody>
								<tr>
									<c:if test="${! empty boardVO.picList}">
										<td style="width: 100%; display: flex; flex-wrap: wrap;">
											<!-- ================================ --> 
											<c:forEach items="${boardVO.picList }" var="picVO">
												<div style="width: 300px; margin: 0 auto;">
													<img alt="pic"
														src="${picVO.picture_filepath}"
														style="width: 300px; height: 300px; margin: 10px;">
												</div>
											</c:forEach> <!-- ================================ -->
										</td>
									</c:if>
								</tr>
								<tr>
									<td style="padding: 10px;"><br>${fn:replace(
										fn:replace( boardVO.board_content, lf, '<br>') , crlf, '<br>'
										)}</td>
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
		<div style="text-align: center;">
			<div class="btn" style="cursor: pointer;">
				<a onclick="like_regist();"> <c:choose>
						<c:when test="${likeCheck eq 1 }">
							<img src="images/like.png" alt=""
								style="margin-right: 5px; width: 50px; height: 50px;"
								id="like_img">
						</c:when>
						<c:otherwise>
							<img src="images/like_gray.png" alt=""
								style="margin-right: 5px; width: 50px; height: 50px;"
								id="like_img">
						</c:otherwise>
					</c:choose>
				</a> <br> <strong id="like_count"> ${likeCount }</strong>
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