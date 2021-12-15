<%@page import="net.htmlparser.jericho.Source"%>
<%@page import="com.hanul.study.GwangjuBusParser"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
GwangjuBusParser parser = new GwangjuBusParser();
Source source = parser.makeXml();
String xml = source.toString();

int beginIndex = xml.indexOf("<ns2:LINE_INFO");
xml = xml.substring(beginIndex);
%>
<%=xml %>