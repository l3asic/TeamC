<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.OmrDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String name = request.getParameter("name");

OmrDTO dto = new OmrDTO();
UserDTO dtos = new UserDTO();

dto.setId(request.getParameter("id"));
dtos.setName(request.getParameter("name"));

pageContext.setAttribute("dto", dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Page</title>
<script>
function fnSubmit(){
	if(confirm("답안지를 제출 하시겠습니까?")){
		return true;
	}
	return false;
}

function fnReset(){
	var msg = "입력하신 내용이 모두 지워집니다!";
	msg += "\n계속 진행하시겠습니까?";
	if(confirm(msg)){
		return true;
	}
	return false;
}
</script>
</head>
<body>
	<h3>답안지 체크</h3>
	<form action="mark.jsp" method="post" onsubmit="return fnSubmit()" onreset="return fnReset()">
		<div>
			<label <input type="text" name="id" value="request.getParameter('id')" />><%=request.getParameter("id") %></label>
		</div>
		<div>
			<label>1</label><input type="radio" name="input_v1" value="1" required="required" />
							<input type="radio" name="input_v1" value="2" required="required" />
							<input type="radio" name="input_v1" value="3" required="required" />
							<input type="radio" name="input_v1" value="4" required="required" />
		</div>
		<div>
			<label>2</label><input type="radio" name="input_v2" value="1" required="required" />
							<input type="radio" name="input_v2" value="2" required="required" />
							<input type="radio" name="input_v2" value="3" required="required" />
							<input type="radio" name="input_v2" value="4" required="required" />
		</div>
		<div>
			<label>3</label><input type="radio" name="input_v3" value="1" required="required" />
							<input type="radio" name="input_v3" value="2" required="required" />
							<input type="radio" name="input_v3" value="3" required="required" />
							<input type="radio" name="input_v3" value="4" required="required" />
		</div>
		<div>
			<label>4</label><input type="radio" name="input_v4" value="1" required="required" />
							<input type="radio" name="input_v4" value="2" required="required" />
							<input type="radio" name="input_v4" value="3" required="required" />
							<input type="radio" name="input_v4" value="4" required="required" />
		</div>
		<div>
			<label>5</label><input type="radio" name="input_v5" value="1" required="required" />
							<input type="radio" name="input_v5" value="2" required="required" />
							<input type="radio" name="input_v5" value="3" required="required" />
							<input type="radio" name="input_v5" value="4" required="required" />
		</div>
		<div>
			<label>6</label><input type="radio" name="input_v6" value="1" required="required" />
							<input type="radio" name="input_v6" value="2" required="required" />
							<input type="radio" name="input_v6" value="3" required="required" />
							<input type="radio" name="input_v6" value="4" required="required" />
		</div>
		<div> 
			<label>7</label><input type="radio" name="input_v7" value="1" required="required" />
							<input type="radio" name="input_v7" value="2" required="required" />
							<input type="radio" name="input_v7" value="3" required="required" />
							<input type="radio" name="input_v7" value="4" required="required" />
		</div>
		<div>
			<label>8</label><input type="radio" name="input_v8" value="1" required="required" />
							<input type="radio" name="input_v8" value="2" required="required" />
							<input type="radio" name="input_v8" value="3" required="required" />
							<input type="radio" name="input_v8" value="4" required="required" />
		</div>
		<div>
			<label>9</label><input type="radio" name="input_v9" value="1" required="required" />
							<input type="radio" name="input_v9" value="2" required="required" />
							<input type="radio" name="input_v9" value="3" required="required" />
							<input type="radio" name="input_v9" value="4" required="required" />
		</div>
		<div>
			<label>10</label><input type="radio" name="input_v10" value="1" required="required" />
							<input type="radio" name="input_v10" value="2" required="required" />
							<input type="radio" name="input_v10" value="3" required="required" />
							<input type="radio" name="input_v10" value="4" required="required" />
		</div>
		<div class="btns">
				<input type="submit" value="제출하기" onclick="location.href='mark.jsp'"/>
				<input type="reset" value="초기화하기"/>
			</div>
</body>
</html>