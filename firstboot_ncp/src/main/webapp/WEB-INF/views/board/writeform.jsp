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
   
});
</script>
</head>
<body>
<h3>글쓰기</h3>
<form action="boardwrite" method="post">
제목 : <input type="text" name="title"><br>
내용 : <textarea rows="5" cols="50" name="contents">여기에 내용을 입력하세요.</textarea><br>
작성자 : <input type="text" name="writer" value="${sessionid }" readonly><br>
글암호 : <input type="password" name="pw"><br>
<input type="submit" value="작성완료">
</form>
</body>
</html>