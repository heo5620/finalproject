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
   
});
</script>
</head>
<body>
<form action="boardsearchlist" method="get">
검색 항목 : 
<input type="radio" name="item" value="all">모두
<input type="radio" name="item" value="title">제목
<input type="radio" name="item" value="contents">내용
<input type="radio" name="item" value="writer">작성자<br>
<input type="text" name="searchword"><br>
<input type="submit" value="검색요청"><br>
</form>

<table border="3">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
	</tr>
<c:forEach items="${boardsearchlist }" var="dto">
	<tr>
		<td>${dto.seq }</td>
		<td><a href="boarddetail?seq=${dto.seq }">${dto.title }</a></td>
		<td>${dto.writer }</td>
		<td>${dto.viewcount }</td>
	</tr>
</c:forEach>	
</table>

<h3>페이지를 선택하세요</h3>

<%
int totalSearchBoard = (Integer)request.getAttribute("totalSearchBoard");
int totalpage = 0;
if(totalSearchBoard % 3 == 0){
	totalpage = totalSearchBoard / 3;
}else{
	totalpage = totalSearchBoard / 3 + 1;
}
for(int i=1; i<=totalpage; i++){
%>
<a href="boardsearchlist?pagenum=<%=i%>&item=${param.item}&searchword=${param.searchword}"><%=i %>페이지</a>
<%
}%>
</body>
</html>