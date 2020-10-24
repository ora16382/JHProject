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
	a{
		color:black;
	}
	.no_unerline {
		text-decoration: none;
	}
</style>
</head>
<body>
	<h1>Side Menu</h1>
	<h1>
		<a href="${contextPath}/member/listMembers.do" class="no_unerline">Member Manage</a><br>
		<a href="${contextPath}/board/listArticles.do" class="no_unerline">Board Manage</a><br>
		<a href="#" class="no_unerline">Product Manage</a><br>
	</h1>
	
	<div style="position:fixed;  bottom:2em; left:3em"  ><a  href="${contextPath}/member/memberForm.do"><h1 style="text-align:center">Sign Up</h1></a></div>
</body>
</html>