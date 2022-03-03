<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<!-- Basic -->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>홈 메인화면</title>
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<!-- Site Icons -->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="css/custom.css">

<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<!-- Start Main Top -->
	<header class="main-header">
		<!-- Start Navigation -->
		<nav
			class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
			<div class="container" style="position: relative;">
				<!-- Start Header Navigation -->
				<div class="navbar-header">
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbar-menu" aria-controls="navbars-rs-food"
						aria-expanded="false" aria-label="Toggle navigation">
						<i class="fa fa-bars"></i>
					</button>
					<a class="navbar-brand" href="<c:url value='/' />"><img
						src="images/main_logo.png" class="logo" alt=""></a>
					<div class="navbar-float"
						style="position: absolute; top: 0; right: 0; padding-left: 20px; padding-bottom: 5px">
						<ol style="font-size: 13px">
							<!-- 로그인하지 않은 상태 -->
							<c:if test="${ empty loginInfo }">
								<li style="list-style-type: none; float: left;"><a
									href="login">로그인</a></li>
								<li style="list-style-type: none; float: left;">｜</li>
								<li style="list-style-type: none; float: left;"><a
									href="member">회원가입</a></li>
							</c:if>
							<!-- 로그인한 상태 -->
							<c:if test="${ !empty loginInfo }">
								<li style="list-style-type: none; float: left;"><a
									href="whosepage"><strong>${loginInfo.member_id}</strong></a></li>
								<li style="list-style-type: none; float: left;">｜</li>
								<li style="list-style-type: none; float: left;"><a
									href="logout">로그아웃</a></li>
							</c:if>
						</ol>
					</div>
				</div>
				<!-- End Header Navigation -->

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="nav navbar-nav ml-auto" data-in="fadeInDown"
						data-out="fadeOutUp">
						<li class="nav-item"><a class="nav-link"
							href="<c:url value='/' />">홈</a></li>
						<li class="dropdown active"><a href="#"
							class="nav-link dropdown-toggle arrow" data-toggle="dropdown">카테고리</a>
							<ul class="dropdown-menu">
								<li><a href="tour.ca">관광지</a></li>
								<li><a href="activity.ca">액티비티</a></li>
								<li><a href="festival.ca">지역축제</a></li>
							</ul></li>
						<li class="dropdown active"><a href="#"
							class="nav-link dropdown-toggle arrow" data-toggle="dropdown">파티</a>
							<ul class="dropdown-menu">
								<li><a href="shop.html">Sidebar Shop</a></li>
								<li><a href="shop-detail.html">Shop Detail</a></li>
								<li><a href="cart.html">Cart</a></li>
								<li><a href="checkout.html">Checkout</a></li>
								<li><a href="my-account.html">My Account</a></li>
								<li><a href="wishlist.html">Wishlist</a></li>
							</ul></li>
						<li class="nav-item"><a class="nav-link" href="gallery.html">Gallery</a></li>
						<li class="nav-item"><a class="nav-link"
							href="contact-us.html">Contact Us</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->

				<!-- End Atribute Navigation -->
			</div>
			<!-- Start Side Menu -->
			<!-- End Side Menu -->
		</nav>
		<!-- End Navigation -->
	</header>
	<!-- End Main Top -->
	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>카테고리</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->



	<!-- Start Shop Detail  -->
	<div class="shop-detail-box-main">
		<div class="container">
			<div class="row">
				<div class="col-xl-5 col-lg-5 col-md-6">
					<div id="carousel-example-1"
						class="single-product-slider carousel slide" data-ride="carousel">
						<div class="carousel-inner" role="listbox"
							style="width: 415px; height: 311px;">

							<c:choose>

								<c:when test="${ fn:length(picture) == 0}">
									<img src="images/no_image.png" alt="">
								</c:when>

								<c:when test="${ fn:length(picture) != 0 }">

									<c:forEach var="pic" items="${picture}" varStatus="i">

										<c:choose>
											<c:when test="${0 == i.index }">
												<div class="carousel-item active">
													<img class="d-block w-100" src="${pic.picture_filepath }"
														alt="NO IMAGE">
												</div>
											</c:when>
											<c:when test="${0 != i.index }">
												<div class="carousel-item">
													<img class="d-block w-100" src="${pic.picture_filepath }"
														alt="NO IMAGE">
												</div>
											</c:when>

										</c:choose>
									</c:forEach>
									<a class="carousel-control-prev" href="#carousel-example-1"
										role="button" data-slide="prev"> <i
										class="fa fa-angle-left" aria-hidden="true"></i> <span
										class="sr-only">Previous</span>
									</a>
									<a class="carousel-control-next" href="#carousel-example-1"
										role="button" data-slide="next"> <i
										class="fa fa-angle-right" aria-hidden="true"></i> <span
										class="sr-only">Next</span>
									</a>
								</c:when>

							</c:choose>



						</div>

					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h2>${vo.board_title }</h2>
						<div>
							<div class="add-to-btn" style="display: inline-block;">
								<a onclick="like_regist();"> <c:choose>
										<c:when test="${likeCheck eq 1 }">
											<img src="images/like.png" alt="" style="margin-right: 5px"
												id="like_img">
										</c:when>
										<c:otherwise>
											<img src="images/like_gray.png" alt=""
												style="margin-right: 5px" id="like_img">
										</c:otherwise>
									</c:choose>
								</a> 좋아요<strong id="like_count">${likeCount }</strong>
								<li>
								<li><img src="images/comment.png" alt=""
									style="margin-right: 5px" id="like_img"> 댓글 <strong>${vo.board_cnt_reply }</strong>
								<li>
									</ul>
							</div>
							<div>
								<p>${vo.board_content }</p>

							</div>

						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col my-5">
					<div class="card card-outline-secondary my-4">
						<div
							class="card-header d-flex justify-content-between align-items-baseline">
							<h2>댓글 보기</h2>
							<c:if test="${ !empty loginInfo }">
								<a href="newreply.ca?board_sn=${vo.board_sn }"><h6>댓글
										쓰기</h6></a>
							</c:if>

						</div>



						<div class="card-body">

							<c:choose>

								<c:when test="${ fn:length(review) == 0}">
									<div style="text-align: center;">
										<span>등록된&nbsp;&nbsp;댓글이&nbsp;&nbsp;없습니다</span>
									</div>
								</c:when>

								<c:when test="${ fn:length(review) != 0 }">

									<c:forEach var="reply" items="${review}" varStatus="i">
										<div class="media mb-3">
											<div class=" col-1 mr-2">${reply.member_nick }</div>



											<div class="media-body">
												<p>${reply.reply_content }</p>
												<c:if test="${loginInfo.member_id eq reply.member_id}">
													<form id="reply_delete" action="replydelete" method="post">
														<input type="hidden" name="reply_sn"
															value="${reply.reply_sn }"> <input type="hidden"
															name="member_id" value="${reply.member_id }"> <input
															type="hidden" name="board_sn" value="${vo.board_sn }">
														<div style="float: right;">
															<a
																href="replydelete?board_sn=${vo.board_sn }&reply_sn=${reply.reply_sn}&member_id=${reply.member_id }"><span
																style="font-size: 10px; color: #666666; float: right">댓글
																	삭제</span></a>
														</div>
													</form>
												</c:if>
												<small class="text-muted">${reply.reply_writedate }</small>

											</div>
										</div>
										<hr>
									</c:forEach>


								</c:when>
							</c:choose>


						</div>



					</div>
				</div>



			</div>
		</div>
		<!-- End Cart -->






		<!-- Start copyright  -->
		<footer>
			<div class="footer-copyright">
				<p class="footer-company">
					All Rights Reserved. &copy; 2018 <a href="#">ThewayShop</a> Design
					By : <a href="https://html.design/">html design</a>
				</p>
			</div>
			<!-- End copyright  -->

			<a href="#" id="back-to-top" title="Back to top"
				style="display: none;">&uarr;</a>

		</footer>

		<!-- ALL JS FILES -->
		<script src="js/jquery-3.2.1.min.js"></script>
		<script src="js/popper.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<!-- ALL PLUGINS -->
		<script src="js/jquery.superslides.min.js"></script>
		<script src="js/bootstrap-select.js"></script>
		<script src="js/inewsticker.js"></script>
		<script src="js/bootsnav.js"></script>
		<script src="js/images-loded.min.js"></script>
		<script src="js/isotope.min.js"></script>
		<script src="js/owl.carousel.min.js"></script>
		<script src="js/baguetteBox.min.js"></script>
		<script src="js/jquery-ui.js"></script>
		<script src="js/jquery.nicescroll.min.js"></script>
		<script src="js/form-validator.min.js"></script>
		<script src="js/contact-form-script.js"></script>
		<script src="js/custom.js"></script>

		<script type="text/javascript">
// 좋아요 클릭하기
$( document ).ready(function(){
	
});


$document.ready(function(){
	alert("aa");
})
function like_regist() {

		$.ajax ({
		/* 경로 형태로 url 지정 */
		url: 'set_like'				//★★
		, data : {like_fn : ${vo.function_like}, board_sn : ${vo.board_sn}}
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