<%@page import="com.hanul.study.OmrDTO"%>
<%@page import="com.hanul.study.UserDTO"%>
<%@page import="com.hanul.study.CorrectAnsDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.hanul.study.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
UserDAO dao = new UserDAO();

ArrayList<OmrDTO> m_list = dao.myAns("id");   //사용자 정답 리스트
ArrayList<CorrectAnsDTO> c_list = dao.CorrectAns();  //정답 리스트
//ArrayList<UserDTO> ox_list = dao.OXOX("id");       //OX 리스트

if(m_list.size() != 0) {
	 for(OmrDTO dto : m_list) {
		 	dto.getId();
			dto.getAnswer1();
			dto.getAnswer2();
			dto.getAnswer3();
			dto.getAnswer4();
			dto.getAnswer5();
			dto.getAnswer6();
			dto.getAnswer7();
			dto.getAnswer8();
			dto.getAnswer9();
			dto.getAnswer10();
		 }
}

if(c_list.size() != 0) {
	for(CorrectAnsDTO dto : c_list){
		dto.getCa1();
		dto.getCa2();
		dto.getCa3();
		dto.getCa4();
		dto.getCa5();
		dto.getCa6();
		dto.getCa7();
		dto.getCa8();
		dto.getCa9();
		dto.getCa10();
	}
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험 결과 보여주는 페이지</title>
</head>
<body>
<div align="center">
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제출답안</th>
			<th>정답</th>
		</tr>
	</table>
	

</div>
</body>
</html>


<jsp:forward page=".jsp"/>