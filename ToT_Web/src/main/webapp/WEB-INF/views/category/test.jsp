<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<meta name="keywords" content="">
<meta name="description" content="">
<meta name="author" content="">

<title>홈 메인화면</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	
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
	
		<!-- Start Shop Page  -->

		<div class="container">
			<div class="row">
				<div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
					<div class="right-product-box">
						<div class="product-item-filter row categoryValue">
							액티비티
							
						</div>
						<div class="product-categorie-box">
							<div class="tab-content">
								<div role="tabpanel" class="tab-pane fade show active" id="grid-view" style="align-content: center;">
									<div class="row">
										<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
											<div class="products-single fix">
												<div class="box-img-hover">
													<img src="${vo.picture_filepath }" class="img-fluid" alt="Image">
												</div>
												<div class="why-text">
													<h4>${vo.board_title }</h4>
													<div class="list-sub">
														<ul>
															<li><img src="images/like.png" alt="">
																<h5>좋아요</h5>
																<h5>${vo.function_like }</h5></li>
														</ul>
													</div>
												</div>
											</div>
										</div>
										<c:forEach var="vo" items="${vo }">
											<div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
												<div class="products-single fix">
													<div class="box-img-hover">
														<a href="#">
														<%-- <img src="${vo.picture_filepath }" class="img-fluid">
															<c:if test="${empty vo.picture_filepath }">
																<img src="images/no_image.png" class="img-fluid" alt="NO IMAGE">
															</c:if> --%>
															
														<c:choose>
															<c:when test="${ !empty vo.picture_filepath }">
															<img src="${vo.picture_filepath }" class="img-fluid">
															</c:when>
															<c:otherwise>
															<img src="images/no_image.png" class="img-fluid" alt="NO IMAGE">
															</c:otherwise>
														</c:choose>
														</a>
													</div>
													<!-- <div class="why-text"> -->
													<a href="#"><h4>${vo.board_title }</h4></a>
													<div class="list-sub"  style="list-style-type: none">
														<ul>
															<li><img src="images/like.png" alt="">
																<h5>${vo.function_like }</h5></li>
														</ul>
													</div>
													<!-- </div> -->
												</div>
											</div>

										</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div>
					</div>
				</div>
				
		</div>

	<!-- End Shop Page -->
	
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>