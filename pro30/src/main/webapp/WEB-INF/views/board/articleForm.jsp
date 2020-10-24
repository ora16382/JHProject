<%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  /> 
<head>
<meta charset="UTF-8">
<title>글쓰기창</title>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">

	window.onload = function(){
		if( '${isLogOn }'!='true'){
			alert("로그인부터 해주세요");
			location.href='${contextPath}/member/loginForm.do?action=/board/articleForm.do';
		}
	}
	
   function readURL(input) {
      if (input.files && input.files[0]) {
	      var reader = new FileReader();
	      reader.onload = function (e) {
	     //   $('#'+input.name+'Pre').attr('src', reader.result);
	     //alert(input.nextElementSibling);
	     	input.nextElementSibling.nextElementSibling.src=reader.result;
          }

         reader.readAsDataURL(input.files[0]);
      }
  }  
  function backToList(obj){
    obj.action="${contextPath}/board/listArticles.do";
    obj.submit();
  }
  
  var cont=1;
  function fn_addFile(){
	  $("#d_file").append("<hr>"+"<input type='file' size='20' name='file"+cont+"' onchange='readURL(this);' /><br><img id='file"+cont+"Pre' src='#'   width=200 height=200 />");
	  cont++;
  }
</script>
 <title>새글 쓰기 창</title>
</head>
<body>
<h1 style="text-align:center">글 쓰기</h1>
  <form name="articleForm" method="post"   action="${contextPath}/board/addNewArticle.do"   enctype="multipart/form-data">
    <table border="0" align="center">
    <tr>
	     <td width="150" align="center" bgcolor="#708090">작성자 </td>
	   <td colspan="2" align="left"><input type="text" size="20"  maxlength="100" value="${member.name}" readonly/></td>
	 </tr>
     <tr>
	     <td width="150" align="center" bgcolor="#708090">글제목: </td>
	   <td colspan="2"><input type="text" size="71"  maxlength="500" name="title" /></td>
	 </tr>
	 <tr>
		  <td width="150" align="center" bgcolor="#708090" valign="top"><br>글내용: </td>
		<td colspan=2 align="left"><textarea name="content" rows="10" cols="65" maxlength="4000" ></textarea> </td>
     </tr>
     <tr>
          <td width="150" align="center" bgcolor="#708090">이미지파일 첨부:  </td>
         <td align="left"><input type="button" value="파일 추가" onclick="fn_addFile()" /></td>
     </tr>
     <tr>
     	 <td width="150" align="center" bgcolor="#708090"></td>
        <td colspan="2" align="center"><div id="d_file" ></div></td>
         
	 	</tr>
	 <tr>
	    <td colspan="2" align="center" bgcolor="#708090">
	       <input type="submit" value="글쓰기" />
	       <input type=button value="목록보기"onClick="backToList(this.form)" />
	    </td>
     </tr>
    </table>
  </form>
</body>
</html>