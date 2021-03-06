<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Site Icons -->
<link rel="shortcut icon" href="images/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="images/apple-touch-icon.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="css/style.css">
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
<script src="js/form-validator.min.js"></script>
<script src="js/contact-form-script.js"></script>
<script src="js/custom.js"></script>



<!--  Responsive C -->
<!-- ★ Start Main Top -->
<!-- <div class="main-top"> -->
<!-- 	<div class="container-fluid"> -->
<!-- 		<div class="row"> -->
<!-- 			<div class="text-slid-box" -->
<!-- 				"right" style="width: 60%; margin: 0 auto;"> -->
<!-- 				<a href="home">Trip Or Travel 링크 바로가기</a> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->
<!-- <!-- End Main Top ★-->



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
				<a class="navbar-brand" href="home"><img
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
								href="mypage_${loginInfo.member_id}"><strong>${loginInfo.member_id}</strong></a></li>
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
					<li class="nav-item"><a class="nav-link" href="home">홈</a></li>
					<li class="nav-item"><c:if test="${ empty loginInfo }">
							<a class="nav-link" href="login">
						</c:if> <c:if test="${ !empty loginInfo }">
							<a class="nav-link" href="tend">
						</c:if> 성향 </a></li>
					<li class="dropdown active"><a href="tour.ca"
						class="nav-link dropdown-toggle arrow" data-toggle="dropdown">카테고리</a>
						<ul class="dropdown-menu">
							<li><a href="tour.ca">관광지</a></li>
							<li><a href="activity.ca">액티비티</a></li>
							<li><a href="festival.ca">지역축제</a></li>
						</ul></li>
					<!-- 					<li class="dropdown active"><a href="#" class="nav-link dropdown-toggle arrow" data-toggle="dropdown">파티</a> -->
					<!-- 						<ul class="dropdown-menu"> -->
					<!-- 							<li><a href="shop.html">Sidebar Shop</a></li> -->
					<!-- 							<li><a href="shop-detail.html">Shop Detail</a></li> -->
					<!-- 							<li><a href="cart.html">Cart</a></li> -->
					<!-- 							<li><a href="checkout.html">Checkout</a></li> -->
					<!-- 							<li><a href="my-account.html">My Account</a></li> -->
					<!-- 							<li><a href="wishlist.html">Wishlist</a></li> -->
					<!-- 						</ul> -->
					<!-- 					</li> -->
					<li class="dropdown active"><a class="nav-link"
						href="/tot/board_list?board_class=user">유저게시판</a> <!-- <ul class="dropdown-menu">
							<li><a href="/tot/board_list?board_class=user"> 유저게시판</a></li>
							<li><a href="/tot/board_list?board_class=user2">다른게시판</a></li>
						</ul> --></li>
					<!-- <li class="nav-item"><a class="nav-link"
						href="servicecenter.sc">고객지원</a></li> -->
				</ul>
			</div>
			<!-- /.navbar-collapse -->

			<!--  Start Atribute Navigation -->
			<!-- 	<h1>돋보기랑 장바구니</h1>
			<div class="attr-nav">
				<ul>
					<li class="search"><a href="#"><i class="fa fa-search"></i></a></li>
					<li class="side-menu"><a href="#"> <i
							class="fa fa-shopping-bag"></i> <span class="badge">3</span>
							<p>My Cart</p>
					</a></li>
				</ul>
			</div> -->
			<!-- End Atribute Navigation -->

		</div>

	</nav>
	<!-- End Navigation -->

</header>
<!-- End Main Top -->
