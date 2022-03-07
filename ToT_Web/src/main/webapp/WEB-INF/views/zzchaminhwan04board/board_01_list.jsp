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
	<input type="hidden" id='stacks' value="10"></input>

	<div id='board_list'></div>
	<!-- ================================================================ -->
	<script type="text/javascript" src='js/file_check.js'></script>
	<!-- ================================================================ -->
	<script type="text/javascript">
		function stacks_more() {
			$('#stacks').val(Number($('#stacks').val()) + 10);
			board_list();
		}
		// 게시물 조회
		function board_list() {
			$.ajax({
				url : 'board_list_stack',
				data : {
					board_class : 'user',
					list_cnt_many : $('#stacks').val()
				},
				success : function(response) {
					$('#board_list').html(response);
					// 성공한 결과를 #board_list 영역에 출력하는데
					// 결과는 html 코드로 작성된 text 이므로
					// .html( response ); 형태로 값을 출력할수 있도록 지정
				},
				error : function(req, text) {
					alert(text + ':' + req.status);
				}
			});
		}
	</script>
	<!-- ================================================================ -->

	<!-- ================================================================ -->
	<script type="text/javascript">
		$(function() { // $(document).ready() 와 같은 의미
			// 첨부된 파일이 이미지 파일인 경우 미리보기 함.
			board_list(); // 댓글 목록 조회 함수 호출
		});
	</script>
	<!-- ================================================================ -->
</body>