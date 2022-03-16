<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToT 회원가입</title>
<style type="text/css">
table tr td {text-align: left;}
.addr input {margin-bottom: 5px;}
.valid, .invalid {font-size: 13px; font-weight: bold; font-style: italic;}
.valid { color : green; }
.invalid {color : red; }
</style>
<link rel="stylesheet" type="text/css" href="css/common.css">

</head>
<body>
<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<p class='w-pct40' style = 'margin:0 auto; text-align: right; 
				padding-bottom: 10px; font-size: 12px;'>* 은 필수 입력 항목입니다.</p>
	<form action="join" method="post">
	<table class='w-pct40'>
		<tr>
			<th class='w-px120'>*성명</th>
			<td><input type='text' name='member_name' /> </td>
		</tr>
		<tr>
			<th>*아이디</th>
			<td><input type='text' name='member_id' class='chk' />
				<a class='btn-fill-s' id='btn-id'>아이디 중복확인</a><br/>
				<div class='valid'>아이디를 입력하세요(영문소문자, 숫자만 입력 가능)</div>
			</td>
		</tr>
		<tr>
			<th>*비밀번호</th>
			<td>
				<input type='password' name='member_pw' class='chk' />
				<div class='valid'>비밀번호를 입력하세요(영문대/소문자, 숫자를 모두 포함)</div>
			</td>
		</tr>
		<tr>
			<th>*비밀번호확인</th>
			<td>
				<input type='password' name='pw_ck' class='chk' />
				<div class='valid'>비밀번호를 다시 입력하세요.</div>
			</td>
		</tr>
		<tr>
			<th>*닉네임</th>
			<td><input type='text' name='member_nick' class='chk' />
				<a class='btn-fill-s' id='btn-nick'>닉네임 중복확인</a><br/>
				<div class='valid'>닉네임을 입력하세요</div>
			</td>
		</tr>
		<tr>
			<th>*성별</th>
			<td>
				<label><input type='radio' name='member_gender' value='남성' />남</label>
				<label><input type='radio' name='member_gender' value='여성' checked />여</label>
			</td>
		</tr>
		<tr>
			<th>*이메일</th>
			<td>
				<input type='text' name='member_email' class='chk' />
				<div class='valid'>이메일을 입력하세요</div>				
			</td>
		</tr>
		
		<tr>
			<th>*전화번호</th>
			<td>
				<input type='text' name='member_tel' maxlength="3" />
				- <input type='text' name='member_tel' maxlength="4" />
				- <input type='text' name='member_tel' maxlength="4" />
			</td>
		</tr>
		<tr>
			<th>주소</th>
			<td class='addr'><a class='btn-fill-s' onclick='daum_post()'>우편번호 찾기</a>
				<input type='text' name='post' readonly /> <br/>
				<input type='text' name='addr' readonly /> <br/>
				<input type='text' name='addr' />
			</td>
		</tr>
	</table>	
	</form>
	<div style="text-align: center; margin-top: 10px">
		<a class='btn btn-outline-primary' onclick="go_join()">회원가입</a>
		<a class='btn btn-warning' href='<c:url value="home" />' >취소</a>
	</div>
	<script type="text/javascript" src="js/join_check.js"></script>
	<script>
	
	function go_join() {
		if ($('[name=member_name]').val() == '') {
			// alert('성명 입력');
			$('[name=member_name]').focus();
			return;
		}
		
		// 중복확인을 하여 이미 사용 중인 경우
		if ($('[name=member_id]').hasClass('checked') ) {
			if ( ($('[name=member_id]').siblings('div').hasClass('invalid'))  ) {
				alert('회원 가입 불가! \n' + join.member_id.unUsable.desc);
				$('[name=member_id]').focus();
				return;
			}
		} else {
			// 중복확인 하지 않은 경우
			if ( ! item_check ($('[name=member_id]'))  ) return;
			else {
				alert('회원 가입 불가! \n' + join.member_id.valid.desc);
				$('[name=member_id]').focus();
				return;
			}
		}
		
		if ($('[name=member_nick]').hasClass('checked') ) {
			if ( ($('[name=member_nick]').siblings('div').hasClass('invalid'))  ) {
				alert('회원 가입 불가! \n' + join.member_nick.unUsable.desc);
				$('[name=member_nick]').focus();
				return;
			}
		} else {
			// 중복확인 하지 않은 경우
			if ( ! item_check ($('[name=member_nick]'))  ) return;
			else {
				alert('회원 가입 불가! \n' + join.member_nick.valid.desc);
				$('[name=member_nick]').focus();
				return;
			}
		}
		//if ( ! item_check ( $('[name=nick]')) ) return; 
		if ( ! item_check ( $('[name=member_pw]')) ) return; 
		if ( ! item_check ( $('[name=pw_ck]')) ) return; 
		if ( ! item_check ( $('[name=member_email]')) ) return; 
		
		$('form').submit();
		
	}
	
	// 각 유효성 검사 항목을 체크할 함수
	function item_check( item ) {
		var data = join.tag_status( item );
		if ( data.code == 'invalid' ) {
			alert('회원 가입 불가! \n' + data.desc );
			item.focus();
			return false;
		} else return true;
	}
	
	
	function daum_post() {
	    new daum.Postcode({
	        oncomplete: function( response) {
	            // 조회된 우편번호를 입력하기 위한 제이쿼리 선언
	            // name이 post 인 태그의 val(값)을 받아온 변수(response) 내 zonecode 값을 담음
	            $('[name=post]').val( response.zonecode )
	            // 검색된 기본 주소 타입: R(도로명), J(지번)
	            var addr = response.userSelectType == 'J' ? response.jibunAddress : response.roadAddress;
	            
	            if ( response.buildingName != '' ) addr += '(' + response.buildingName + ')'; 
	            
	            // name 이 addr 인 태그의 0번지에 값을 할당
	            $('[name=addr]').eq(0).val( addr );
	        }
	    }).open();
	}
	</script>
	
	<script src="https://code.jquery.com/ui/1.13.0/jquery-ui.js"></script>
	  <script>
	  // class=chk 에 대한 유효성 검사
	  $('.chk').on('keyup', function (e) {
		  
		// id 입력 후 Enter 키를 누르면 아이디 중복확인 버튼 실행
		if ($(this).attr('name') == 'member_id') {
			if(e.keyCode==13) id_check();
			else $(this).removeClass('checked');
		}
		var data = join.tag_status ( $(this) ); // 입력하고 있는 tag의 값을 data 에 할당
		// 반환된 결과값(data)엔 code와 desc 가 있음.
		$(this).siblings('div').text(data.desc).removeClass().addClass(data.code);
	});
	  
	  
	 
	  // 아이디 중복확인 버튼 클릭시
	  $('#btn-id').on('click', function () {
			id_check();
	});
	  
	  function id_check() {
		var $member_id = $('[name=member_id]');
		// class 에 'checked'가 있다면 호출한 곳으로 리턴
		if ($member_id.hasClass('checked')) return;
		
		var data = join.tag_status($member_id);
		if ( data.code == 'invalid') {
			alert ('아이디 중복확인 불필요\n' + data.desc);
			$member_id.focus();
			return;
		}
		// DB에서 id 값을 가져와 중복 여부 확인
		$.ajax({
			url : 'id_check'
			, data : {member_id:$member_id.val()}
			, success : function ( response ) { // true : 사용 가능 / false : 이미 사용 중
				var data = join.member_id_usable( response );		// 성공시 값이 있으면
				$member_id.siblings('div').text( data.desc ).removeClass().addClass( data.code );
				$member_id.addClass('checked');
			}, error : function (req, text) {
				alert(text + ':' + req.status);
			}
		});
	}
	  
	  // 닉네임 중복확인 버튼 클릭시
	  $('#btn-nick').on('click', function () {
			nick_check();
	});
	  
	  function nick_check() {
		var $member_nick = $('[name=member_nick]');
		// class 에 'checked'가 있다면 호출한 곳으로 리턴
		if ($member_nick.hasClass('checked')) return;
		
		var data = join.tag_status($member_nick);
		if ( data.code == 'invalid') {
			alert ('닉네임 중복확인 불필요\n' + data.desc);
			$member_nick.focus();
			return;
		}
		// DB에서 nick 값을 가져와 중복 여부 확인
		$.ajax({
			url : 'nick_check'
			, data : {member_nick:$member_nick.val()}
			, success : function ( response ) { // true : 사용 가능 / false : 이미 사용 중
				var data = join.member_nick_usable( response );		// 성공시 값이 있으면
				$member_nick.siblings('div').text( data.desc ).removeClass().addClass( data.code );
				$member_nick.addClass('checked');
			}, error : function (req, text) {
				alert(text + ':' + req.status);
			}
		});
	}
	  
	  </script>
	
</body>
</html>









