<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<div>

		<!-- 댓글 등록 부분 -->
		<c:if test="${! empty loginInfo}">
			<div id='comment_regist'>
				<input type="hidden" id='board_sn' value="${boardVO.board_sn}"></input>

				<!-- ===== 글을 작성할 부분 ====================================== -->
				<textarea id='reply_content'></textarea>
				<span class='left'><strong>댓글작성</strong></span> <span class='right'><a
					class='btn-fill-s' onclick='comment_regist()'>댓글등록</a></span>
				<!-- ====================================== 글을 작성할 부분 ===== -->

			</div>
		</c:if>
		<!-- 에이잭스 안에다가 댓글수를 넣어놔야 실시간반영됨 ;; -->
		<div id='reply_list'></div>
		<input type="hidden" id='stacks' value="10"></input>
		<c:if test="${boardVO.board_cnt_reply} ge 5  ">
		</c:if>
			<div id='btn_stacks' onclick="stacks_more()">더보기</div>
	</div>

	<script type="text/javascript" src='js/file_check.js'></script>
	<script type="text/javascript">
// 댓글 등록하기	
function comment_regist() {
	if ( ${empty loginInfo } ) { // 로그인 정보가 없으면
		alert('댓글을 등록하려면 로그인하세요!');
		return;
	} else if ( $.trim( $('#reply_content').val() ) == '' ) { // 로그인은 되어 있는데 댓글을 적지 않았다면
		alert('댓글을 입력하세요!');
		$('#comment').val('');
		$('#comment').focus();
		return;
	}
	
	$.ajax ({
		/* 경로 형태로 url 지정 */
		url: 'board/comment/regist'
		, data : { board_sn :${boardVO.board_sn} , reply_content: $('#reply_content').val()}
			/* 원 글의 id, 입력한 댓글을 데이터로 보냄 */
		, success : function( response ) {
			if ( response ) {	// true
				alert('댓글이 등록되었습니다.');
				$('#reply_content').val('');
				reply_list();			// 댓글 목록 조회 요청
			} else	// false
				alert('댓글 등록 실패!');
		}, error : function (req, text) {
			alert (text + ':' + req.status);
		}
	});
}

function stacks_more(){
	 $('#stacks').val(  Number($('#stacks').val())+10 );
	reply_list();
}
// 댓글조회
function reply_list() {
	
	$.ajax({
		url : 'board/comment/list'
		 , data : { board_sn :${boardVO.board_sn} , stack:  $('#stacks').val()  }
		, success : function ( response ) {
			(stacks)+5
			$('#reply_list').html( response );
		// 성공한 결과를 #reply_list 영역에 출력하는데
		// 결과는 html 코드로 작성된 text 이므로
		// .html( response ); 형태로 값을 출력할수 있도록 지정
		}, error : function (req, text) {
			alert(text + ':' + req.status);
		}
	});
}
	</script>
	<script type="text/javascript">
$(function () { // $(document).ready() 와 같은 의미
	// 첨부된 파일이 이미지 파일인 경우 미리보기 함.
	if ( ${ ! empty boardVO.member_filepath}) {	// 첨부 파일이 있는 경우
		if ( isImage( '${boardVO.member_filepath}' ) ) {	// 이미지 파일인 경우
			$('#preview').html("<img src='${boardVO.member_filepath}' id='preview-img' />");
		}		
	}
	reply_list();		// 댓글 목록 조회 함수 호출
});

$(document).on('click', '#preview-img', function () {
	$('#popup, #popup-background').css('display', 'block');
	$('#popup').html("<img src='${vo.filepath}' class='popup' />");
}).on('click', '#popup-background', function () {
	$('#popup, #popup-background').css('display', 'none');
});

</script>

</body>
</html>