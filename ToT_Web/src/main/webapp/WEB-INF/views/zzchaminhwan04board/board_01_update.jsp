<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>글수정하기</title>
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

<meta charset="UTF-8">
<script type="text/javascript"
	src='js/file_check.js?v=<%=new Date().getTime()%>'></script>
</head>
<body>
	<!-- Start header  -->
	<%@include file="../include/header.jsp"%>
	<!-- End header  -->

	<form action="board_update" method="post" enctype="multipart/form-data">
		<input type="hidden" value="${boardVO.board_sn }" name='board_sn'></input>
		<div class="contact-box-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-sm-12">
						<div class="contact-form-right">
							<h2>글수정</h2>
							<!-- 							<form id="contactForm" novalidate="true"> -->
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input class="form-control" input type='text'
											name="board_title" title='제목' class='chk'
											value='${boardVO.board_title }' required=""
											data-error="Please enter your Subject">
										<div class="help-block with-errors"></div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="form-group">
										<textarea class="form-control" name='board_content'
											class='chk' title='내용' rows="4"
											data-error="Write your message" required="">${boardVO.board_content }</textarea>
										<div class="help-block with-errors"></div>
									</div>
									
								</div>
							</div>
							<!-- 							</form> -->
							<div class="col-md-12" style="margin-top: 30px; background: #ffffff; border: 1px solid #495057;">
							<h2 style="margin-top: 5%;">첨부파일</h2>
							<td class=''><label> <a> <img
										src='images/select.png' class='file-img' />
								</a> <input type="file" id='attach-file' name='multipartFile' />
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
							
							
						</div>
					</div>
				<!-- 	<div class="col-lg-4 col-sm-12">
									<div class="contact-info-left">
						빱
						</div> -->
						
						
						<div class="submit-button" style="margin-left: 30%; margin-top: 5%;">
										<button class="btn hvr-hover " id="update_submit" type="submit"
											style="pointer-events: all; cursor: pointer; background: #2ba0da;">수정완료</button>
										<button class="btn hvr-hover " id="update_cancel"
											style="pointer-events: all; cursor: pointer; background: #2ba0da;"
											onclick="history.back(-1)">취소</button>
										<div id="msgSubmit" class="h3 text-center hidden"></div>
										<div class="clearfix"></div>
									</div>
									</div>
						
					</div>
				</div>
		
		
	</form>

	<!-- Start Footer  -->
	<%@include file="../include/footer.jsp"%>
	<!-- End Footer  -->

	<!-- Start copyright  -->
	<%@include file="../include/copyright.jsp"%>
	<!-- End copyright  -->
</body>
</html>