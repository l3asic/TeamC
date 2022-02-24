<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="">
	<h3>방명록</h3>
	<div id='list-top'>
		<form action="list.bo" method="post">
			<input type="hidden" name="curPage" value="1" /> <input
				type="hidden" name="id" />
			<%-- <div>
		<!-- 검색 처리 -->
		<ul>
			<li>
				<select name="search" class='w-px90'>
					<option value="all" ${page.search eq 'all' ? 'selected' : '' }>전체</option>
					<option value="title" ${page.search eq 'title' ? 'selected' : '' }>제목</option>
					<option value="content" ${page.search eq 'content' ? 'selected' : '' }>내용</option>
					<option value="writer" ${page.search eq 'writer' ? 'selected' : '' }>작성자</option>
				</select>			
			</li>
			<li><input type='text' name='keyword' value="${page.keyword }" class='w-px300' /></li>
			<li><a class='btn-fill' onclick='$("form").submit()'>검색</a></li>		
		</ul>		
		<ul>
			<li>
				<select name='pageList' class='w-px90' onchange="$('form').submit()">
					<option value="10" ${page.pageList eq 10 ? 'selected' : '' }>10개씩</option>
					<option value="15" ${page.pageList eq 15 ? 'selected' : '' }>15개씩</option>
					<option value="20" ${page.pageList eq 20 ? 'selected' : '' }>20개씩</option>
					<option value="25" ${page.pageList eq 25 ? 'selected' : '' }>25개씩</option>
					<option value="30" ${page.pageList eq 30 ? 'selected' : '' }>30개씩</option>			
				</select>
			</li>
		
			<li>
				<select name="viewType" onchange="$('form').submit()">
					<option value="list" ${page.viewType eq 'list' ? 'selected' : '' }>리스트 형태</option>
					<option value="grid" ${page.viewType eq 'grid' ? 'selected' : '' }>그리드 형태</option>						
				</select>
			</li>
			<!-- 로그인되어 있는 경우 글쓰기 기능 -->
			<c:if test="${not empty loginInfo }">
				<li><a class='btn-fill' href='new.bo'>글쓰기</a></li>
			</c:if>
		</ul>
	</div> --%>
		</form>
	</div>
	<div id='data-list'>

		<!-- 그리드 형태 -->
		<%-- <c:if test="${page.viewType eq 'grid'}"><!-- viewType 값이 'grid' 이면 그리드형태를 나타냄 -->
	<ul class='grid'>
		<c:forEach items="${page.list }" var="vo">
			<li>
				<div><a onclick='go_detail(${vo.id})'>${vo.title }</a></div>
				<div>${vo.name }</div>
				<div>${vo.writedate } [${vo.readcnt }] <span style="float: right;">${empty vo.filename ? '' : "<img src='imgs/attach.png' class='file-img' />" }</span> </div>
			</li>
		</c:forEach>
	</ul>
</c:if> --%>

		<!-- 목록 형태 -->
		<%-- <c:if test="${page.viewType eq 'list'}">	<!-- viewType 값이 'list' 이면 목록 형태를 나타냄 --> --%>
		<table border="1" class="container">
			<!-- 			<thead>
				<tr class="row">
					<th class="col-lg-4 col-md-4 col-sm-12 col-xs-12">번호</th>
					<th class="col-lg-4 col-md-4 col-sm-12 col-xs-12">제목</th>
					<th class="col-lg-4 col-md-4 col-sm-12 col-xs-12">프로필사진</th>
					<th class="col-lg-4 col-md-4 col-sm-12 col-xs-12">작성자</th>
					<th class="col-lg-4 col-md-4 col-sm-12 col-xs-12">작성일자</th>
					<th class="col-lg-4 col-md-4 col-sm-12 col-xs-12">조회수</th>
				</tr>
			</thead> -->
			<tbody>
				<!-- 조회된 목록이 없을 경우 정보 표시 -->
				<c:if test="${ empty boardVO }">
					<tr>
						<td colspan="6">방명록 정보가 없습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${boardVO }" var="vo">
					<div class="list-group">
						<a href="board_detail"
							class="list-group-item list-group-item-action d-flex gap-3 py-3"
							aria-current="true"> <img src="${vo.member_filepath}"
							alt="twbs" width="32" height="32"
							class="rounded-circle flex-shrink-0">
							<div class="d-flex gap-2 w-100 justify-content-between">
								<div>
									<p class="mb-0">${empty vo.member_filepath ? '사진없음' : '외않됌'  }
									
									</p>
								</div>
								<div>
									<h3 class="mb-0">글제목 : ${vo.board_title }</h3>
									<p class="mb-0 opacity-75">작성 : ${vo.member_id}</p>
								</div>
								<div>
									<p class="mb-0 opacity-75">분류 : ${vo.board_class}</p>
									<p class="mb-0">조회수 : ${vo.board_read_cnt }</p>
								</div>

								<small class="opacity-50 text-nowrap">${vo.board_date_create }</small>
							</div>
						</a>
					</div>
					<%-- 					<tr class = "row">
						<td class="col-lg-4 col-md-4 col-sm-12 col-xs-12">${vo.board_sn }</td>
						<td class="col-lg-4 col-md-4 col-sm-12 col-xs-12"><a onclick='go_detail(${vo.board_sn})'>${vo.board_title }</a></td>
						<td class="col-lg-4 col-md-4 col-sm-12 col-xs-12">${empty vo.member_filepath ? '<img src="images/img-1.jpg" alt=""  width="30dp" height="30dp" >' : '사진있음' }</td>
						<td class="col-lg-4 col-md-4 col-sm-12 col-xs-12">${vo.member_id }</td>
						<td class="col-lg-4 col-md-4 col-sm-12 col-xs-12">${vo.board_date_create }</td>
						<td class="col-lg-4 col-md-4 col-sm-12 col-xs-12">${vo.board_read_cnt }</td>
					</tr> --%>
				</c:forEach>
			</tbody>
			<!-- 			<tfoot>
				<tr>
					<td colspan="5">꽝</td>
				</tr>
			</tfoot> -->
		</table>
		<%-- </c:if> --%>
	</div>
	<div class='btnSet'>
		<%-- 	<jsp:include page="/WEB-INF/views/include/page.jsp" /> --%>
	</div>

	<script type="text/javascript">
		function go_detail(id) {
			$('[name=id]').val(id);
			$('form').attr('action', 'detail.bo');
			$('form').submit();
		}
	</script>

</body>