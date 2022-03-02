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

	<!-- ★★★☆ 페이지 넘어가기위해서 필요함 -->
	<form action="activity.ca" method="post">

	<input type="hidden" name="curPage" value="1"    />    <!-- 여기서 1은 현재페이지 -->
	</form>
<!-- 페이지처리 여기까지 -->

	
	<!-- ★★★☆ 페이지 넘어가기위해서 필요함 -->
	<jsp:include page="/WEB-INF/views/include/header.jsp"/>
	<!-- 여기까지 -->
	
	
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