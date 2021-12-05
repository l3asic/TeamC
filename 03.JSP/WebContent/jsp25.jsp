<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP25</title>
</head>
<body>
<!-- jsp25.jsp?num1=20&num2=10 -->
<%--
int num1 = Integer.parseInt(request.getParameter("num1"));
int num2 = Integer.parseInt(request.getParameter("num2"));

out.println("num1의 값 : " + num1 + "<br/>");
out.println("num2의 값 : " + num2);
--%>

num1의 값(EL) : ${param.num1}<br/>
num2의 값(EL) : ${param.num2}<br/>
<br/>

num1 + num2 : ${param.num1} + ${param.num2}<br/>
num1 + num2 : ${param.num1 + param.num2}<br/>
num1 - num2 : ${param.num1 - param.num2}<br/>
num1 * num2 : ${param.num1 * param.num2}<br/>
num1 / num2 : ${param.num1 / param.num2}<br/>
num1 % num2 : ${param.num1 % param.num2}<br/>
<br/>
num1이 더 크나요? ${param.num1 - param.num2 > 0}<br/>
num1이 더 크나요? ${param.num1 - param.num2 gt 0}<br/>

num1이 더 크나요? ${param.num1 > param.num2}<br/>
num1이 더 크나요? ${param.num1 gt param.num2}<br/>
★ 주의 : 매개변수로 전달된 값(num1, num2)을 EL 비교연산자로 직접 비교할 경우<br/>
매개변수 값을 문자열로 인식하여 자릿수가 다를 경우 잘못된 결과가 나올 수 있다.<br/>
산술연산 후 비교연산을 수행할 수 있게 코드를 구현한다.<br/>
<br/>

num1과 num2가 같나요? ${param.num1 - param.num2 == 0 ? "예" : "아니오"}<br/>
num1과 num2가 같나요? ${param.num1 - param.num2 eq 0 ? "예" : "아니오"}<br/>

<!--
○ 대소관계 비교 ▶ > : gt, >= : ge, < : lt, <= : le
○ 동등관계 비교 ▶ == : eq, != : ne
-->
</body>
</html>
