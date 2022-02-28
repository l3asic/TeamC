<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



	<div class="instagram-box">
		<div class="main-instagram owl-carousel owl-theme">

			<c:forEach items="${boardVO}" var="vo" varStatus="status">
				<div class="item">
					<div class="ins-inner-box">
						<p style="background: #ffffff"> ${status.index +1} 순위  </p>
						<img src="images/instagram-img-01.jpg" alt="" />
						<div class="hov-in">
							<a href="#"><i class="fab fa-instagram"></i></a>
						</div>
						<p style="background: #ffffff">|| ${vo.matchScore } 점짜리 추천여행지 || => ${vo.board_title } </p>
						<p style="background: #ffffff">댓글 : ${vo.function_like } || ♥ ${vo.board_cnt_reply }</p>
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