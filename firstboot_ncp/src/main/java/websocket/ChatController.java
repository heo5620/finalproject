package websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
	@RequestMapping("/chatstart")
	String chatstart(String id){
		return "websocket/chat";
	}
}
