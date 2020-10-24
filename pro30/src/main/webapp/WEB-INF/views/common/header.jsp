<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
	
  <meta charset="UTF-8">
<title>헤더</title>
</head>
<body>
<table border=0  width="100%">
  <tr>
     <td style="padding-left:0" >
		<a href="${contextPath}/main.do">
			<img width="250px" height="100px" src="${contextPath}/resources/image/spring.jpg"  />
		</a>
     </td>
     <td >
       <h1><font size=30>Spring HomePage</font></h1>
     </td>
     	
     <td>
       <!-- <a href="#"><h3>로그인</h3></a> -->
       <c:choose>
          <c:when test="${isLogOn == true  && member!= null}">
            <h3>환영합니다. ${member.name }님!</h3>
            	<c:choose>
            		<c:when test="${previousURL == null}">
	        		<a href="${contextPath}/member/logout.do?action=/main.do"><h3>로그아웃</h3></a>
	        		</c:when>
	        				
            		<c:when test="${query != null }">
            			<a href="${contextPath}/member/logout.do?action=${previousURL}?${query}"><h3>로그아웃</h3></a>		
            		</c:when>
            		<c:otherwise>
            			<a href="${contextPath}/member/logout.do?action=${previousURL}"><h3>로그아웃</h3></a>
            		</c:otherwise>
            	</c:choose>
            
          </c:when>
          <c:otherwise>
          	<c:choose>
          		<c:when test="${previousURL == null}">
	        		<a href="${contextPath}/member/loginForm.do?action=/main.do"><h3>로그인</h3></a>
	        	</c:when>
	        	
          		<c:when test="${previousURL != '/member/loginForm.do'}"> 
          			<c:choose>
          				<c:when test="${query != null }">  
          					<a href="${contextPath}/member/loginForm.do?action=${previousURL}?${query}"><h3>로그인</h3></a>		
          				</c:when>
          				<c:otherwise>
          					<a href="${contextPath}/member/loginForm.do?action=${previousURL}"><h3>로그인</h3></a>
          				</c:otherwise>		
          			</c:choose>
	        	</c:when>
	        	
	        	<c:otherwise>
	        		<a href="${contextPath}/member/loginForm.do"><h3>로그인</h3></a>	
	        	</c:otherwise>
	        </c:choose>
	      </c:otherwise>
	   </c:choose>     
     </td>
  </tr>
</table>


</body>
</html>