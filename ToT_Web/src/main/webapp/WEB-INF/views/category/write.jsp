<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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


<form action="category_write_insert" method="post" enctype="multipart/form-data">
		<div class="contact-box-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-sm-12">
						<div class="contact-form-right">
							<h2>
								여행지 등록 <select name="board_class" size="1" style="float: right; font-size: medium; width: 150px;">
								
								<c:if test="${boardVO.board_class eq 'tour'}">
									<option value="tour" selected><p> 관광지</p></option>
									<option value="activity" ><p>액티비티</p></option>
									<option value="festival" ><p>지역축제</p></option>
								</c:if>
								<c:if test="${boardVO.board_class eq 'activity'}">
									<option value="tour" ><p> 관광지</p></option>
									<option value="activity" selected><p>액티비티</p></option>
									<option value="festival" ><p>지역축제</p></option>
								</c:if>
								<c:if test="${boardVO.board_class eq 'festival'}">
									<option value="tour" ><p> 관광지</p></option>
									<option value="activity" ><p>액티비티</p></option>
									<option value="festival"selected ><p>지역축제</p></option>
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
												data-error="Please enter your Subject" style="margin: 40px 0px;">
											<div class="help-block with-errors"></div>
										</div>
									</div>
									<div class="col-md-12">
										<div class="form-group">
											<textarea class="form-control" name='board_content'
												class='chk' title='내용' placeholder="내용을 입력하세요" rows="4"
												data-error="Write your message" required=""></textarea>
											<div class="help-block with-errors"></div>
										</div>
										<div class="submit-button text-center">
											<button class="btn hvr-hover " id="submit" type="submit"
												style="pointer-events: all; cursor: pointer;">작성</button>
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
						<h2>첨부파일s</h2>
							<td class=''><label> <a> <img
										src='images/select.png' class='file-img' />
								</a> <input type="file" id='attach-file' name='multipartFile' multiple="multiple" />
							</label>
								<div>
									<span id='preview' style="max-width: 256px; max-height: 256px;"></span>
									<a id='delete-file'> <i
										class='font-img fas fa-minus-circle'></i>
									</a>
								</div></td>
							<ul>
								<li>
									<p>
										<i class="fas fa-map-marker-alt"></i>TEXT <br><%=request.getRealPath("/")%>
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
						<div class="contact-info-left" style="margin-top: 50px;">
						</div>
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