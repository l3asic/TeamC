<%@ page import="com.hanul.study.MemberDTO"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.hanul.study.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <jsp:useBean id="dao" class="com.hanul.study.MemberDAO"/> --%>
<%
MemberDAO dao = new MemberDAO();
ArrayList<MemberDTO> list = dao.searchAllMember();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP06</title>
<script type="text/javascript">
function fnDelete(id){
	//alert("id : " + id);
	if(confirm("정말 삭제하시겠습니까?")){
		location.href = "jsp07.jsp?id=" + id;
	}
}
</script>
</head>
<body>
<div align="center">
<h3>[전체회원 목록보기]</h3>
<table border="1">
	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>비밀번호</th>
		<th>나이</th>
		<th>주소</th>
		<th>전화번호</th>
		<th>삭제</th>
		<th>수정</th>
	</tr>
	
	<%-- 단순 for문을 이용한 출력
	<%for(int i = 0; i < list.size(); i++){ %>
		<tr align="center">
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getId() %></td>
			<td><%= list.get(i).getPw() %></td>
			<td><%= list.get(i).getAge() %></td>
			<td><%= list.get(i).getAddr() %></td>
			<td><%= list.get(i).getTel() %></td>
		</tr>	
	<%}//for %>
	--%>
	
	<%-- 향상된 for문을 이용한 출력 --%>
	<%if(list.size() == 0){ %>
		<tr align="center">
			<td colspan="8">등록된 회원목록이 없습니다!</td>
		</tr>
	<%}else{ %>
		<%for(MemberDTO dto : list){ %>
			<tr align="center">
				<td><%= dto.getName() %></td>
				<td><%= dto.getId() %></td>
				<td><%= dto.getPw() %></td>
				<td><%= dto.getAge() %></td>
				<td><%= dto.getAddr() %></td>
				<td><%= dto.getTel() %></td>
				<%-- <td><a href="jsp07.jsp?id=<%=dto.getId()%>">삭제</a></td> --%>
				<%-- <td><button onclick="location.href='jsp07.jsp?id=<%=dto.getId()%>'">삭제</button></td> --%>
				<td><input type="button" value="삭제" onclick="fnDelete('<%=dto.getId()%>')"/></td>
				<td><input type="button" value="수정" onclick="location.href='jsp08.jsp?id=<%=dto.getId()%>'"></td>
			</tr>
		<%}//for %>
	<%}//if %>
	
	<tr align="center">
		<td colspan="8">
			<input type="button" value="회원가입" onclick="location.href='jsp05Main.html'"/>
		</td>
	</tr>
</table>
</div>
</body>
</html>
