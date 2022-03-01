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
									<th> T E X T</th>
									<th></th>
								</tr>
							</thead>


							<tbody>
								<c:forEach items="${boardVO }" var="vo">

									<tr>
									<tr>
										<th class="thumbnail-img"><img
											class="rounded-circle border p-1 picture_member_profile"
											src="${vo.member_filepath}" alt="프사" /> <a
											class="btn hvr-hover" id='member_id' name='member_id'
											onclick=" go_mypage( '${vo.member_id}' ) "
											style="background: none;">${vo.member_id} <br>
												[${vo.member_grade}]
										</a> <a onclick="go_detail( '${vo.board_sn}' )"
											style="cursor: pointer"> ${vo.board_title } &nbsp [조회 :
												${vo.board_read_cnt} 댓글 : ${vo.board_cnt_reply}]</a></th>






										<th class="">
											<p style="float: right;">${vo.board_class}&nbsp | &nbsp
												${vo.board_date_create }</p>
										</th>
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