<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="row my-5">
	<div class="card card-outline-secondary my-4" style="width: 100%;">
		<div class="card-header">
			<h2>댓글 : ${replyList[0].reply_cnt}</h2>

		</div>
		<div class="card-body">
			<c:forEach items="${replyList }" var="vo" varStatus="status">
				<div class="media mb-3">
					<div class="mr-2">
						<img class="rounded-circle border p-1" src="${vo.member_filepath}"
							alt="Generic placeholder image">
						<div>${vo.member_id}</div>
						<input type="hidden" id="reply_sn" value="${vo.reply_sn}"></input>
					</div>
					<div2 class="media-body">
					<p class="original">${fn:replace( fn:replace( vo.reply_content, lf, '<br>') , crlf, '<br>' )}</p>
					<div class='modify'></div>
					<small class="text-muted" style="float: right;">
						${vo.reply_writedate}</small> <c:if
						test="${loginInfo.member_id eq vo.member_id ||loginInfo.member_id eq 'master' }">
						<div class="share-bar">
							<a class='btn hvr-hover btn-modify-save' style="padding: 0px;">수정</a>
							<a class='btn hvr-hover btn-delete-cancel' style="padding: 0px;">삭제</a>

						</div>
					</c:if> </div2>
				</div>
				<hr>
			</c:forEach>
			<a id='btn_stacks' onclick="stacks_more()" class="btn hvr-hover">더보기</a>
			<a href="javascript:history.back(-1)" class="btn hvr-hover">목록으로</a>
		</div>
	</div>

</div>


<script>
	/* $(document).on('click', '.btn-modify-save', function () {
	 }) */
	$('.btn-modify-save').on(
			'click',
			function() {
				var $div = $(this).closest('div2');
				/* .closest() 메소드는 자신을 포함한 상위 요소 중에서 
				전달받은 선택자에 해당하는 요소의 집합에서 가장 첫번째 요소를 선택  */

				if ($(this).text() == '수정') {
					var tag = "<textarea style='width:96%; height:90%;'>"
							+ $div.children('.original').html().replace(
									/<br>/g, '\n') + "</textarea>"
					/* .replace(/<br>/g, '\n') 모든 <br> 태그를 엔터키를 부여 */
					$div.children('.modify').html(tag);
					// 수정 상태 (false) : 저장/취소 버튼, 보기(목록) 상태(true) : 수정/삭제 버튼
					display(false, $div);
				} else { /* JSON.stringify : JSON 형태로 만들어서 보냄 */
					$.ajax({
						// 			type : 'post'	// json방식으로 값을 보낼 땐 반드시 post 방식으로 전달
						// 			, contentType : 'application/json',
						url : 'board/comment/update',
						data : {
							reply_sn : $('input#reply_sn').val(),
							reply_content : $div.find('textarea').val()
						},
						success : function(response) {
							alert('댓글 변경' + response);
							document.location.reload()
							reply_list();

						},
						error : function(req, text) {
							alert(text + ':' + req.status);
						}
					});

				}
			});

	$('.btn-delete-cancel').on('click', function() {
		if ($(this).text() == '취소')
			display(true, $div);
		else {
			if (confirm('정말 삭제하시겠습니까?')) {
				$.ajax({
					url : 'board/comment/delete/',
					data : {
						reply_sn : $('input#reply_sn').val()
					},
					success : function() {
						alert('삭 제 완 료');
						document.location.reload()
						reply_list();
					},
					error : function(req, text) {
						alert(text + ":" + req.status);
					}
				});

			}

		}
	});

	/* 보여지는 버튼 형태와 글상자 노출 변경 */
	function display(mode, div) {
		div.find('.btn-modify-save').text(mode ? '수정' : '저장');
		div.find('.btn-delete-cancel').text(mode ? '삭제' : '취소');

		// 수정상태 : .original 안 보이게, .modify 보이게
		// 목록상태 : .original 보이게, .modify 안 보이게
		div.children('.original').css('display', mode ? 'block' : 'none');
		div.children('.modify').css('display', mode ? 'none' : 'block');
	}
</script>



