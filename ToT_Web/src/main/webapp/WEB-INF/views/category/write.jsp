<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>여행지 신규 등록</title>
<script src="/newspaper/mobile/js/jquery-3.2.1.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
<script type="text/javascript"
	src='js/file_check.js?v=<%=new Date().getTime()%>'></script>


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
	<%@include file="../include/header.jsp"%>
	<!-- End header  -->
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
	<form action="category_write_insert" method="post"
		enctype="multipart/form-data">
		<div class="contact-box-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-sm-12">
						<div class="contact-form-right">
							<h2>
								여행지 등록 <select name="board_class" size="1"
									style="float: right; font-size: medium; width: 150px;">

									<c:if test="${boardVO.board_class eq 'tour'}">
										<option value="tour" selected><p>관광지</p>
										</option>
										<option value="activity"><p>액티비티</p>
										</option>
										<option value="festival"><p>지역축제</p>
										</option>
									</c:if>
									<c:if test="${boardVO.board_class eq 'activity'}">
										<option value="tour"><p>관광지</p>
										</option>
										<option value="activity" selected><p>액티비티</p>
										</option>
										<option value="festival"><p>지역축제</p>
										</option>
									</c:if>
									<c:if test="${boardVO.board_class eq 'festival'}">
										<option value="tour"><p>관광지</p>
										</option>
										<option value="activity"><p>액티비티</p>
										</option>
										<option value="festival" selected><p>지역축제</p>
										</option>
									</c:if>
								</select>
							</h2>
							<!-- 							<form id="contactForm" novalidate="true"> -->
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input class="form-control" input type='text'
											name="board_title" title='제목' class='chk'
											placeholder="제목을 입력하세요" required=""
											data-error="Please enter your Subject"
											style="margin: 40px 0px;">
										<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<textarea class="form-control" name='board_content'
											class='chk' title='내용' placeholder="내용을 입력하세요" rows="4"
											data-error="Write your message" required=""
											style="height: 600px;"></textarea>
										<div class="help-block with-errors"></div>
									</div>
									<div class="submit-button text-center">
										<button class="btn hvr-hover " id="submit" type="submit"
											style="pointer-events: all; cursor: pointer;">등록</button>
										<button class="btn hvr-hover " id="cancel"
											style="pointer-events: all; cursor: pointer;"
											onclick="history.back(-1)">취소</button>
										<div id="msgSubmit" class="h3 text-center hidden"></div>
										<div class="clearfix"></div>
									</div>
								</div>
							</div>
							<!-- 							</form> -->
						</div>
					</div>
					<div class="col-lg-4 col-sm-12">
						<div class="contact-info-left">
							<h2>첨부파일</h2>
							<td class=''><label><input type="file" id='attach-file' name='multipartFile'
									multiple="multiple" />
							</label></td>

						</div>
						<div class="contact-info-left"
							style="margin-top: 50px; background: none;">
							<div>
								<span id='preview' style="max-width: 256px; max-height: 256px;"></span>
								<a id='delete-file'  style="display: none;"> <i class='font-img fas fa-minus-circle'></i>
								</a>
							</div>

						</div>
					</div>


				</div>
			</div>
		</div>

	</form>
	<!-- =================== 푸터,카피라이트 ==================== -->
	<%@include file="../include/footer.jsp"%>
	<%@include file="../include/copyright.jsp"%>
	<!-- ======================================================= -->
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