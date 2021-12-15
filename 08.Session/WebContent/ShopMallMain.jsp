<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
//이미지 파일명, 제품명, 제품가격을 배열로 초기화
String[] img = {"apple1.jpg", "apple2.jpg", "apple3.jpg", "banana1.jpg",
		"banana2.jpg", "banana3.jpg", "pear1.jpg", "pear2.jpg", "pear3.jpg"};

String[] name = {"사과1", "사과2", "사과3", "바나나1",
		"바나나2", "바나나3", "배1", "배2", "배3"};

String[] price = {"1,500", "1,600", "1,700", "3,000",
		"3,500", "4,000", "5,000", "6,000", "7,000"};

pageContext.setAttribute("img", img);
pageContext.setAttribute("name", name);
pageContext.setAttribute("price", price);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shop Mall Main</title>
<script type="text/javascript">
function fnCart(name, price){
	//alert("제품명 : " + name + "\n제품가격 : " + price);
	if(confirm("장바구니에 담으시겠습니까?")){
		location.href = "CartProcess.jsp?name=" + name + "&price=" + price;
	}
	return false;
}

function fnView(){
	if(confirm("장바구니 보기를 하시겠습니까?")){
		location.href = "CartView.jsp";
	}
	return false;
}
</script>
</head>
<body>
<div align="center">
<h3>[맛있는 과일가게]</h3>
<table border="1">
	<tr align="right">
		<td colspan="3">
			<input type="button" value="장바구니 보기" onclick="fnView()"/>
		</td>
	</tr>

	<%--
	for(int i = 0; i < img.length; i++){
		if(i % 3 == 0){
			out.println("<tr align='center'>");
		}//if
		out.println("<td>");
		
		out.println("<table>");
		out.println("<tr align='center'>");
		out.println("<td>");
		//<img src="images/apple1.jpg"/>
		out.println("<img src='images/" + img[i] + "'/>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr align='center'>");
		out.println("<td>");
		out.println("<b>" + name[i] + "</b>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr align='center'>");
		out.println("<td>");
		out.println("<b>￦" + price[i] + "원</b>");
		out.println("</td>");
		out.println("</tr>");
		
		out.println("<tr align='center'>");
		out.println("<td>");
		out.println("<input type='button' value='장바구니 담기'  ");
		out.println("onclick='fnCart(\"" + name[i] + "\", \"" + price[i] + "\")' />");
		out.println("</td>");
		out.println("</tr>");
		out.println("</table>");
		
		out.println("</td>");
		if(i % 3 == 2){
			out.println("</tr>");			
		}//if
	}//for
	--%>
	
	<%-- JSTL과 EL표현식을 이용한 코드 구현 : 라이브러리 등록, 지시자 작성(core, fn) --%>
	<c:forEach var="i" begin="0" end="${fn:length(img) - 1}" step="1">
		<c:if test="${i % 3 == 0}"><tr align="center"></c:if>
			<td>
				<table>
					<tr align="center">
						<td><img src="images/${img[i]}"></td>
					</tr>
					<tr align="center">
						<td><b>${name[i]}</b></td>
					</tr>
					<tr align="center">
						<td><b>${price[i]}</b></td>
					</tr>
					<tr align="center">
						<td>
							<input type="button" value="장바구니 담기" 
								onclick="fnCart('${name[i]}', '${price[i]}')"/>
						</td>
					</tr>
				</table>
			</td>
		<c:if test="${i % 3 == 2}"></tr></c:if>
	</c:forEach>
</table>
</div>
</body>
</html>
