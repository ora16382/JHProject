<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    isELIgnored="false"  %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<%
  request.setCharacterEncoding("UTF-8");
%>    


<html>
<head>
<meta charset=UTF-8">
<title>회원 정보 출력창</title> 
<script type="text/javascript">
	if('${isLogOn}'!='true'){
		alert("로그인하십시오.");
		location.href='${contextPath}/member/loginForm.do';
	}else if('${member.id }'!="wnsgud14"){
		alert("어드민 계정이 아닙니다.");
		location.href='${contextPath}/main.do';
	}
	
	if('${member.id }'=="wnsgud14"){
		alert("관리자 계정으로 접속하셨습니다.");
	}
</script>
</head>
<body>
<table border="1"  align="center"  width="80%">
    <tr align="center"   bgcolor="lightgreen">
      <td ><b>아이디</b></td>
      <td><b>비밀번호</b></td>
      <td><b>이름</b></td>
      <td><b>이메일</b></td>
      <td><b>가입일</b></td>
      <td><b>수정하기</b></td>
      <td><b>삭제하기</b></td>
   </tr>
   
 <c:forEach var="member" items="${membersList}" >     
   <tr align="center">
      <td>${member.id}</td>
      <td>${member.pwd}</td>
      <td>${member.name}</td>
      <td>${member.email}</td>
      <td>${member.joinDate}</td>
      <td><a href="${contextPath}/member/modMember.do?id=${member.id}">수정하기</a></td>
      <td><a href="${contextPath}/member/removeMember.do?id=${member.id}">삭제하기</a></td>	
    </tr>
  </c:forEach>   
</table>
<a  href="${contextPath}/member/memberForm.do"><h1 style="text-align:center">회원가입</h1></a>
</body>
</html>