<%@page import="com.hanul.cart.CartDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
request.setCharacterEncoding("utf-8");

ArrayList<CartDTO> cart = null;
Object obj = session.getAttribute("cart");	//세션객체에서 cart 속성값을 가져온다.

if(obj == null){	//세션정보가 없다 : 장바구니가 비워있다. ▶ cart 배열 생성
	cart = new ArrayList<CartDTO>();
}else{				//세션정보가 있다 : 장바구니에 내역이 있다. ▶ obj의 값을 cart 배열타입으로 캐스팅
	cart = (ArrayList<CartDTO>) obj;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart View</title>
<script type="text/javascript">
function fnPay(totalSum){
	//alert("총주문금액 : " + totalSum);
	if(confirm(totalSum + "원을 결제 하시겠습니까?")){
		alert("결제 API를 발급 받으시기 바랍니다!");
	}else{
		alert("결제가 취소 되었습니다!");
	}
}

function fnShop(){
	location.href = "ShopMallMain.jsp";
}

function fnClear(){
	if(confirm("장바구니를 비우시겠습니까?")){
		location.href = "CartClear.jsp";
	}
	return false;
}
</script>
</head>
<body>
<div align="center">
<h3>[장바구니 보기]</h3>
<table border="1" style="width: 70%">
	<tr>
		<th>번호</th>
		<th>과일명</th>
		<th>가격</th>
		<th>주문수량</th>
		<th>주문금액</th>
	</tr>
	
	<%-- JSTL과 EL표현식을 이용한 출력 : 라이브러리 등록, 지시자(core, fn, fmt) --%>
	<c:if test="${empty cart}">
		<tr align="center">
			<td colspan="5">
				장바구니가 비워 있습니다!<br/>
				<input type="button" value="주문하기" onclick="location.href='ShopMallMain.jsp'"/>
			</td>
		</tr>
	</c:if>
	
	<c:if test="${!empty cart}">
		<c:forEach var="i" begin="0" end="${fn:length(cart) - 1}" step="1">
			<c:set var="total" value="${cart[i].price * cart[i].cnt}"/>
			<c:set var="totalSum" value="${totalSum + total}"/>
			<tr align="center">
				<td>${i + 1}</td>
				<td>${cart[i].name}</td>
				<td><fmt:formatNumber value="${cart[i].price}" pattern="￦#,##0원"/></td>
				<td><fmt:formatNumber value="${cart[i].cnt}" pattern="#,##0개"/></td>
				<td><fmt:formatNumber value="${total}" pattern="￦#,##0원"/></td>
			</tr>
		</c:forEach>
		
		<tr align="center">
			<td colspan="4">전체주문금액</td>
			<td><fmt:formatNumber value="${totalSum}" pattern="￦#,##0원"/></td>
		</tr>
		
		<tr align="center">
			<td colspan="5">
				<input type="button" value="결제하기" onclick="fnPay('${totalSum}')"/>
				<input type="button" value="주문계속하기" onclick="fnShop()"/>
				<input type="button" value="장바구니 비우기" onclick="fnClear()"/>
			</td>
		</tr>
	</c:if>	
	
</table>
</div>
</body>
</html>