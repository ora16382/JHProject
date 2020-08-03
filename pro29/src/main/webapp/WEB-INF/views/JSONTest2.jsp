<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		$("#checkJson").click(function(){
			var article = {articleNO : "114",
					name:"박지성",
					title : "안녕하세요",
					content : "상품 소개 글입니다."};
			$.ajax({
				type:"post",
				url:"${contextPath}/boards",
				/*
					type:"put",
					url:"${contextPath}/boards/114",
					*/
				contentType:"application/json",
				dataType : "json",
				data : JSON.stringify(article),
				success:function(data,textStatus){
					$("div").html("zz"+data.content);
				},
				error:function(data,textStatus){
					alert("에러가 발생했습니다.");
				},
				complete:function(data,text,Status){
					
				}
			});	
		});
	});
</script>
</head>
<body>
	<input type="button" id="checkJson" value="새글 쓰기" /><br><br>
	<div id="output"></div>
</body>
</html>