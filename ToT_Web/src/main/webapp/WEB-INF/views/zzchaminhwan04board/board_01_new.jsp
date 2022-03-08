<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src='js/file_check.js?v=<%=new Date().getTime()%>'></script>
</head>
<body>

	<!-- 	<h3>방명록 글쓰기</h3> -->
	<!-- 	<!-- 파일 첨부하여 submit 하는 경우 -->
	<!-- 	1. method 는 post 로 지정 -->
	<!-- 	2. form 에는 반드시 enctype='multipart/form-data' 지정 -->
	<!--  -->

	<!-- 	<form action="board_insert" method="post" enctype="multipart/form-data"> -->
	<!-- 		<table class="container"> -->
	<!-- 			<tr> -->
	<!-- 				<th class='w-px120'>제목</th> -->
	<!-- 				<td><input type='text' name="board_title" title='제목' -->
	<!-- 					class='chk' /></td> -->
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<th>내용</th> -->
	<!-- 				<td><textarea name='board_content' class='chk' title='내용'></textarea> -->
	<!-- 				</td> -->
	<!-- 			</tr> -->
	<!-- 		<tr> -->
	<!-- 			<th>첨부파일</th> -->
	<!-- 			<td class='left'> -->
	<!-- 				<label> -->
	<!-- 				<a><img src='imgs/select.png' class='file-img' /></a> -->
	<!-- 				<input type="file" id='attach-file' name='file' />	 -->
	<!-- 				</label>	 -->
	<!-- 				<span id='file-name'></span> -->
	<!-- 				이미지 파일인 경우 미리보기 적용 -->
	<!-- 				<span id='preview'></span> -->
	<!-- 				<a id='delete-file'><i class='font-img fas fa-minus-circle'></i></a>						 -->
	<!-- 			</td> -->
	<!-- 			</tr>	 -->
	<!-- 		</table> -->
	<!-- 		</form> -->

	<!-- 	<div class='btnSet'> -->
	<!-- 		<a class='btn hvr-hover' onclick='$("form").submit()'>저장하기</a> <a -->
	<!-- 			class='btn hvr-hover' href='board_list'>취소</a> -->
	<!-- 	</div> -->

	<form action="board_insert" method="post" enctype="multipart/form-data">
		<div class="contact-box-main">
			<div class="container">
				<div class="row">
					<div class="col-lg-8 col-sm-12">
						<div class="contact-form-right">
							<h2>
								글작성 <select name="board_class" size="1" style="float: right; font-size: medium; width: 150px;">
									<option value="user" selected><p> 유저게시판</p></option>
									<option value="other" ><p>다른게시판</p></option>
								</select>
							</h2>
							<form id="contactForm" novalidate="true">
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
							</form>
						</div>
					</div>
					<div class="col-lg-4 col-sm-12">
						<div class="contact-info-left">
						빱
						</div>
						<div class="contact-info-left" style="margin-top: 50px;">
							<h2>첨부파일</h2>
							<td class=''><label> <a> <img
										src='imgs/select.png' class='file-img' />
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
			</div>
		</div>

	</form>

	<!-- <div class="inputArea"> -->
	<!--  <label for="gdsImg">이미지</label> -->
	<!--  <input type="file" id="gdsImg" name="file" /> -->
	<!--  <div class="select_img"><img src="" /></div> -->
	<hr>


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

	</div>


</body>
</html>