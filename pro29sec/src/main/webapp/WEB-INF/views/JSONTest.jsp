<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function(){
		$("#checkJson").click(function(){
			var member = {id : "park",
					name:"박지성",
					pwd:"1234",
					email:"park@test.com"};
			$.ajax({
				type:"post",
				url:"${contextPath}/test/info",
				dataType : "html",
				data : {param:"한글"},
				success:function(data,textStatus){
					$("#test").html(data);
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
<input type="button" id="checkJson" value="회원정보보내기" /><br><br>
<div id="output"></div>

<form method="post"  action="${contextPath}/test/test">
	<table  align="center">
	   <tr>
	      <td width="200"><p align="right">아이디</td>
	      <td width="400"><input type="text" name="id"></td>
	   </tr>
	   <tr>
	      <td width="200"><p align="right">비밀번호</td>
	      <td width="400"><input type="password" name="pwd"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이름</td>
	       <td width="400"><p><input type="text" name="name"></td>
	    </tr>
	    <tr>
	       <td width="200"><p align="right">이메일</td>
	       <td width="400"><p><input type="text" name="email"></td>
	    </tr>
	    <tr>
	       <td width="200"><p>&nbsp;</p></td>
	       <td width="400"><input type="submit" value="수정하기"><input type="reset" value="다시입력"></td>
	    </tr>
	    
	    <tr>
	    <td><div id="test"></div></td>
	    </tr>
	</table>
	</form>
</body>
</html>