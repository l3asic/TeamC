<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



	<div class="instagram-box">
		<div class="main-instagram owl-carousel owl-theme">

			<c:forEach items="${boardVO}" var="vo" varStatus="status">
				<div class="item"  >
					<div class="ins-inner-box">
						<p style=";padding:10px 20px ;position:  absolute ; background: rgba(189, 237, 255,0.9) ; color: #333333;font-size: 30px"> ${vo.board_title}  </p>
						<p style=" border-radius : 15px ;padding: 10px ; position: absolute ; background: rgba(0,0,0,0.5) ; color: white; top: 60%; left: 30%; font-size: 25px;"> 성향일치 ${vo.matchScore } %</p>
						
					<c:if test="${vo.picture_filepath ne null}">
						<img src="${vo.picture_filepath }" alt="여행지 대표사진" style="width: 515px; height: 500px;"/>
					</c:if>
					<c:if test="${vo.picture_filepath eq null}">
						<img src="images/about-img.jpg" alt="여행지 대표사진" style="width: 515x; height: 500px;"/>
					</c:if>
						<div class="hov-in">
							<a href="detail.ca?board_sn=${vo.board_sn }"><i class="fab fa-instagram">
							<p style="font-weight: bolder;position: fixed; background: ; color:white ; top: 35%;left: 33%; display: flex;font-size:30px; align-self: center;">  <img alt="하트" src="images/like_white.png" style="width: 35px; height: 35px;    align-self: center;">${vo.function_like }</p>
						<p style="font-weight: bolder;position: fixed; background: ; color:white ; top: 35%;left: 53%; display: flex;font-size:30px; align-self: center;"><img alt="하트" src="images/ic_cmh_comment_white.png" style="width: 35px; height: 35px;    align-self: center;">${vo.board_cnt_reply } </p>
							</i></a>
						</div>
						<!-- <div style="position: absolute;"> -->
						
					<!-- </div> -->
					</div>
				</div>
			</c:forEach>

		</div>
	</div>
<script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- ALL PLUGINS -->
    <script src="js/jquery.superslides.min.js"></script>
    <script src="js/bootstrap-select.js"></script>
    <script src="js/inewsticker.js"></script>
    <script src="js/bootsnav.js."></script>
    <script src="js/images-loded.min.js"></script>
    <script src="js/isotope.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/baguetteBox.min.js"></script>
    <script src="js/form-validator.min.js"></script>
    <script src="js/contact-form-script.js"></script>
    <script src="js/custom.js"></script>