<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	
<form action="replyinsert.ca?board_sn=${board_sn }&member_id=${vo.member_id}" method="post" enctype="multipart/form-data">
    <!-- Start Contact Us  -->
    <div class="contact-box-main">
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-sm-12">
                    <div class="contact-form-right">
                        <h2>댓글작성</h2>
                        <p>댓글과 사진으로 당신의 경험을 공유해주세요</p>
                       <%--  <form id="contactForm" action="replyinsert.ca?board_sn=${board_sn }&member_id=${vo.member_id}"  method="post" enctype="multipart/form-data"> --%>
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="form-group">
                                    	<!-- <th>닉네임 나올곳!!!!!!</th> -->
                                        <textarea class="form-control" id="message" name="reply_content" placeholder="당신의 생각을 적어주세요" rows="4"  required style="height:400px"></textarea>
                                        <div class="help-block with-errors"></div>
                                    </div>
                                    <div class="submit-button text-center">
                                        <button class="btn hvr-hover" type="submit" style="background-color: #BDEDFF !important">댓글 등록하기</button>
                                        <div id="msgSubmit" class="h3 text-center hidden"></div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                        <!-- </form> -->
                    </div>
                </div>
				<div class="col-lg-4 col-sm-12">
                   
                </div>
            </div>
        </div>
    </div>
 </form> 

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