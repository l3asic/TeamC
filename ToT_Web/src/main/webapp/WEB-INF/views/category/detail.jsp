<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<!-- Basic -->

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>${vo.board_title}</title>
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

<script type="text/javascript">
		function go_mypage(member_id) {
		
			location.href = "mypage_" + member_id;
		}
		</script>

</head>

<body>
	<!-- Start header  -->
	<%@include file="../include/header.jsp"%>
	<!-- End header  -->



	<!-- Start Shop Detail  -->
	<div class="shop-detail-box-main">
		<div class="container">
			<div class="row">
				<div class="col-xl-5 col-lg-5 col-md-6">
					<div id="carousel-example-1"
						class="single-product-slider carousel slide" data-ride="carousel">
						<div class="carousel-inner" role="listbox"
							style="width: 415px; height: 311px;">
							<c:choose>
								<c:when test="${ fn:length(picture) == 0}">
									<img src="images/no_image.png" alt="">
								</c:when>
								<c:when test="${ fn:length(picture) != 0 }">
									<c:forEach var="pic" items="${picture}" varStatus="i">
										<c:choose>
											<c:when test="${0 == i.index }">
												<div class="carousel-item active">
													<img class="d-block w-100" src="${pic.picture_filepath }"
														alt="NO IMAGE">
												</div>
											</c:when>
											<c:when test="${0 != i.index }">
												<div class="carousel-item">
													<img class="d-block w-100" src="${pic.picture_filepath }"
														alt="NO IMAGE">
												</div>
											</c:when>
										</c:choose>
									</c:forEach>
									<a class="carousel-control-prev" href="#carousel-example-1"
										role="button" data-slide="prev"> <i
										class="fa fa-angle-left" aria-hidden="true"></i> <span
										class="sr-only">Previous</span>
									</a>
									<a class="carousel-control-next" href="#carousel-example-1"
										role="button" data-slide="next"> <i
										class="fa fa-angle-right" aria-hidden="true"></i> <span
										class="sr-only">Next</span>
									</a>
								</c:when>
							</c:choose>
						</div>
					</div>
				</div>
				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<!-- == 여행지 삭제 , 성향 == -->
						<c:if test="${loginInfo.member_grade eq 'master' }">
							<span style=""><a
								style="font-size: 10px; color: #666666; float: right; margin-top: 20px; position: absolute; left: 105%; width: 25px;"
								href="board_delete?board_sn=${vo.board_sn}"> 삭제 </a></span>
							<span style=""><a
								style="font-size: 10px; color: #666666; float: right; margin-top: 50px; position: absolute; left: 105%; width: 25px;"
								href="tend_category?board_sn=${vo.board_sn}"> 성향 </a></span>
						</c:if>
						<!-- =============== -->
						<div style="position: absolute; left: 75%;">
							<img src="images/like.png" alt="하트"
								style="width: 64px; height: 64px" /> <br>
							<c:choose>
								<c:when test="${loginInfo eq null}">
									<p id="count2">000 %</p>
								</c:when>
								<c:when test="${loginInfo.member_id eq memberVO.member_id}">
									<p id="count2">000 %</p>
								</c:when>
								<c:when test="${matchingScore eq null}">
									<p id="count2">000 %</p>
								</c:when>
								<c:when test="${matchingScore ne null}">
									<p
										style="width: 100px; position: absolute; left: 75px; top: -5px; font-size: 28px; font-weight: 700; color: #000000; float: left; padding: 10px 0px; display: inline;">
										${matchingScore} %</p>
								</c:when>
								<c:otherwise>TripOrTrap</c:otherwise>
							</c:choose>
						</div>
						<style>
#count2 {
	width: 100px;
	position: absolute;
	left: 75px;
	top: -5px;
	font-size: 28px;
	font-weight: 700;
	color: #000000;
	float: left;
	padding: 10px 0px;
	display: inline;
	position: absolute;
}
</style>
						<script>
        let countBox = document.querySelector('#count'),
            count = 0;
        max_count ="${matchingScore}";
        if(Number(max_count) > 0 ){
        	max_count = Number(max_count);
        }
        let counting = setInterval(function () {
            if (count == 65535) {
                clearInterval(counting);
                return false;
            }
       		  	count += 1;
				countBox.innerHTML = new Intl.NumberFormat().format(count);
        }, 20);
    </script>



						<h2>${vo.board_title }</h2>
						<div>
							<div class="add-to-btn" style="display: inline-block;">
								<ul style="margin-left: -15px;">
									<li><a onclick="like_regist();"> <c:choose>
												<c:when test="${likeCheck eq 1 }">
													<img src="images/like.png" alt=""
														style="margin-right: 5px; width: 20px; height: 20px;"
														id="like_img">
												</c:when>
												<c:otherwise>
													<img src="images/like_gray.png" alt=""
														style="margin-right: 5px; width: 20px; height: 20px;"
														id="like_img">
												</c:otherwise>
											</c:choose>
									</a> 좋아요 <strong id="like_count">${likeCount }</strong>
									<li>
									<li><img src="images/comment.png" alt=""
										style="margin-right: 5px" id="like_img"> 리뷰 <strong>${vo.board_cnt_reply
											}</strong>
									<li>
								</ul>
							</div>
							<div class='original'>
								${fn:replace(fn:replace(vo.board_content, lf, '<br>'),
								crlf, '<br>')}
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="row" style="width: 100%; margin: 0 auto;">
				<div class="col my-5">
					<div class="card card-outline-secondary my-4">
						<div
							class="card-header d-flex justify-content-between align-items-baseline">

							<!-- ================================ 댓글 ========================================== -->
							<h2>리뷰 보기</h2>
							<c:if test="${ !empty loginInfo }">
								<a href="newreply.ca?board_sn=${vo.board_sn }"><h6>리뷰
										작성</h6></a>
							</c:if>
						</div>
						<div class="card-body">
							<c:choose>
								<c:when test="${ fn:length(review) == 0}">
									<div style="text-align: center;">
										<span>등록된&nbsp;&nbsp;댓글이&nbsp;&nbsp;없습니다</span>
									</div>
								</c:when>
								<c:when test="${ fn:length(review) != 0 }">
									<c:forEach var="reply" items="${review}" varStatus="i">
										<div class="media">
											<!-- == 프로필사진 == -->
											<div>
												<c:if test="${reply.member_filepath ne null}">
													<img
														class="rounded-circle border p-1 picture_member_profile"
														src="${reply.member_filepath}" alt="프사" />
												</c:if>
												<c:if test="${reply.member_filepath eq null}">
													<img
														class="rounded-circle border p-1 picture_member_profile"
														src="images/tot_icon_profile_none.png" alt="프사" />
												</c:if>

												<!-- ============= -->
												<!-- == 네임태그 == -->
												<div class="btn hvr-hover user_name_tag"
													onclick=" go_mypage( '${reply.member_id}' ) "
													style="border-radius: 100px;">${reply.member_nick }</div>
												<!-- ============ -->
												<!-- == 날짜 == -->
												<small class="text-muted">${reply.reply_writedate }</small>
												<!-- ========= -->

											</div>
											<!-- == 삭제 == -->
											<c:if
												test="${loginInfo.member_id eq reply.member_id || loginInfo.member_grade eq 'master' }">
												<span style=""><a
													style="font-size: 10px; color: #666666; float: right; padding: 20px 0px; position: absolute; left: 96%;"
													href="replydelete?board_sn=${vo.board_sn }&reply_sn=${reply.reply_sn}&member_id=${reply.member_id }">
														삭제 </a></span>
											</c:if>
											<!-- ========= -->
										</div>
										<div class="media-body">
											<!-- == 사진 == -->
											<div style="display: flex;">
												<c:if test="${! empty reply.picture_filepath }">
													<img class="d-block"
														style="width: 400px; height: 300px; margin: 15px 0px;"
														src="${reply.picture_filepath }" alt="NO IMAGE">
												</c:if>
												<!-- == 본문 == -->
												<div style="width: 500px; padding: 20px;">
													<p>${reply.reply_content }</p>
												</div>
												<!-- ========= -->
											</div>
											<!-- ========= -->



										</div>
										<hr>
									</c:forEach>
								</c:when>
							</c:choose>
						</div>
						<!-- ================================================================================ -->
					</div>
				</div>
			</div>
		</div>
		<!-- End Cart -->




		<!-- Start copyright  -->
		<footer>
			<div class="footer-copyright">
				<p class="footer-company">
					All Rights Reserved. &copy; 2018 <a href="#">ThewayShop</a> Design
					By : <a href="https://html.design/">html design</a>
				</p>
			</div>
			<!-- End copyright  -->

			<a href="#" id="back-to-top" title="Back to top"
				style="display: none;">&uarr;</a>

		</footer>

		<!-- ALL JS FILES -->
		<script src="js/jquery-3.2.1.min.js">
</script>
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

		<script type="text/javascript">
// 좋아요 클릭하기
$( document ).ready(function(){
   
});


$document.ready(function(){
   alert("aa");
})
function like_regist() {

      $.ajax ({
      /* 경로 형태로 url 지정 */
      url: 'set_like'            //★★
      , data : {like_fn : ${vo.function_like}, board_sn : ${vo.board_sn}}
      , dataType : 'json'
         /* 원 글의 id, 입력한 댓글을 데이터로 보냄 */
      , success : function( response ) {
         if ( response ) {   // true
            if(response.isLogin == true){
               if(response.isLike){
                  document.getElementById("like_img").src = "images/like.png";
               }else{
                  document.getElementById("like_img").src = "images/like_gray.png";
               }
               $('#like_count').text(response.count);
            }else{
               alert("로그인 후 사용 할 수 있습니다.")
            }
            
         } else   // false
            alert('좋아요 실패 등록 실패!');
      }, error : function (req, text) {
         alert (text + ':' + req.status);
      }
   });
}


window.onload = function() {

	var tag = "<p>"
		+ $div.children('.original').html().replace(/<br>/g, '\n') + "</p>"
	

	}	
	
	


</script>
</body>
</html>