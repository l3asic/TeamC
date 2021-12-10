<%@page import="java.io.PrintWriter"%>
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

if (dao.checkId(dtos) == false) { //응시자격이 없는지
	out.println("<script>alert('응시 자격이 없습니다.');");
	out.println("location.href='javascript:history.go(-1);';</script>");
	// 		response.sendRedirect("OmrMain.html");

} else { //응시자격이 있는사람들 중에서
	if (Integer.parseInt(id) == dao.checkAdmin()) { // 관리자인지
		out.println("<script>alert('관리자 모드로 진입 합니다.');");
		out.println("location.href='adminMain.jsp;';</script>");
		//		response.sendRedirect("adminMain.jsp");
	} else if (dao.checkTried(id) > 0) { //시험을 이미 봤는지
		out.println("<script>alert('이미 응시 하였습니다.');");
		out.println("location.href='OmrMain.html';</script>");
		//out.println("location.href='javascript:history.go(-1);';</script>");

		// 			out.flush();

		// 			response.sendRedirect("OmrMain.html");
	} else { //응시자격이 없지 않으면서 -> 관리자가 아니고 시험을 이미 보지않음.

		dto.setId(request.getParameter("id"));
		dtos.setName(request.getParameter("name"));

		pageContext.setAttribute("dto", dto);
	}

}
dto.setId(request.getParameter("id"));
dtos.setName(request.getParameter("name"));

pageContext.setAttribute("dto", dto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<style type="text/css">
body {
	display: flex;
	justify-content: center;
}

.omr {
	position: fixed;
	letter-spacing: 5px;
}

.check {
	background-color: #009900;
}

.btns {
	display: flex;
	justify-content: space-around;
}

.img {
	margin-right: 30px;
}
</style>

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
	<div class="img">
		<img alt="sheet" src="images/test_sheet_new.png">
	</div>

	</br>
	<form action="mark.jsp" method="post" onsubmit="return fnSubmit()"
		onreset="return fnReset()">
		<div class="omr">
			<h3 class="check">답안지 체크</h3>
			<div>
				<div>
					<label>수험번호 <input type="text" name="id"
						value=<%=request.getParameter("id")%> readonly
						style="background-color: #e2e2e2;" style="text-align: right;" /></label>
				</div>
				</br>
				<div>
					<label>01</label><input type="radio" name="input_v1" value="1"
						required="required" /> <input type="radio" name="input_v1"
						value="2" required="required" /> <input type="radio"
						name="input_v1" value="3" required="required" /> <input
						type="radio" name="input_v1" value="4" required="required" />
				</div>
				<div>
					<label>02</label><input type="radio" name="input_v2" value="1"
						required="required" /> <input type="radio" name="input_v2"
						value="2" required="required" /> <input type="radio"
						name="input_v2" value="3" required="required" /> <input
						type="radio" name="input_v2" value="4" required="required" />
				</div>
				<div>
					<label>03</label><input type="radio" name="input_v3" value="1"
						required="required" /> <input type="radio" name="input_v3"
						value="2" required="required" /> <input type="radio"
						name="input_v3" value="3" required="required" /> <input
						type="radio" name="input_v3" value="4" required="required" />
				</div>
				<div>
					<label>04</label><input type="radio" name="input_v4" value="1"
						required="required" /> <input type="radio" name="input_v4"
						value="2" required="required" /> <input type="radio"
						name="input_v4" value="3" required="required" /> <input
						type="radio" name="input_v4" value="4" required="required" />
				</div>
				<div>
					<label>05</label><input type="radio" name="input_v5" value="1"
						required="required" /> <input type="radio" name="input_v5"
						value="2" required="required" /> <input type="radio"
						name="input_v5" value="3" required="required" /> <input
						type="radio" name="input_v5" value="4" required="required" />
				</div>
				<div>
					<label>06</label><input type="radio" name="input_v6" value="1"
						required="required" /> <input type="radio" name="input_v6"
						value="2" required="required" /> <input type="radio"
						name="input_v6" value="3" required="required" /> <input
						type="radio" name="input_v6" value="4" required="required" />
				</div>
				<div>
					<label>07</label><input type="radio" name="input_v7" value="1"
						required="required" /> <input type="radio" name="input_v7"
						value="2" required="required" /> <input type="radio"
						name="input_v7" value="3" required="required" /> <input
						type="radio" name="input_v7" value="4" required="required" />
				</div>
				<div>
					<label>08</label><input type="radio" name="input_v8" value="1"
						required="required" /> <input type="radio" name="input_v8"
						value="2" required="required" /> <input type="radio"
						name="input_v8" value="3" required="required" /> <input
						type="radio" name="input_v8" value="4" required="required" />
				</div>
				<div>
					<label>09</label><input type="radio" name="input_v9" value="1"
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
			</div>
			</br>
			<div class="btns">
				<div>
					<input class="btn btn-outline-success btn-sm" type="submit"
						value="제출하기" onclick="location.href='mark.jsp'" />
				</div>
				<div>
					<input class="btn btn-outline-warning btn-sm" type="reset"
						value="초기화하기" />
				</div>
				<div>
					<input class="btn btn-outline-info btn-sm" type="button"
						value="처음으로" onclick="location.href='OmrMain.html'" />
				</div>

			</div>
		</div>
	</form>
</body>
</html>