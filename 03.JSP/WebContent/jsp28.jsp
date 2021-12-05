<%@page import="com.hanul.study.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//jsp27.jsp에서 넘겨준 바인딩(연결) 객체를 받는다
request.setCharacterEncoding("utf-8");
String[] studyJSP = (String[]) request.getAttribute("study");
ArrayList<String> listJSP = (ArrayList<String>) request.getAttribute("list");
MemberDTO dtoJSP = (MemberDTO) request.getAttribute("dto");
ArrayList<MemberDTO> mlistJSP = (ArrayList<MemberDTO>) request.getAttribute("mlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP28</title>
</head>
<body>
[배열을 목록을 출력(JAVA)-1]<br/>
<%for(int i = 0; i < studyJSP.length; i++){ %>
studyJSP[] 배열의 <%=i %>번지(인덱스) 값 : <%=studyJSP[i] %><br/>
<%}//for %>
<br/>

[배열을 목록을 출력(JAVA)-2]<br/>
<%
for(int i = 0; i < studyJSP.length; i++){
	out.println("studyJSP[] 배열의 " + i + "번지(인덱스) 값 : " + studyJSP[i] + "<br/>");
}//for
%>
<br/>

[배열을 목록을 출력(EL)]<br/>
study[] 배열의 0번지(인덱스) 값 : ${study[0]}<br/>
study[] 배열의 1번지(인덱스) 값 : ${study[1]}<br/>
study[] 배열의 2번지(인덱스) 값 : ${study[2]}<br/>
study[] 배열의 3번지(인덱스) 값 : ${study[3]}<br/>
study[] 배열의 4번지(인덱스) 값 : ${study[4]}<br/>
study[] 배열의 5번지(인덱스) 값 : ${study[5]}<br/>
study[] 배열의 6번지(인덱스) 값 : ${study[6]}<br/>
study[] 배열의 7번지(인덱스) 값 : ${study[7]}<br/>
<br/>

[ArrayList의 목록을 출력(JAVA)]<br/>
<%
for(String str : listJSP){
	out.println("listJSP의 값 : " + str + "<br>");
}
%>
<br/>

[ArrayList의 목록을 출력(EL)]<br/>
list의 값 : ${list[0]}<br/>
list의 값 : ${list[1]}<br/>
list의 값 : ${list[2]}<br/>
list의 값 : ${list[3]}<br/>
list의 값 : ${list[4]}<br/>
<br/>

[바인딩객체(dtoJSP)의 내용을 출력(JAVA)]<br/>
이름 : <%= dtoJSP.getName() %><br/>
아이디 : <%= dtoJSP.getId() %><br/>
비밀번호 : <%= dtoJSP.getPw() %><br/>
나이 : <%= dtoJSP.getAge() %><br/>
주소 : <%= dtoJSP.getAddr() %><br/>
전화번호 : <%= dtoJSP.getTel() %><br/>
<br/>

[바인딩객체(dto)의 내용을 출력(EL)]<br/>
이름 : ${dto.name }<br/>
아이디 : ${dto.id }<br/>
비밀번호 : ${dto.pw }<br/>
나이 : ${dto.age }<br/>
주소 : ${dto.addr }<br/>
전화번호 : ${dto.tel }<br/>
<br/>

[리스트 구조에 객체가 저장된 객체배열(mlistJSP)의 내용을 출력(JAVA)]<br/>
<%
for(MemberDTO dto : mlistJSP){
	out.println(dto.getName() + ", " + dto.getId() + ", " + dto.getAge() + ", " + dto.getTel() + "<br/>");
}
%>
<br/>

[리스트 구조에 객체가 저장된 객체배열(mlist)의 내용을 출력(EL)]<br/>
${mlist[0].name}, ${mlist[0].id}, ${mlist[0].age}, ${mlist[0].tel}<br/>
${mlist[1].name}, ${mlist[1].id}, ${mlist[1].age}, ${mlist[1].tel}<br/>
${mlist[2].name}, ${mlist[2].id}, ${mlist[2].age}, ${mlist[2].tel}<br/>
${mlist[3].name}, ${mlist[3].id}, ${mlist[3].age}, ${mlist[3].tel}<br/>
${mlist[4].name}, ${mlist[4].id}, ${mlist[4].age}, ${mlist[4].tel}
</body>
</html>
