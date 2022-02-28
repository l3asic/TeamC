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
			mypage_board_list();
		}
		//목록조회
		function mypage_board_list() {
// 			alert(" 스크립트 실행 테스트ㅁㅁ ");
			$.ajax({
				url : 'mypage_list_write',
				data : {
					member_id : $('#member_id').val(),
					stack : $('#stacks').val()
				},
				// 				url : 'board_list_stack',
				// 				data : {
				// 					board_class : 'user',
				// 					list_cnt_many : $('#stacks').val()
				// 				},
				success : function(response) {
					$('#mypage_board_list').html(response);
				},
				error : function(req, text) {
					alert(text + ':' + req.status);
				}
			});
		}
	</script>
	<!-- ================================================================ -->
	<script type="text/javascript">
		$(function() { // $document).ready() 와 같은 의미
					
			mypage_board_list(); // 목록 조회 함수 호출
		});
	</script>
	<!-- ================================================================ -->

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
<%-- 				<img alt="프사" src="${vo.member_filepath }"> --%>
					<h2>${member_id}</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">작성한 게시물</a></li>
						<li class="breadcrumb-item active"><a href="#">좋아한 게시물</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->



	<!-- ========================= 페이지 주인 ========================= -->
	<input type="hidden" id='member_id' value="${member_id}"></input>
	<!-- =========================================================== -->

	<!-- ========================= 게시물 수 ========================= -->
	<input type="hidden" id='stacks' value="10"></input>
	<!-- =========================================================== -->

	<!-- ========================= 게시물 목록 ========================= -->
	<div id='mypage_board_list'>뫄뫄뫄</div>
	<!-- ============================================================ -->


	<!-- Start Wishlist  -->
	<!-- 	<div class="wishlist-box-main"> -->
	<!-- 		<div class="container"> -->
	<!-- 			<div class="row"> -->
	<!-- 				<div class="col-lg-12"> -->
	<!-- 					<div class="table-main table-responsive"> -->
	<!-- 						<table class="table"> -->
	<!-- 							<thead> -->
	<!-- 								<tr> -->
	<!-- 									<th>Images</th> -->
	<!-- 									<th>Product Name</th> -->
	<!-- 									<th>Unit Price</th> -->
	<!-- 									<th>Stock</th> -->
	<!-- 									<th>Add Item</th> -->
	<!-- 									<th>Remove</th> -->
	<!-- 								</tr> -->
	<!-- 							</thead> -->
	<!-- 							<tbody> -->
	<!-- 								<tr> -->
	<!-- 									<td class="thumbnail-img"><a href="#"> <img -->
	<!-- 											class="img-fluid" src="images/img-pro-01.jpg" alt="" /> -->
	<!-- 									</a></td> -->
	<!-- 									<td class="name-pr"><a href="#"> Lorem ipsum dolor sit -->
	<!-- 											amet </a></td> -->
	<!-- 									<td class="price-pr"> -->
	<!-- 										<p>$ 80.0</p> -->
	<!-- 									</td> -->
	<!-- 									<td class="quantity-box">In Stock</td> -->
	<!-- 									<td class="add-pr"><a class="btn hvr-hover" href="#">Add -->
	<!-- 											to Cart</a></td> -->
	<!-- 									<td class="remove-pr"><a href="#"> <i -->
	<!-- 											class="fas fa-times"></i> -->
	<!-- 									</a></td> -->
	<!-- 								</tr> -->

	<!-- 							</tbody> -->
	<!-- 						</table> -->
	<!-- 					</div> -->
	<!-- 				</div> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<!-- 	</div> -->
	<!-- End Wishlist -->

	<!-- Start Instagram Feed  -->
	<%@ include file="../zzchaminhwan/main_07_instagram_feed.jsp" %>
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













