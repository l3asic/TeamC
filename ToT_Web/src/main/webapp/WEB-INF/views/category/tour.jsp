<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<!-- ★★★☆ 페이지 넘어가기위해서 필요함 -->
	<form action="tour.ca" method="post">

	<input type="hidden" name="curPage" value="1"    />    <!-- 여기서 1은 현재페이지 -->
	</form>
<!-- 페이지처리 여기까지 -->


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
					<a class="navbar-brand" href="<c:url value='/' />"><img src="images/main_logo.png" class="logo" alt=""></a>
				<div class="navbar-float" style="position: absolute; top: 0; right: 0; padding-left: 20px; padding-bottom: 5px">
					<ol style="font-size: 13px">
						<li style="list-style-type: none; float: left;"><a href="#">로그인</a></li>
						<li style="list-style-type: none; float: left;"> ｜ </li>
						<li style="list-style-type: none; float: left;"><a href="#">회원가입</a></li>
					</ol>
				</div>
				</div>
				<!-- End Header Navigation -->

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="navbar-menu">
					<ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
						<li class="nav-item"><a class="nav-link" href="<c:url value='/' />">홈</a></li>
						<li class="dropdown active"><a href="#"	class="nav-link dropdown-toggle arrow" data-toggle="dropdown">카테고리</a>
							<ul class="dropdown-menu">
								<li><a href="tour.ca">관광지</a></li>
								<li><a href="activity.ca">액티비티</a></li>
								<li><a href="festival.ca">지역축제</a></li>
							</ul>
						</li>
						<li class="dropdown active"><a href="#"	class="nav-link dropdown-toggle arrow" data-toggle="dropdown">파티</a>
							<ul class="dropdown-menu">
								<li><a href="shop.html">Sidebar Shop</a></li>
								<li><a href="shop-detail.html">Shop Detail</a></li>
								<li><a href="cart.html">Cart</a></li>
								<li><a href="checkout.html">Checkout</a></li>
								<li><a href="my-account.html">My Account</a></li>
								<li><a href="wishlist.html">Wishlist</a></li>
							</ul>
						</li>
						<li class="nav-item"><a class="nav-link" href="gallery.html">Gallery</a></li>
						<li class="nav-item"><a class="nav-link"
							href="contact-us.html">Contact Us</a></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- Start Side Menu -->
			<div class="side">
				<a href="#" class="close-side"><i class="fa fa-times"></i></a>
				<li class="cart-box">
					<ul class="cart-list">
						<li><a href="#" class="photo"><img src="images/img-pro-01.jpg" class="cart-thumb" alt="" /></a>
							<h6>
								<a href="#">Delica omtantur </a>
							</h6>
							<p>
								1x - <span class="price">$80.00</span>
							</p></li>
						<li><a href="#" class="photo"><img
								src="images/img-pro-02.jpg" class="cart-thumb" alt="" /></a>
							<h6>
								<a href="#">Omnes ocurreret</a>
							</h6>
							<p>
								1x - <span class="price">$60.00</span>
							</p></li>
						<li><a href="#" class="photo"><img
								src="images/img-pro-03.jpg" class="cart-thumb" alt="" /></a>
							<h6>
								<a href="#">Agam facilisis</a>
							</h6>
							<p>
								1x - <span class="price">$40.00</span>
							</p></li>
						<li class="total"><a href="#"
							class="btn btn-default hvr-hover btn-cart">VIEW CART</a> <span
							class="float-right"><strong>Total</strong>: $180.00</span></li>
					</ul>
				</li>
			</div>
			<!-- End Side Menu -->
		</nav>
		<!-- End Navigation -->
	</header>
	<!-- End Main Top -->

	<!-- Start Top Search -->
	<div class="top-search">
		<div class="container">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-search"></i></span>
				<input type="text" class="form-control" placeholder="Search">
				<span class="input-group-addon close-search"><i
					class="fa fa-times"></i></span>
			</div>
		</div>
	</div>
	<!-- End Top Search -->

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

	<!-- Start Shop Page  -->
	<div class="shop-box-inner">
		<div class="container">
			<div class="row">
				<div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
					<div class="right-product-box">
						<div class="product-item-filter row categoryValue">
							관광지
							<!-- <div class="col-12 col-sm-4 text-center text-sm-right">
								<ul class="nav nav-tabs ml-auto">
									<li><a class="nav-link active" href="#grid-view"
										data-toggle="tab"> <i class="fa fa-th"></i>
									</a></li>
									<li><a class="nav-link" href="#list-view"
										data-toggle="tab"> <i class="fa fa-list-ul"></i>
									</a></li>
								</ul>
							</div> -->
						</div>
						<div class="product-categorie-box">
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane fade show active" id="grid-view" style="align-content: center;">
									<div class="row">
										<%-- <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<img src="${vo.picture_filepath }" class="img-fluid" alt="Image">
												</div>
												<div class="why-text">
													<h4>${vo.board_title }</h4>
													<div class="list-sub">
														<ul>
															<li><img src="images/like.png" alt="">
																<h5>좋아요</h5>
																<h5>${vo.function_like }</h5></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
 --%>
										<c:forEach var="vo" items="${vo }">
											<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
												<div class="products-single fix">
													<div class="box-img-hover">
													<input type="hidden" name="member_id" value="${vo.member_id}"    />  
													<a href="detail.ca?board_sn=${vo.board_sn }">
														<%-- <img src="${vo.picture_filepath }" class="img-fluid">
															<c:if test="${empty vo.picture_filepath }">
																<img src="images/no_image.png" class="img-fluid" alt="NO IMAGE">
															</c:if> --%>
															
														<c:choose>
															<c:when test="${ !empty vo.picture_filepath }">
															<img src="${vo.picture_filepath }" class="img-fluid">
															</c:when>
															<c:otherwise>
															<img src="images/no_image.png" class="img-fluid" alt="NO IMAGE">
															</c:otherwise>
														</c:choose>
														</a>
													</div>
													<!-- <div class="why-text"> -->
													<div style="text-align: center; margin-top: 10px; font-size: 20px">
													<a href="#">${vo.board_title }</a>
													</div>
													<div style="margin-left: 40%">
													<div class="list-sub"  style="list-style-type: none; width: 50px;">
														<ul class="inline-align" style="margin-right: 7px;">
															<li><img src="images/like.png" alt="">
																<h5>${vo.function_like }</h5></li>
														</ul>
														<ul class="inline-align">
															<li><img src="images/comment.png" alt="">
																<h5>${vo.board_cnt_reply }</h5></li>
														</ul>
													</div>
													</div>
													<!-- </div> -->
												</div>
											</div>

										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
					</div>
				</div>
				
		</div>

	<!-- End Shop Page -->

	<!-- Start Instagram Feed  -->
	<!-- <div class="instagram-box">
		<div class="main-instagram owl-carousel owl-theme">
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-01.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-02.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-03.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-04.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-05.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-06.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-07.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-08.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-09.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
			<div class="item">
				<div class="ins-inner-box">
					<img src="images/instagram-img-05.jpg" alt="" />
					<div class="hov-in">
						<a href="#"><i class="fab fa-instagram"></i></a>
					</div>
				</div>
			</div>
		</div>
	</div> -->
	<!-- End Instagram Feed  -->


	<!-- Start Footer  -->
<!-- 	<footer>
		<div class="footer-main">
			<div class="container">
				<div class="row">
				</div>
				<hr>
				<div class="row">
					<div class="col-lg-4 col-md-12 col-sm-12">
						<div class="footer-link-contact">
							<h4>Contact Us</h4>
							<ul>
								<li>
									<p>
										<i class="fas fa-map-marker-alt"></i>Address: Michael I. Days
										3756 <br>Preston Street Wichita,<br> KS 67213
									</p>
								</li>
								<li>
									<p>
										<i class="fas fa-phone-square"></i>Phone: <a
											href="tel:+1-888705770">+1-888 705 770</a>
									</p>
								</li>
								<li>
									<p>
										<i class="fas fa-envelope"></i>Email: <a
											href="mailto:contactinfo@gmail.com">contactinfo@gmail.com</a>
									</p>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</footer> -->
	<!-- End Footer  -->
	
	
	<!-- ★★★☆ 페이지 넘어가기위해서 필요함 -->
	<jsp:include page="/WEB-INF/views/include/page.jsp"/>
	<!-- 여기까지 -->
	
	

		<!-- Start copyright  -->
	<footer>
	<div class="footer-copyright">
		<p class="footer-company">
			All Rights Reserved. &copy; 2018 <a href="#">ThewayShop</a> Design By
			: <a href="https://html.design/">html design</a>
		</p>
	</div>
	<!-- End copyright  -->

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>
	
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
</body>

</html>