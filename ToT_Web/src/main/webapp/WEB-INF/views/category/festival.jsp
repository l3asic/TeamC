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
<title>Category - 축제</title>
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
	
		<!-- Start header  -->
	<%@include file="../include/header.jsp"%>
	<!-- End header  -->
	

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>카테고리</h2>
				</div>
					<div>
					<c:if test="${loginInfo.member_grade eq 'master'}">
						<a class="btn hvr-hover" href="category_write_view?board_class=festival" style="float: right; background-color:transparent; font-size: 15px; color: #999999;">
							여행지 등록 </a>
					</c:if>
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
							지역축제
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
										<c:forEach var="vo" items="${page.list }">
											<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
												<div class="products-single fix">
													<div class="box-img-hover">
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
															<li><img src="images/like.png" alt="" style="width: 20px; height: 20px;">
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
	
		<!-- Start Footer  -->
	<%@include file="../include/footer.jsp"%>
	<!-- End Footer  -->
	

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