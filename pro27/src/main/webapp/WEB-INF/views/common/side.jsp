<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사이드 메뉴</title>
<style>
	.no_unerline {
		text-decoration: none;
	}
</style>
</head>
<body>
	<h1>사이드 메뉴</h1>
	<h1>
		<a href="#" class="no_unerline">회원 관리</a><br>
		<a href="#" class="no_unerline">게시판관리</a><br>
		<a href="#" class="no_unerline">상품 관리</a><br>
	</h1>
</body>
</html>