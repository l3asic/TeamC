<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>Insert title here</title>

<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="../images/favicon.ico"
	type="image/x-icon">
<link rel="apple-touch-icon" href="../images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="../css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="../css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="../css/custom.css">


</head>
<body>

	<!-- ================================================================ -->
	<script type="text/javascript">
		function stacks_more() {
			$('#stacks').val(Number($('#stacks').val()) + 10);
			mypage_board_list(viewMode);
		}
		// 목록조회 합친거 mypage_board_list("mypage_board_list_write")
		function mypage_board_list(url) {
			$.ajax({
				url : "mypage_list_" + url,
				data : {
					member_id : $('#member_id').val(),
// 					board_class : 'user',
					stack : $('#stacks').val()
				},
				success : function(response) {
					$('#mypage_board_list').html(response);
				},
				error : function(req, text) {
					alert(text + ':' + req.status);
				}
			});
			if(url == "write"){
				$("#whatCase_list").text("작성글 목록");
			}else if (url =="likes"){
				$("#whatCase_list").text("좋아요 목록");
			}
		}

	<!-- ================================================================ -->
		var viewMode = "" ;
		$(function() { // $document).ready() 와 같은 의미
		var aaa = "${memberVO.member_id}";
			if(aaa.length < 1){
				alert('잘못된 접근입니다.');
				location.href=history.back();
			}else{
		
			$('input[name=now_selected_list]').attr('value', "write");
			viewMode = $('input[name=now_selected_list]').val() ;			
				mypage_board_list(viewMode);
			}		
// 				alert("마이페이지 입니다.");
		});
	<!-- ================================================================ -->
		function changeView(text){
			$('#stacks').val(Number(10));
			$('input[name=now_selected_list]').attr('value', text);
			 viewMode = $('input[name=now_selected_list]').val() ;
			mypage_board_list( viewMode ) ;
		}
	</script>
	<!-- =========================== 유효한 회원인지 체크 ============================= -->
	<script type="text/javascript">
// 	$(function() { // $document).ready() 와 같은 의미
// 		$.ajax({
// 			url : "id_check",
// 			data : {
// 				id : $('#member_id').val()
// 			},
// 			success : function(response) {
// 				if(response == true){
// 					alert('존재하지 않는 사용자입니다.');
// 				}else{
// 					alert('마이페이지 입니다.');
// 				}
// 			},
// 			error : function(req, text) {
		
// 				alert(text + ':' + req.status);
// 			}
// 		});
// 	});
	</script>
	<!-- ================================================================ -->

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>


						<!-- 						<c:if test="${matchingScore ne null}"> -->
						<!-- 						♥ ${matchingVO}  -->
						<!-- 						</c:if> -->
						<!-- 						<c:if test="${matchingScore eq null}"> -->
						<!-- 						성향분석 완료 회원끼리만 가능  -->
						<!-- 						</c:if> -->
						<!-- 						<c:if test="${loginInfo eq null}"> -->
						<!-- 						로그인하면 가능 -->
						<!-- 						</c:if> -->
						<img src="images/like.png" alt="하트"
							style="width: 64px; height: 64px" />
						<c:choose>
							<c:when test="${loginInfo eq null}">???</c:when>
							<c:when test="${loginInfo.member_id eq memberVO.member_id}"></c:when>
							<c:when test="${matchingScore eq null}">???</c:when>
							<c:when test="${matchingScore ne null}"> ${matchingScore}  </c:when>
							<c:otherwise>TripOrTrap</c:otherwise>
						</c:choose>




						<br> <br>
						<c:if test="${memberVO.member_filepath ne null}">
							<img class="rounded-circle border p-1 picture_member_profile_256"
								style="cursor: pointer;" src="${memberVO.member_filepath}"
								alt="프사" />
						</c:if>
						<c:if test="${memberVO.member_filepath eq null}">
							<img class="rounded-circle border p-1 picture_member_profile_256"
								src="images/tot_icon_profile_none.png" alt="프사" />
						</c:if>
						<br> <br> ${memberVO.member_id} <br>
						<c:if test="${memberVO.member_id eq loginInfo.member_id }">
							<a href="my_modify?member_id=${memberVO.member_id }"
								style="font-size: 12px; color: #ffffff;">내 정보 수정</a>
						</c:if>
					</h2>
					<ul class="breadcrumb" style="cursor: pointer;">
						<li class="breadcrumb-item active"><a
							onclick='changeView("timeline")'>타임라인</a></li>
						<li class="breadcrumb-item"><a onclick='changeView("write")'>작성한
								게시물</a></li>
						<li class="breadcrumb-item active"><a
							onclick='changeView("likes")'>좋아한 게시물</a></li>

					</ul>
					<ul>
						<!-- ========================= 페이지 모드 ========================= -->
						<li><input type="text" name='now_selected_list' value=''></input></li>
						<!-- =========================================================== -->

						<!-- ========================= 페이지 주인 ========================= -->
						<li><input type="text" id='member_id' value="${member_id}"></input></li>
						<!-- =========================================================== -->

						<!-- ========================= 현재 표시 게시물 수 ========================= -->
						<li><input type="text" id='stacks' value="10"></input></li>
						<!-- =========================================================== -->

						<!-- ========================= 총 게시물 수 ========================= -->
						<li><input type="text" id='max_stack' value="0"></input></li>
						<!-- =========================================================== -->
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->





	<!-- ========================= 게시물 목록 ========================= -->
	<div id='mypage_board_list'></div>
	<!-- ============================================================ -->


	<!-- Start Instagram Feed  -->
	<%@ include file="../zzchaminhwan/main_07_instagram_feed.jsp"%>
	<!-- End Instagram Feed  -->








	<!-- ALL JS FILES -->
	<script src="../js/jquery-3.2.1.min.js"></script>
	<script src="../js/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script src="../js/jquery.superslides.min.js"></script>
	<script src="../js/bootstrap-select.js"></script>
	<script src="../js/inewsticker.js"></script>
	<script src="../js/bootsnav.js"></script>
	<script src="../js/images-loded.min.js"></script>
	<script src="../js/isotope.min.js"></script>
	<script src="../js/owl.carousel.min.js"></script>
	<script src="../js/baguetteBox.min.js"></script>
	<script src="../js/form-validator.min.js"></script>
	<script src="../js/contact-form-script.js"></script>
	<script src="../js/custom.js"></script>
</body>
</html>













