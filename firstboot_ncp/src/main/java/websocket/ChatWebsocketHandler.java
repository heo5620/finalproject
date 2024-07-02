package websocket;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class ChatWebsocketHandler implements WebSocketHandler {

	List<WebSocketSession> list = new ArrayList(); //웹소켓 연결 클라이언트 모음
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// 웹소켓 연결시점에서 1번 실행
		// 웹소켓 연결 클라이언트 list add
		list.add(session);
		System.out.println("클라이언트수 = " + list.size() + " - " + session.getRemoteAddress() + " ip에서 접속 중");
		
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		// 웹소켓 연결 해제시점에서 1번 실행
		list.remove(session);
		System.out.println("삭제 후 클라이언트수 = " + list.size() + " - " + session.getRemoteAddress() + " ip에서 접속 해제");
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception { //세션 : 접속한 클라이언트 ip, 메시지 : 보낸 데이터
		String str_message = String.valueOf((message.getPayload())); //받은 message를 string 으로 변환
		
		
		for(WebSocketSession socket : list) { //이 메시지를 보낸 클라이언트에게만 돌려주는게 아니라 연결된 모든 클라이언트에게 응답
			WebSocketMessage<String> sendmsg = new TextMessage(str_message); //WebSocketMessage : 웹소켓을 통해 전송될 메시지 인터페이스, TextMessage : 텍스트 기반 메시지 클래스. 웹소켓 메시지 인터페이스 구현 클래스
			socket.sendMessage(sendmsg); //socket : 현재 처리 중인 클라이언트의 웹소켓 세션. sendMsg를 해당 세션에 전송 
		}
		
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		//오류처리용도.
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// 부가정보 생성 용도
		return false;
	}
	
}
