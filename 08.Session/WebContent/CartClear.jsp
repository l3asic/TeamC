<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
session.removeAttribute("cart");	//cart 세션 객체가 삭제
session.invalidate();	//모든 세션 객체가 삭제

response.sendRedirect("ShopMallMain.jsp");
%>