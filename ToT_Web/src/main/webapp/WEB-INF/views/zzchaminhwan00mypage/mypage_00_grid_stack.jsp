<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="">


	<!-- Start Gallery  -->
	<div class="products-box">
		<div class="container" style="padding-bottom: 20px;">
			

			<div class="row special-list">

				<c:forEach items="${replyList }" var="list">
					<div class="col-lg-3 col-md-6 special-grid podded-vegetables" >
						<div class="products-single fix" style="cursor: pointer;">
							<a href="detail.ca?board_sn=${list.board_sn}"> <!-- style="width: 300px; height: 300px;" -->
								<!-- == 영역 == -->
								<div class="box-img-hover">
									<!-- == 사진 == -->
									<img src="${list.picture_filepath}" class="img-fluid"
										style="height: 255px;" alt="Image">
									<!-- ========= -->
									<div class="mask-icon">
										<!-- == 좋아요, 댓글수 == -->
										<p
											style="position: absolute; font-weight: bolder; background:; color: white; top: 43%; left: 40%; display: flex; font-size: 10px; align-items: center;">
											<img alt="하트" src="images/like_white.png"
												style="width: 35px; height: 35px; align-self: center; margin-right: 10px">${list.reply_like}
										</p>
										<!-- <p
											style="position: absolute; font-weight: bolder; background:; color: white; top: 43%; left: 55%; display: flex; font-size: 10px; align-items: center;">
											<img alt="하트" src="images/ic_cmh_comment_white.png"
												style="width: 35px; height: 35px; align-self: center;">ㅁㅁ
										</p> -->
										<!-- ================= -->
									</div>
								</div> <!-- ========= -->
							</a>
						</div>
					</div>
				</c:forEach>

			</div>
			<div class="row" style="margin-top: 30px;">
				<div class="col-lg-12">
					<div class="special-menu text-center">
						<div class="button-group filter-button-group">

							<a id='btn_stacks' onclick="stacks_more()" class="btn hvr-hover"
								style="color: #ffffff">더보기</a>

						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
	<!-- End Gallery  -->

</body>