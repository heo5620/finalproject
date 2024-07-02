<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
   //id : boardwritelink 클릭하면 a 태그 기본 동작 취소
   $("#boardwritelink").on('click',function(e){
	   let sessionid = <%=session.getAttribute("sessionid") %>; //표현문 태그
	   if(sessionid == null){ //로그인하지 않았다면
		   e.preventDefault();
	   }
	   
   })
});
</script>
</head>
<body>
<%if(session.getAttribute("sessionid") != null){%>
<h1><%=session.getAttribute("sessionid") %></h1>
<% }else{%>
<h1>로그인 한 적이 없습니다.</h1>
<%} %>
<h1>나의 게시판 프로젝트</h1>
<h3>서비스는 다음과 같습니다.</h3>
<h4>
	<ul>
		<li><a href="boardlist">게시물리스트 보러가기(로그인하지 않아도 됩니다.)</a></li>
		<li><a href="boardwrite" id="boardwritelink">글쓰기</a>(로그인하셔야 합니다.)</li>
		<li><a href="boardlogin">로그인</a></li>
		<li><a href="boardlogout">로그아웃</a></li>
	</ul>
</h4>
</body>
</html>