<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- Basic -->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>#BDEDFF</title>
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


	<!-- Start header  -->
	<%@include file="include/header.jsp"%>
	<!-- End header  -->

	<%-- 	<!-- side left  -->
	<%@include file="include/side_left.jsp"%>
	<!--    -->

	<!-- side right  -->
	<%@include file="include/side_right.jsp"%>
	<!--    --> --%>

	<!-- Start Top Search -->
	<%@include file="zzchaminhwan/main_01_top_search.jsp"%>
	<!-- End Top Search -->

	<div class="wrapcontent-60">
		<!-- Start Slider (지역축제정보 뷰페이저)--><%@include
			file="zzchaminhwan/main_02_slider.jsp"%>
		<!-- End Slider -->

		<!-- Start Instagram Feed  -->
		<%@include file="zzchaminhwan/main_07_instagram_feed.jsp"%>
		<!-- End Instagram Feed  -->

		<!-- Start Categories  -->
		<%@include file="zzchaminhwan/main_03_categories.jsp"%>
		<!-- End Categories -->

		<!-- Start box-add-products  -->
		<%@include file="zzchaminhwan/main_04_box_add_produts.jsp"%>
		<!-- End asdf -->

		<!-- Start Products  -->
		<%@include file="zzchaminhwan/main_05_products.jsp"%>
		<!-- End Products  -->

		<!-- Start Blog  -->
		<%@include file="zzchaminhwan/main_06_blog.jsp"%>
		<!-- End Blog  -->



	</div>


	<!-- Start Footer  -->
	<%@include file="include/footer.jsp"%>
	<!-- End Footer  -->

	<!-- Start copyright  -->
	<%@include file="include/copyright.jsp"%>
	<!-- End copyright  -->



	<%@include file="include/back-to-top.jsp"%>
	<!-- 	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a> -->


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
</body>

</html>