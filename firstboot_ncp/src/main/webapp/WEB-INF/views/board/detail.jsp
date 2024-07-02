<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/jquery-3.7.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
   $("#editbtn").on('click',function(){
	   let userpw = window.prompt("글 암호를 입력하시오.");
	   let dppw = $("input:hidden").val();
	   if(userpw == dppw){
		   $("form").attr("action","boardupdate");
		   $("method").attr("method","post");
		   $("form").submit(); //form 태그 내부 모든 input name 변수 전달
	   }else{
		   alert("암호가 일치하지 않습니다.");
	   }
   })
   
   $("#deletebtn").on('click',function(){
	   let userpw = window.prompt("글 암호를 입력하시오.");
	   let dbpw = $("input:hidden").val();
	   if(userpw == dbpw){
		   location.href="boarddelete?seq=${dto.seq}";
	   }else{
		   alert("암호가 일치하지 않습니다.");
	   }
   })
});
</script>
</head>
<body>
<form action="" method="">
	<table border="3">
		<tr>
			<th>번호</th>
			<td><input type="text" name="seq" value="${dto.seq }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="${dto.title }"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="contents">${dto.contents }</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer" value="${dto.writer }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>조회수</th>
			<td><input type="text" name="viewcount" value="${dto.viewcount }" readonly="readonly"></td>
		</tr>
		<tr>
			<th>작성시간</th>
			<td><input type="text" name="writingtime" value="${dto.writingtime }" readonly="readonly"></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="editbtn" value="수정">
				<input type="button" id="deletebtn" value="삭제">
			</td>
		<tr>
	</table>
	<input type="hidden" name="pw" value="${dto.pw }">
</form>
</body>
</html>