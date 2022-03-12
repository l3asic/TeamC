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

	



	<div class="wrapcontent-60">
		<!-- Start Slider (지역축제정보 뷰페이저)-->
		<%@include file="zzchaminhwan/main_02_slider.jsp"%>
		<!-- End Slider -->

		<!-- Start Instagram Feed  -->
		<%@include file="zzchaminhwan/main_07_instagram_feed.jsp"%>
		<!-- End Instagram Feed  -->

		<!-- 조회수 많은 여행지 3개 -->
		<div class="categories-shop">
			<div class="container">
				<div class="row">

					<c:forEach items="${vo_readcnt}" var="vo" varStatus="status">

						<div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
					<p style=" font-weight: bolder;   z-index: 100;  position: absolute; background: #bdedff; color: white; top:30%;left: 45%; display: flex; font-size:30px;">  <img alt="하트" src="images/ic_cmh_eye.png" style="width: 35px; height: 35px;align-self: center;">&nbsp${vo.board_read_cnt }</p>
						<p style=" font-weight: bolder;   z-index: 100;  position: absolute; background: #bdedff; color: white; top: 61%;left: 54%; display: flex; font-size:30px;">  <img alt="하트" src="images/like.png" style="width: 35px; height: 35px;align-self: center;">${vo.function_like }</p>
						<p style="font-weight: bolder;    z-index: 100;  position: absolute; background: #bdedff; color: white; top: 61%;left: 74%; display: flex; font-size:30px;"><img alt="하트" src="images/ic_cmh_comment.png" style="width: 35px; height: 35px;align-self: center;">${vo.board_cnt_reply } </p>
							<div class="shop-cat-box">
								<c:if test="${vo.picture_filepath ne null}">
									<img src="${vo.picture_filepath }" alt="여행지 대표사진"
										style="width: 345px; height: 310px" />
								</c:if>
								<c:if test="${vo.picture_filepath eq null}">
									<img src="images/no_image.png" alt="여행지 대표사진"
										style="width: 345px; height: 310px" />
								</c:if>
								<a class="btn hvr-hover"
									href="detail.ca?board_sn=${vo.board_sn }">${vo.board_title}</a>
							</div>
						</div>
					</c:forEach>

				</div>
			</div>
		</div>

		<!-- 댓글수, 좋아요수 가장 많은 여행지 각1 -->
		<div class="box-add-products">
			<div class="container">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
					<p style="font-weight: bolder;    z-index: 100;  position: absolute; background: ; color: white; top: 86%;left: 65%; display: flex; font-size:30px;">  <img alt="하트" src="images/like.png" style="width: 35px; height: 35px;align-self: center;">&nbsp${vo_likes.function_like }</p>
						<p style="font-weight: bolder;    z-index: 100;  position: absolute; background: ; color: white; top: 86%;left: 81%; display: flex; font-size:30px;"><img alt="하트" src="images/ic_cmh_comment.png" style="width: 35px; height: 35px;align-self: center;">&nbsp${vo_likes.board_cnt_reply } </p>
							<a class="btn hvr-hover"
								href="detail.ca?board_sn=${vo_likes.board_sn }">${vo_likes.board_title } :: 좋아요가 가장많음</a>
						<div class="offer-box-products">
							<c:if test="${vo_likes.picture_filepath ne null}">
								<img src="${vo_likes.picture_filepath }" alt="여행지 대표사진"
									style="width: 540px; height: 300px" />
							</c:if>
							<c:if test="${vo_replycnt.picture_filepath eq null}">
								<img src="images/no_image.png" alt="여행지 대표사진"
									style="width: 540px; height: 300px" />
							</c:if>
						</div>
					</div>
					
					<div class="col-lg-6 col-md-6 col-sm-12">
					<p style="font-weight: bolder;    z-index: 100;  position: absolute; background:; color: white; top: 86%;left: 65%; display: flex; font-size:30px;">  <img alt="하트" src="images/like.png" style="width: 35px; height: 35px;align-self: center;">&nbsp${vo_replycnt.function_like }</p>
						<p style="font-weight: bolder;    z-index: 100;  position: absolute; background:; color: white; top: 86%;left: 81%; display: flex; font-size:30px;"><img alt="하트" src="images/ic_cmh_comment.png" style="width: 35px; height: 35px;align-self: center;">&nbsp${vo_replycnt.board_cnt_reply } </p>
							<a class="btn hvr-hover"
								href="detail.ca?board_sn=${vo_replycnt.board_sn }">${vo_replycnt.board_title} :: 댓글수가 가장많음</a>
						<div class="offer-box-products">
						
							<c:if test="${vo_replycnt.picture_filepath ne null}">
								<img src="${vo_replycnt.picture_filepath }" alt="여행지 대표사진"
									style="width: 540px; height: 300px" />
							</c:if>
							<c:if test="${vo_replycnt.picture_filepath eq null}">
								<img src="images/no_image.png" alt="여행지 대표사진"
									style="width: 540px; height: 300px" />
							</c:if>
						
						</div>
					</div>
				</div>
			</div>
		</div>




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