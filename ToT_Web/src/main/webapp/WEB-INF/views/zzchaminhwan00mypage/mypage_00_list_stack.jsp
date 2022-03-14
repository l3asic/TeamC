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
							<thead>
								<tr>
									<th id="whatCase_list" style="color: #bdedff;">T E X T</th>
									<th></th>
								</tr>
							</thead>


							<tbody>
								<c:forEach items="${boardVO }" var="vo">

									<tr style="height: 89px">
										<th class="thumbnail-img"><c:if
												test="${vo.member_filepath ne null}">
												<img
													class="rounded-circle border p-1 picture_member_profile"
													src="${vo.member_filepath}" alt="프사" />
											</c:if> <c:if test="${vo.member_filepath eq null}">
												<img
													class="rounded-circle border p-1 picture_member_profile"
													src="images/tot_icon_profile_none.png" alt="프사" />
											</c:if> <a class="btn hvr-hover " id='member_id' name='member_id'
											onclick=" go_mypage( '${vo.member_id}' ) "
											style="margin: 0px 5px; background: #2ba0da; color: #ffffff; border-radius: 30px;">${vo.member_id}
												[${vo.member_grade}] </a> <a
											onclick="go_detail( '${vo.board_sn}','${vo.board_class}' )"
											style="cursor: pointer"> ${vo.board_title } &nbsp [조회 :
												${vo.board_read_cnt} 댓글 : ${vo.board_cnt_reply}]</a></th>






										<th class="">
											<p style="float: right;">${vo.board_class}&nbsp | &nbsp
												${vo.board_date_create }</p>
										</th>
									</tr>
								</c:forEach>
								<tr style="text-align: center;">
									<input type="hidden" id='stacks' value="10"></input>
									<td colspan="6"><a id='btn_stacks' onclick="stacks_more()"
										class="btn hvr-hover" style="color: #ffffff">더보기</a></td>
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