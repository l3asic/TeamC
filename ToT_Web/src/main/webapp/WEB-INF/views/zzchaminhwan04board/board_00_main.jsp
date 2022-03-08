<%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
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


</head>
<body>

	<!-- Start header  -->
	<%@include file="../include/header.jsp"%>
	<!-- End header  -->

	

	<div class="wrapcontent-60">
		<!-- Start list -->
		<c:if test="${path eq '/board_list' }">
			<%@include file="../zzchaminhwan04board/board_01_list.jsp"%>
		</c:if>
		<c:if test="${path eq '/board_new' }">
			<%@include file="../zzchaminhwan04board/board_01_new.jsp"%>
		</c:if>
		<c:if test="${path eq '/board_detail' }">
			<%@include file="../zzchaminhwan04board/board_02_detail.jsp"%>
		</c:if>
		<!-- End list -->
		<c:if test="${path eq '/mypage_' }">
			<%@include file="../zzchaminhwan00mypage/mypage_00_main.jsp"%>
		</c:if>
	</div>








	<!-- Start copyright  -->
	<%@include file="../include/copyright.jsp"%>
	<!-- End copyright  -->

				<form action="board_detail" method="post">
								<input type="hidden" name='board_sn' value=""></input>
							</form>
							
	<script type="text/javascript">
		function go_detail(board_sn) {
			$('[name = board_sn]').val(board_sn);
			$('form').attr('action', 'board_detail');
			$('form').submit();
		}
		
	</script>
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
	<!-- 	<script src="js/custom.js"></script> -->

	<!-- 	========================== board_sn =========================== -->
<!-- 	<form action="board_detail" method="post"> -->
<!-- 		<input type="hidden" name='board_sn' value=""></input> -->
<!-- 	</form> -->
	<!-- 	============================================================ -->
	<script type="text/javascript">
		function go_mypage(str) {
		
			location.href = "mypage_" + str;
		}
	</script>


</body>
</html>













