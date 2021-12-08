<%@page import="com.hanul.study.UserDAO"%>
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

	UserDAO dao = new UserDAO();
	
	dtos.setId(id);

	if (dao.checkId(dtos)) {
		if (Integer.parseInt(id) == dao.checkAdmin()) { //dtos에 관리자 id가 있는지
			response.sendRedirect("adminMain.jsp");
		} else {

			dto.setId(request.getParameter("id"));
			dtos.setName(request.getParameter("name"));

			pageContext.setAttribute("dto", dto);
		}
	} else {
		out.println("<script>alert('응시자격없음');");
		out.println("location.href='javascript:history.go(-1);';</script>");
		// 		response.sendRedirect("OmrMain.html");

	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Page</title>

<script>
	function fnSubmit() {
		if (confirm("답안지를 제출 하시겠습니까?")) {
			return true;
		}
		return false;
	}

	function fnReset() {
		var msg = "입력하신 내용이 모두 지워집니다!";
		msg += "\n계속 진행하시겠습니까?";
		if (confirm(msg)) {
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<h3>답안지 체크</h3>
	<form action="mark.jsp" method="post" onsubmit="return fnSubmit()"
		onreset="return fnReset()">
		<div>
			<label>수험번호 <input type="text" name="id"
				value=<%=request.getParameter("id")%> readonly /></label>
		</div>
		<div>
			<label>1</label><input type="radio" name="input_v1" value="1"
				required="required" /> <input type="radio" name="input_v1"
				value="2" required="required" /> <input type="radio"
				name="input_v1" value="3" required="required" /> <input
				type="radio" name="input_v1" value="4" required="required" />
		</div>
		<div>
			<label>2</label><input type="radio" name="input_v2" value="1"
				required="required" /> <input type="radio" name="input_v2"
				value="2" required="required" /> <input type="radio"
				name="input_v2" value="3" required="required" /> <input
				type="radio" name="input_v2" value="4" required="required" />
		</div>
		<div>
			<label>3</label><input type="radio" name="input_v3" value="1"
				required="required" /> <input type="radio" name="input_v3"
				value="2" required="required" /> <input type="radio"
				name="input_v3" value="3" required="required" /> <input
				type="radio" name="input_v3" value="4" required="required" />
		</div>
		<div>
			<label>4</label><input type="radio" name="input_v4" value="1"
				required="required" /> <input type="radio" name="input_v4"
				value="2" required="required" /> <input type="radio"
				name="input_v4" value="3" required="required" /> <input
				type="radio" name="input_v4" value="4" required="required" />
		</div>
		<div>
			<label>5</label><input type="radio" name="input_v5" value="1"
				required="required" /> <input type="radio" name="input_v5"
				value="2" required="required" /> <input type="radio"
				name="input_v5" value="3" required="required" /> <input
				type="radio" name="input_v5" value="4" required="required" />
		</div>
		<div>
			<label>6</label><input type="radio" name="input_v6" value="1"
				required="required" /> <input type="radio" name="input_v6"
				value="2" required="required" /> <input type="radio"
				name="input_v6" value="3" required="required" /> <input
				type="radio" name="input_v6" value="4" required="required" />
		</div>
		<div>
			<label>7</label><input type="radio" name="input_v7" value="1"
				required="required" /> <input type="radio" name="input_v7"
				value="2" required="required" /> <input type="radio"
				name="input_v7" value="3" required="required" /> <input
				type="radio" name="input_v7" value="4" required="required" />
		</div>
		<div>
			<label>8</label><input type="radio" name="input_v8" value="1"
				required="required" /> <input type="radio" name="input_v8"
				value="2" required="required" /> <input type="radio"
				name="input_v8" value="3" required="required" /> <input
				type="radio" name="input_v8" value="4" required="required" />
		</div>
		<div>
			<label>9</label><input type="radio" name="input_v9" value="1"
				required="required" /> <input type="radio" name="input_v9"
				value="2" required="required" /> <input type="radio"
				name="input_v9" value="3" required="required" /> <input
				type="radio" name="input_v9" value="4" required="required" />
		</div>
		<div>
			<label>10</label><input type="radio" name="input_v10" value="1"
				required="required" /> <input type="radio" name="input_v10"
				value="2" required="required" /> <input type="radio"
				name="input_v10" value="3" required="required" /> <input
				type="radio" name="input_v10" value="4" required="required" />
		</div>
		<div class="btns">
			<input type="submit" value="제출하기" onclick="location.href='mark.jsp'" />
			<input type="reset" value="초기화하기" /> <input type="button"
				value="처음으로" onclick="location.href='OmrMain.html'" />
		</div>
	</form>
</body>
</html>