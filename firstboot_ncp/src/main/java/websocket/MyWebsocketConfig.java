package websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration //chatws 매핑 설정 //스프링의 설정 클래스로 등록
@EnableWebSocket  //현재 설정으로 웹소켓 활성화
public class MyWebsocketConfig implements WebSocketConfigurer{
	@Autowired
	ChatWebsocketHandler handler;
	
	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(handler, "/chatws").setAllowedOrigins("*");
	} 
	
}
