<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	let websocket;
   $("#enterbtn").on('click', function(){ //입장버튼
	   websocket = new WebSocket("ws://localhost:9090/chatws");
	   websocket.onopen=function(){ //연결시점 자동호출
		   console.log("웹소켓연결성공")
	   }
		websocket.onclose=function(){ //연결해제시점 자동호출
		   console.log("웹소켓연결해제성공")
	   }
		websocket.onmessage=function(server){ //서버로부터 데이터 수신
	   		console.log("웹소켓으로부터 수신 성공");
			if(server.data.indexOf($("nickname").val()) >= 0){ //내 닉네임이라면
				$("#chatarea").append("<div class='me'>"+server.data+"</div>");
				$(".me").css("color","green");
			}else{ 
				$("#chatarea").append("<div class='other'>"+server.data+"</div>");
				$(".other").css("color","blue");
			}
		}
		$("#status").html($("#nickname").val() + "님 입장 중입니다. <br>");
	   
   });
   $("#exitbtn").on('click', function(){ //퇴장버튼
	   websocket.close();
		$("#status").html($("#nickname").val() + "님 퇴장하셨습니다. <br>");
   });
   $("#sendbtn").on('click', function(){ //서버에게 데이터 전송버튼
	   websocket.send($("#nickname").val() + " : " + $("#message").val());
	   
   });
});
</script>
</head>
<body>
닉네임 <input type="text" name="nickname" id="nickname" value="${param.id }">
<input type="button" id="enterbtn" value="입장버튼">
<input type="button" id="exitbtn" value="퇴장버튼">

<h1>채팅 영역</h1>
<div id="chatarea" style="border:2px solid silver; background-color: yellow;">
채팅내용 표시 공간<br>
</div>

대화 입력 : <input type="text" id="message">
<input type="button" id="sendbtn" value="전송"><br>

<div id="status">현재 상태 : </div>
</body>
</html>