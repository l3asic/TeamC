<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ================================================================ -->
	<script type="text/javascript">
		function reFresh() {
			mbti_list();
		}
		//목록조회
		function mbti_list() {
			// 			alert(" 스크립트 실행 테스트ㅁㅁ ");
			$.ajax({
				url : 'mbti_mbti',
				data : {
					member_id : $('#loginIngo_member_id').val()
				// 					member_id : ${loginInfo.member_id}
				},
				success : function(response) {
					$('.recommand_mbti').html(response);
				},
				error : function(req, text) {
					alert(text + ':' + req.status);
				}
			});
		}
	</script>
	<!-- ================================================================ -->
	<script type="text/javascript">
		$(function() { // $document).ready() 와 같은 의미

			mbti_list(); // 목록 조회 함수 호출
		});
	</script>
	<!-- ================================================================ -->
	<!-- 	========================== board_sn =========================== -->
	<!-- 	<form action="board_detail" method="post"> -->
	<input type="hidden" id='loginIngo_member_id'
		value="${loginInfo.member_id}"></input>
	<!-- 	</form> -->
	<!-- 	============================================================ -->
	<h3>${loginInfo.member_id}님의추천 여행지</h3>

	<div id='recommand_mbti' class="recommand_mbti"></div>

</body>
</html>