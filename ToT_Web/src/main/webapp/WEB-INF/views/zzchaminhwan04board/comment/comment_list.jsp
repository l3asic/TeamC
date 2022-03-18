<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="fn"
uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="row my-5">
	<div class="card card-outline-secondary my-4" style="width: 100%;">
		<div class="card-header">
			<h2>댓글 : ${replyList[0].reply_cnt}</h2>
		</div>
		<div class="card-body">
			<c:forEach items="${replyList }" var="vo" varStatus="status">
				<div class="media mb-3">
					<div class="mr-2">
						<!-- == 사진 == -->
						<c:if test="${vo.member_filepath ne null}">
							<img class="rounded-circle border p-1 picture_member_profile"
								src="${vo.member_filepath}" alt="프사" />
						</c:if>
						<c:if test="${vo.member_filepath eq null}">
							<img class="rounded-circle border p-1 picture_member_profile"
								src="images/tot_icon_profile_none.png" alt="프사" />
						</c:if>
						<!-- ========= -->
						<!-- == 네임태그 == -->
						<div class="btn hvr-hover user_name_tag"
							onclick=" go_mypage( '${vo.member_id}' ) "
							style="color: #ffffff; border-radius: 100px; margin: 0px 5px;">${vo.member_id}
							[${vo.member_grade}]</div>
						<!-- <input type="text" id="reply_sn" value="${vo.reply_sn}"></input> -->
					</div>
					<!-- ============ -->
					<!-- == 댓글본문 == -->
					<div2 class="media-body" style="padding-top: 17px;"
						data-seq="${vo.reply_sn}">
					<div class="original2"> ${fn:replace( fn:replace( vo.reply_content, lf, '<br> ') , crlf, '<br> ' )} </div>
					<div class='modify'></div> 
					<small class="text-muted" style="float: right; padding: 0px;">
						${vo.reply_writedate}</small>
					<!-- == 수정 삭제 == --> <c:if
						test="${loginInfo.member_id eq vo.member_id || loginInfo.member_grade eq 'master' }">
						<div class="share-bar" style="margin: -5px; float: right;">
							<a class=' hvr-hover btn-modify-save'
								style="color: #666666; background: none; font-size: 10px; cursor: pointer; padding: 0px">수정</a>
							<a class=' hvr-hover btn-delete-cancel'
								style="color: #666666; background: none; font-size: 10px; cursor: pointer; padding: 0px">삭제</a>
						</div>
					</c:if> <!-- ============= --> 
					 </div2>
					<!-- ============ -->
				</div>
				<hr>
			</c:forEach>
			<a id='btn_stacks' onclick="stacks_more()" class="btn hvr-hover"
				style="padding: 10px, 20px; font-size: 12px">더보기</a> <a
				href="javascript:history.back(-1)" class="btn hvr-hover"
				style="padding: 10px, 20px; font-size: 12px">목록으로</a>
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
					var tag = "<textarea style='width:96%; height:120%;'>"
							+ $div.children('.original2').html().replace(
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
							reply_sn : $div.data('seq'),
							reply_content : $div.find('textarea').val()
						},
						success : function(response) {
							alert('댓글이 변경 되었습니다');
							reply_list();

						},
						error : function(req, text) {
							alert('잠시후 다시 시도해주세요.');
						}
					});

				}
			});

	$('.btn-delete-cancel').on('click', function() {
		var $div = $(this).closest('div2');
		if ($(this).text() == '취소')
			display(true, $div);
		else {
			if (confirm('정말 삭제하시겠습니까?')) {
				$.ajax({
					url : "board/comment/delete/",
					data : {
						reply_sn : $div.data('seq')
					},
					success : function() {
						alert('댓글이 삭제되었습니다.');
						reply_list();
					},
					error : function(req, text) {
						alert('잠시후 다시 시도해주세요.');
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
		div.children('.original2').css('display', mode ? 'block' : 'none');
		div.children('.modify').css('display', mode ? 'none' : 'block');
	}
</script>




