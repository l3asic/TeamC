<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToT 글작성</title>
<script type="text/javascript"
	src='js/file_check.js?v=<%=new Date().getTime()%>'></script>
</head>
<body>
	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>유저게시판</h2>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<form action="multi_board_insert" method="post"
		enctype="multipart/form-data">
		<div class="contact-box-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-sm-12">
						<div class="contact-form-right">
							<h2>
								글작성 <select name="board_class" size="1"
									style="float: right; font-size: medium; width: 150px;">
									<option value="user" selected><p>유저게시판</p>
									</option>
									<option value="other"><p>다른게시판</p>
									</option>
								</select>
							</h2>
							<!-- 							<form id="contactForm" novalidate="true"> -->
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<input class="form-control" type="hidden" name="member_id"
											value="${loginInfo.member_id}"> <input
											class="form-control" type='text' name="board_title"
											title='제목' class='chk' placeholder="제목을 입력하세요" required=""
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
							<h2>첨부파일</h2>
							<td class=''><label> <input type="file" id='attach-file' name='multipartFile'
									multiple="multiple" />
							</label></td>

						</div>
						<div class="contact-info-left"
							style="margin-top: 50px; background: none;">
							<div>
								<span id='preview' style="max-width: 256px; max-height: 256px;"></span>
								<a id='delete-file' style="display: none;"> <i
									class='font-img fas fa-minus-circle'></i>
								</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>


	<script>
		//   $("#gdsImg").change(function(){
		//    if(this.files && this.files[0]) {
		//     var reader = new FileReader;
		//     reader.onload = function(data) {
		//      $(".select_img img").attr("src", data.target.result).width(500);        
		//     }
		//     reader.readAsDataURL(this.files[0]);
		//    }
		//   });
	</script>




</body>
</html>