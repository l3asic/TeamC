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
<title>홈 메인화면</title>
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

	<script type="text/javascript" src='js/file_check.js'></script>
	<script type="text/javascript">
if ( ${ ! empty vo.member_filepath } ) {
	// 첨부파일이 있는 글인 경우 삭제버튼 보이게
	$('#delete-file').css('display', 'inline');
	// 첨부파일이 이미지 파일인 경우 미리보기
	if ( isImage( '${vo.member_filepath}' ) )
		$('#preview').html("<img src='${vo.member_filepath}' id='preview-img' /> ");
	document.getElementById("preview").src = $('#input_file').value();
}	


function click_input_file() {
	$("#input_file").click();
	   
}
function delete_file() {
	document.getElementById("preview").src = "images/tot_icon_profile_none.png";
	$("#input_filepath").val("images/tot_icon_profile_none.png");
}
</script>
	<input type="hidden" name="member_id" value=" ${vo.member_id }">



	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>내 정보 수정</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->


	<form action="my_info_update" method="post"
		enctype="multipart/form-data">

		<!-- Start Contact Us  -->
		<div class="contact-box-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-sm-12">
						<div class="contact-form-right">
							<h2>정보 수정 페이지</h2>
							<p>프로필 사진, 닉네임 및 비밀번호만 변경 가능합니다</p>
							<%--  <form id="contactForm" action="replyinsert.ca?board_sn=${board_sn }&member_id=${vo.member_id}"  method="post" enctype="multipart/form-data"> --%>
							<div class="row">
								<div class="col-md-12" style="text-align: center;">
									<div class="form-group" style="margin-left: 35%;">



										<img class="rounded-circle border p-1 picture_member_profile"
											id="preview"
											<c:if test="${vo.member_filepath ne null}">
												src="${vo.member_filepath}" 
												
										</c:if>
											<c:if test="${vo.member_filepath eq null}">
												src="images/tot_icon_profile_none.png" 
												
										</c:if>
											alt="프사" style="margin-bottom: 5px; width: 150px;"
											name="member_filepath" /> <br> .
										<input type="file" value="${vo.member_filepath }" 
											style="display: non;" id="input_file">
										<strong
											style="font-size: 12px; text-decoration: underline; cursor: pointer;"
											onclick="click_input_file()"> 프로필사진 바꾸기</strong> <a
											id='delete-file' onclick="delete_file()"> [<i
											class='fas fa-times font-img'></i>]
										</a>
										</input>
										<input type="text" value="${vo.member_filepath }" id="input_filepath" name="member_filepath">
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group" style="margin-left: 45%;">
										아이디<input type="text" class="form-control" id="member_id"
											name="member_id" value="${vo.member_id }" placeholder="아이디"
											rows="4" required style="width: 90%; height: 40%;" readonly /> 
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group" style="margin-left: 45%;">
										비밀번호<input type="text" class="form-control" id="member_pw"
											name="member_pw" placeholder="비밀번호" rows="4" value="${vo.member_pw }" 
											style="width: 90%; height: 40%;" />
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group" style="margin-left: 45%;">
										성명<input type="text" class="form-control" id="member_name"
											name="member_name" value="${vo.member_name }"
											placeholder="이름" rows="4" required
											style="width: 90%; height: 40%;" readonly />
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group" style="margin-left: 45%;">
										별명<input type="text" class="form-control" id="member_nick"
											name="member_nick" value="${vo.member_nick }" rows="4" required
											style="width: 90%; height: 40%;" />
									</div>
								</div>
								<a href="#" style="margin-left: 83%; line-height: 1px;"><strong
									style="text-decoration: underline;">회원 탈퇴하기</strong></a>


								<div class="submit-button text-center"
									style="margin-left: 54%; margin-top: 5%;">
									<button class="btn hvr-hover" type="submit"
										style="background-color: #BDEDFF !important; margin: 5px;"
										onclick="submit()">수정하기</button>
									<button class="btn hvr-hover" type="reset"
										style="background-color: #BDEDFF !important; margin: 5px;"
										onclick="history.go(-1)">취소</button>
									<div id="msgSubmit" class="h3 text-center hidden"></div>
									<div class="clearfix"></div>
								</div>


								<!-- row 전까지임 -->

							</div>
						</div>
						<!-- </form> -->
					</div>
				</div>
				<div class="col-lg-4 col-sm-12"></div>
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