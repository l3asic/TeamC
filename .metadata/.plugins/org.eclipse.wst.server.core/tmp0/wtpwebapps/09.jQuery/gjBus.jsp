<%@page import="net.htmlparser.jericho.Source"%>
<%@page import="com.hanul.study.GwangjuBusParser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
GwangjuBusParser parser = new GwangjuBusParser();
Source source = parser.makeJson();
String json = source.toString();

int beginIndex = json.indexOf("[");
int endIndex = json.indexOf("]");
json = json.substring(beginIndex, endIndex + 1);
%>
<%=json %>