<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<c:set var="article" value="${articleMap.article}" />
<c:set var="imageFileList" value="${articleMap.imageFileList}" />

<head>
   <meta charset="UTF-8">
   <title>글보기</title>
   <style>
     #tr_btn_modify{
       display:none;
     }
      #tr_file_upload{
       display:none;
     }
   
   </style>
   <script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
   <script type="text/javascript" >
   var cont=1;
   var max=0;
   
   var addArticleNum = max+1;
   <%-- ${empty 변수명 ==[] } =='' 이렇게 해야함'' --%>	
     function backToList(obj){
	    obj.action="${contextPath}/board/listArticles.do";
	    obj.submit();
     }
 
	 function fn_enable(obj){
		 cont=1;
		 document.getElementById("i_title").disabled=false;
		 document.getElementById("i_content").disabled=false;
		 
		 var name = document.getElementsByClassName("i_imageFileName");
		 for(var i=0; i<name.length; i++){
			 name[i].disabled=false;
		 }
		 document.getElementById("tr_btn_modify").style.display="table-row";
		 document.getElementById("tr_file_upload").style.display="table-row";
		 document.getElementById("tr_btn").style.display="none";
	 }
	 
	 
	  function fn_addFile(){
		  $("#d_file").append("<hr>"+"<img src='#'   width=200 height=200 /><br><input type='file' name='imageFileName"+cont+"' onchange='readURL(this);' />");
		  cont++;
	  }
	  
	  function fn_addFile2(){
		  $("#d_file").append("<hr>"+"<img src='#'   width=200 height=200 /><br><input type='file' name='imageFileName"+addArticleNum+"' onchange='readURL(this);' />");
		  addArticleNum++;
	  }
	  
	 function fn_modify_article(obj){
		 obj.action="${contextPath}/board/modArticle.do";
		 var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","hidden");
	     articleNOInput.setAttribute("name","count");
	     articleNOInput.setAttribute("value", max);
		 obj.appendChild(articleNOInput);
		 obj.submit();
	 }
	 
	 function fn_remove_article(url,articleNO){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var articleNOInput = document.createElement("input");
	     articleNOInput.setAttribute("type","hidden");
	     articleNOInput.setAttribute("name","articleNO");
	     articleNOInput.setAttribute("value", articleNO);
		 
	     form.appendChild(articleNOInput); 
	     document.body.appendChild(form);
	     form.submit();
	 
	 }
	 
	 function fn_reply_form(url, parentNO, parentTitle){
		 var form = document.createElement("form");
		 form.setAttribute("method", "post");
		 form.setAttribute("action", url);
	     var parentNOInput = document.createElement("input");
	     parentNOInput.setAttribute("type","hidden");
	     parentNOInput.setAttribute("name","parentNO");
	     console.log(parentNO);
	     parentNOInput.setAttribute("value", parentNO);
	     form.appendChild(parentNOInput);
	     
	     var parentArticleTitle = document.createElement("input");
	     parentArticleTitle.setAttribute("type","hidden");
	     parentArticleTitle.setAttribute("name","parentTitle");
	     parentArticleTitle.setAttribute("value", parentTitle);
	     form.appendChild(parentArticleTitle);
	     
	     document.body.appendChild(form);
		 form.submit();
	 }
	 
	 
	 function readURL(input) {
	     if (input.files && input.files[0]) {
	         var reader = new FileReader();
	         reader.onload = function (e) {  
	        input.previousElementSibling.previousElementSibling.src=e.target.result;
	        input.nextElementSibling.disabled=false;
	         }
	         reader.readAsDataURL(input.files[0]);
	     }
	 }  
 </script>
</head>
<body>
	<h6 style="border: 1px solid orange; width: 50px; margin-left: 19em; padding: 1px; " align="right">조회수 :  ${article.views}</h6>
  <form name="frmArticle" method="post"  action="${contextPath}"  enctype="multipart/form-data">
  <table  border=0  align="center">

  <tr>
   <td width=150 align="center" bgcolor=#FF9933>
      글번호
   </td>
   <td >
    <input type="text"  value="${article.articleNO }"  disabled />
    <input type="hidden" name="articleNO" value="${article.articleNO}"  />
   </td>
  </tr>
  <tr>
    <td width="150" align="center" bgcolor="#FF9933">
      작성자 아이디
   </td>
   <td >
    <input type=text value="${article.id }" name="writer"  disabled />
   </td>
  </tr>
  <tr>
    <td width="150" align="center" bgcolor="#FF9933">
      제목 
   </td>
   <td>
    <input type=text value="${article.title }"  name="title"  id="i_title" disabled />
   </td>   
  </tr>
  <tr>
    <td width="150" align="center" bgcolor="#FF9933">
      내용
   </td>
   <td>
    <textarea rows="20" cols="60"  name="content"  id="i_content"  disabled />${article.content }</textarea>
   </td>  
  </tr>
 
 <c:choose> 
	  <c:when test="${not empty imageFileList && imageFileList!='null' }">     <%-- !='null'부분 사실 없어도됨  차라리 !=[] 가 맞음  --%>
	  <c:forEach var="item" items="${imageFileList }" varStatus="status" >
	   	<tr>
		    <td width="150" align="center" bgcolor="#FF9933"  rowspan="2">
		      이미지
		   </td>
  
		  </tr>  
		  <tr>
		    <td>
		    <img src="${contextPath}/download.do?articleNO=${article.articleNO}&imageFileName=${item.imageFileName}" id="preview" width="200" height="200" /><br>
		       <input  type="file"  name="imageFileName${status.index } " class="i_imageFileName"   disabled   onchange="readURL(this);"   />
		     <input  type= "hidden"  name="imageFileNO${status.index }" value="${item.imageFileNO }" disabled/>
		    </td>
		  </tr>
		  <script>max = ${status.count};</script>
		</c:forEach> 
		  <tr id="tr_file_upload">
		 	<td width="150" align="center" bgcolor="#FF9933"> </td>
			 <td align="center"><input type="button" value="파일 추가" onclick="fn_addFile2()" /></td>
          </tr>
          <tr>
        	 	<td width="150" align="center" bgcolor="#FF9933"> </td>
         		<td align="center"><div id="d_file" ></div></td>
         </tr>
		</c:when>

		 <c:otherwise>
		    <tr id="tr_file_upload">
				 <td width="150" align="center" bgcolor="#FF9933"></td>
				<td align="center"><input type="button" value="파일 추가" onclick="fn_addFile()" /></td>
			 </tr>
        	 <tr>
        	 	<td width="150" align="center" bgcolor="#FF9933"></td>
         		<td align="center"><div id="d_file" ></div></td>
         	</tr>
			
		 </c:otherwise> 

	 </c:choose>
  <tr>
	   <td width="150" align="center" bgcolor="#FF9933">등록일자 </td>
	   <td>
	    <input type=text value="<fmt:formatDate value="${article.writeDate}" />" disabled />
	   </td>   
  </tr>
  <tr   id="tr_btn_modify"  >
	   <td colspan="2"   align="center" >
	       <input type=button value="수정반영하기"   onClick="fn_modify_article(frmArticle)"  >
           <input type=button value="취소"  onClick="backToList(frmArticle)">
	   </td>   
  </tr>
    
  <tr  id="tr_btn"    >
   <td colspan="2" align="center">
   		<c:if test="${member.id == article.id || member.id == 'wnsgud14'}">   
	    <input type=button value="수정하기" onClick="fn_enable(this.form)">
	    <input type=button value="삭제하기" onClick="fn_remove_article('${contextPath}/board/removeArticle.do', ${article.articleNO})">
	    </c:if>
	    <input type=button value="리스트로 돌아가기"  onClick="backToList(this.form)">
	     <input type=button value="답글쓰기"  onClick="fn_reply_form('${contextPath}/board/replyForm.do', ${article.articleNO}, '${article.title }')">
   </td>
  </tr>
 </table>
 </form>
</body>
</html>