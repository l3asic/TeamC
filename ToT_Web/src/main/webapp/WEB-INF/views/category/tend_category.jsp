<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ToT 여행지 성향 입력</title>
<style type="text/css">
table td {text-align: center; }
</style>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>


<jsp:include page="/WEB-INF/views/include/header.jsp" />
	<p class='w-pct40' style = 'margin:0 auto; text-align: right; 
				padding-top: 15px; font-size: 15px;'>(1.매우좋음, 2.좋음, 3.보통, 4.싫음, 5.매우싫음)</p>
	<form action="tend_join_category" method="post">
	<table class='w-pct60'>
		<tr>
			<th>관광 여부</th>
			<td>
				<label><input type='radio' name='mbti_tour' value='1' />1</label>
				<label><input type='radio' name='mbti_tour' value='2' />2</label>
				<label><input type='radio' name='mbti_tour' value='3' />3</label>
				<label><input type='radio' name='mbti_tour' value='4' />4</label>
				<label><input type='radio' name='mbti_tour' value='5' />5</label>
			</td>
		</tr>
		<tr>
			<th>엑티비티 참여 여부</th>
			<td>
				<label><input type='radio' name='mbti_activity' value='1' />1</label>
				<label><input type='radio' name='mbti_activity' value='2' />2</label>
				<label><input type='radio' name='mbti_activity' value='3' />3</label>
				<label><input type='radio' name='mbti_activity' value='4' />4</label>
				<label><input type='radio' name='mbti_activity' value='5' />5</label>
			</td>
		</tr>
		<tr>
			<th>축제 참여 여부</th>
			<td>
				<label><input type='radio' name='mbti_festival' value='1' />1</label>
				<label><input type='radio' name='mbti_festival' value='2' />2</label>
				<label><input type='radio' name='mbti_festival' value='3' />3</label>
				<label><input type='radio' name='mbti_festival' value='4' />4</label>
				<label><input type='radio' name='mbti_festival' value='5' />5</label>
			</td>
		</tr>
		<tr>
			<th>1인여행 선호 여부</th>
			<td>
				<label><input type='radio' name='mbti_solo' value='1' />1</label>
				<label><input type='radio' name='mbti_solo' value='2' />2</label>
				<label><input type='radio' name='mbti_solo' value='3' />3</label>
				<label><input type='radio' name='mbti_solo' value='4' />4</label>
				<label><input type='radio' name='mbti_solo' value='5' />5</label>
			</td>
		</tr>
		<tr>
			<th>커플여행 선호 여부</th>
			<td>
				<label><input type='radio' name='mbti_couple' value='1' />1</label>
				<label><input type='radio' name='mbti_couple' value='2' />2</label>
				<label><input type='radio' name='mbti_couple' value='3' />3</label>
				<label><input type='radio' name='mbti_couple' value='4' />4</label>
				<label><input type='radio' name='mbti_couple' value='5' />5</label>
			</td>
		</tr>
		<tr>
			<th>친구(2~3인)여행 선호 여부</th>
			<td>
				<label><input type='radio' name='mbti_buddys' value='1' />1</label>
				<label><input type='radio' name='mbti_buddys' value='2' />2</label>
				<label><input type='radio' name='mbti_buddys' value='3' />3</label>
				<label><input type='radio' name='mbti_buddys' value='4' />4</label>
				<label><input type='radio' name='mbti_buddys' value='5' />5</label>
			</td>
		</tr>
		<tr>
			<th>4인이상 여행 선호 여부</th>
			<td>
				<label><input type='radio' name='mbti_family' value='1' />1</label>
				<label><input type='radio' name='mbti_family' value='2' />2</label>
				<label><input type='radio' name='mbti_family' value='3' />3</label>
				<label><input type='radio' name='mbti_family' value='4' />4</label>
				<label><input type='radio' name='mbti_family' value='5' />5</label>
			</td>
		</tr>
		<tr>
			<th>선호비용(1-저비용, 5-고비용)</th>
			<td>
				<label><input type='radio' name='mbti_price' value='1' />1</label>
				<label><input type='radio' name='mbti_price' value='2' />2</label>
				<label><input type='radio' name='mbti_price' value='3' />3</label>
				<label><input type='radio' name='mbti_price' value='4' />4</label>
				<label><input type='radio' name='mbti_price' value='5' />5</label>
			</td>
		</tr>
		<tr>
			<th>정적/동적 선호 여부(1-정적, 5-동적)</th>
			<td>
				<label><input type='radio' name='mbti_sd' value='1' />1</label>
				<label><input type='radio' name='mbti_sd' value='2' />2</label>
				<label><input type='radio' name='mbti_sd' value='3' />3</label>
				<label><input type='radio' name='mbti_sd' value='4' />4</label>
				<label><input type='radio' name='mbti_sd' value='5' />5</label>
			</td>
		</tr>
		<tr>
			<th>인/아웃 선호 여부(1-인도어, 5-아웃도어)</th>
			<td>
				<label><input type='radio' name='mbti_io' value='1' />1</label>
				<label><input type='radio' name='mbti_io' value='2' />2</label>
				<label><input type='radio' name='mbti_io' value='3' />3</label>
				<label><input type='radio' name='mbti_io' value='4' />4</label>
				<label><input type='radio' name='mbti_io' value='5' />5</label>
			</td>
		</tr>
	</table>
	<input type="hidden" name="board_sn" value="${board_sn}" />
	<input type="hidden" name="tendVOchk" value="${tendVO }" />
	</form>	
	<div style="text-align: center; margin-top: 10px">
		<a class='btn btn-outline-primary' onclick="go_tend()">저장</a>
		<a class='btn btn-outline-warning' href='welcome' >취소</a>
	</div>	
	
	<script type="text/javascript">
	$(function() { 
		if( $('input[name=tendVOchk]').val() != null ){
// 		var mbti_tour = ${tendVO.mbti_tour};
// 		var mbti_activity = ${tendVO.mbti_activity};
// 		var mbti_festival =${tendVO.mbti_festival};
// 		var mbti_solo = ${tendVO.mbti_solo};
// 		var mbti_couple = ${tendVO.mbti_couple};
// 		var mbti_buddys = ${tendVO.mbti_buddys};
// 		var mbti_family =${tendVO.mbti_family};
// 		var mbti_price =${tendVO.mbti_price};
// 		var mbti_sd = ${tendVO.mbti_sd};
// 		var mbti_io = ${tendVO.mbti_io};
		$("input:radio[name ='mbti_tour']:input[value=${tendVO.mbti_tour}]").attr("checked", true);
		$("input:radio[name ='mbti_activity']:input[value=${tendVO.mbti_activity}]").attr("checked", true);
		$("input:radio[name ='mbti_festival']:input[value=${tendVO.mbti_festival}]").attr("checked", true);
		$("input:radio[name ='mbti_solo']:input[value=${tendVO.mbti_solo}]").attr("checked", true);
		$("input:radio[name ='mbti_couple']:input[value=${tendVO.mbti_couple}]").attr("checked", true);
		$("input:radio[name ='mbti_buddys']:input[value=${tendVO.mbti_buddys}]").attr("checked", true);
		$("input:radio[name ='mbti_family']:input[value=${tendVO.mbti_family}]").attr("checked", true);
		$("input:radio[name ='mbti_price']:input[value=${tendVO.mbti_price}]").attr("checked", true);
		$("input:radio[name ='mbti_sd']:input[value=${tendVO.mbti_sd}]").attr("checked", true);
		$("input:radio[name ='mbti_io']:input[value=${tendVO.mbti_io}]").attr("checked", true);
		}
		});
	
	function go_tend() {
		var board_sn = Number($('input[name=board_sn]').val());
		var mbti_tour = $('input[name=mbti_tour]').val();
		var mbti_activity = $('input[name=mbti_activity]').val();
		var mbti_festival = $('input[name=mbti_festival]').val();
		var mbti_solo = $('input[name=mbti_solo]').val();
		var mbti_couple = $('input[name=mbti_couple]').val();
		var mbti_buddys = $('input[name=mbti_buddys]').val();
		var mbti_family = $('input[name=mbti_family]').val();
		var mbti_price = $('input[name=mbti_price]').val();
		var mbti_sd = $('input[name=mbti_sd]').val();
		var mbti_io = $('input[name=mbti_io]').val();
		
		$('form').submit();
	}
	
	</script>
</body>
</html>





