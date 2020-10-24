<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!--파일 추가 누를때마다 하단 영역 추가하려면 side 와 content height 계속하여 늘려줘야함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> <tiles:insertAttribute name="title" /> </title>
  <style>
  
  	  body {
  	  	color:black;
  	  }
  	  
      #container {
        width: 100%;
        margin: 0px auto;
          text-align:center;
        border: 0px solid #bcbcbc;
      }
      #header {
        padding: 5px;
        margin-bottom: 5px;
        border: 0px solid #bcbcbc;
         background-color: #708090;
      }
      #sidebar-left {
        width: 15%;
        height:1000px;
        padding: 5px;
        margin-right: 5px;
        margin-bottom: 5px;
        float: left;
         background-color: #708090;
        border: 0px solid #bcbcbc;
        font-size:10px;
      }
     
      #content {
        width: 81%;
        height: 1000px;
        padding: 5px;
        margin-right: 5px;
        float: left;
        border: 0px solid #bcbcbc;
        background-color:#A2ACB7;
      }
      #footer {
        clear: both;
        width:100%;
        padding: 5px;
        border: 0px solid #bcbcbc;
         background-color: #708090;
      }
      
      a {
      	text-decoration: none;
      }
      
      a:link{
      	color:balck;
      }
      a:visited{
      	color:black;
      }
      a:hover{
      	color:grey;
      }
      
      a:
      
    </style>
</head>
<body>
	<div id="container">
		<div id="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div id="sidebar-left">
			<tiles:insertAttribute name="side" />
		</div>
		<div id="content">
			<tiles:insertAttribute name="body" />
		</div>
		<div id="footer" style="position:fixed; bottom:0em">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>
</body>
</html>