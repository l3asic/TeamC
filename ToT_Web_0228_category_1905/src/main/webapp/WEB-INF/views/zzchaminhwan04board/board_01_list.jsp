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
	<h3>방명록</h3>
	<div id='list-top'>
		<form action="board_detail" method="post">
		<input type="hidden" name="board_sn"></input>
			<table border="1" class="container">
				<tbody>
					<!-- 조회된 목록이 없을 경우 정보 표시 -->
					<c:if test="${ empty boardVO }">
						<tr>
							<td colspan="6">방명록 정보가 없습니다.</td>
						</tr>
					</c:if>
					<!-- 조회된 목록이 있을 경우 정보 표시 -->
					<c:forEach items="${boardVO }" var="vo">
						<div class="list-group">
							<a onclick='go_detail(${vo.board_sn})'
								class="list-group-item list-group-item-action d-flex gap-3 py-3"
								aria-current="true"> <img src="${vo.member_filepath}"
								alt="twbs" width="32" height="32"
								class="rounded-circle flex-shrink-0">
								<div class="d-flex gap-2 w-100 justify-content-between">
									<div>
										<p class="mb-0">${empty vo.member_filepath ? '사진없음' : '외않됌'  }</p>
									</div>
									<div>
										<h3 class="mb-0">글제목 : ${vo.board_title }</h3>
										<p class="mb-0 opacity-75">작성 : ${vo.member_id}</p>
									</div>
									<div>
										<p class="mb-0 opacity-75">게시판 : ${vo.board_class}</p>
										<p class="mb-0">조회수 : ${vo.board_read_cnt }</p>
									</div>
									<small class="opacity-50 text-nowrap">${vo.board_date_create }</small>

								</div>
							</a>
						</div>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<div class='btnSet'></div>
	<script type="text/javascript">
		function go_detail(board_sn) {
			$('[name = board_sn]').val(board_sn);
			$('form').attr('action', 'board_detail');
			$('form').submit();
		}
	</script>
</body>