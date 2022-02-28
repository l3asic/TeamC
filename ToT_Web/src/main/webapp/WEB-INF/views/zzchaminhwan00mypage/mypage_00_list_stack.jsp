<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="">


	<div class='btnSet'></div>

	<!-- Start Wishlist  -->
	<div class="wishlist-box-main">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="table-main table-responsive">
						<table class="table">
<!-- 							========================== board_sn =========================== -->
<!-- 							<form action="board_detail" method="post"> -->
<!-- 								<input type="text" name='board_sn' value=""></input> -->
<!-- 							</form> -->
<!-- 							============================================================ -->
							<thead>
								<tr>
									<th>Images</th>
									<th>제목</th>
									<th>작성자</th>
									<th>게시판</th>
									<th></th>
									<th style="text-align: center;"></th>
								</tr>
							</thead>


							<tbody>
								<c:forEach items="${boardVO }" var="vo">

									<tr>

										<td class="thumbnail-img"><img class="img-fluid"
											src="${vo.member_filepath}" alt="프사" /></td>

										<td class="   name-pr">
											<div>
												<a class=" list-group-item-action"
													onclick='go_detail(${vo.board_sn})'>${vo.board_title }
												</a>

											</div>
										</td>
										<td class="price-pr"><a class="btn hvr-hover"
											id='member_id' name='member_id'
											onclick=" go_mypage( '${vo.member_id}' ) ">${vo.member_id}</a>
											<p>${vo.member_grade}</p></td>
										<td class="quantity-box">${vo.board_class}</td>
										<td class="add-pr">
											<p>조회수 : ${vo.board_read_cnt}</p>
											<p>댓글수 : ${vo.board_cnt_reply}</p>
										</td>
										<td class="remove-pr">${vo.board_date_create }</td>

									</tr>
								</c:forEach>
								<tr style="text-align: center;">
									<input type="hidden" id='stacks' value="10"></input>
									<td colspan="6"><a id='btn_stacks' onclick="stacks_more()"
										class="btn hvr-hover">더보기</a></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End Wishlist -->

</body>