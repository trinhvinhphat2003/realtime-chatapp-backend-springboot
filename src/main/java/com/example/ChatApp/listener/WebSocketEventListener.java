package com.example.ChatApp.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.example.ChatApp.DTO.Message;
import com.example.ChatApp.enums.MessageType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebSocketEventListener {
	
	@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
	
	@EventListener
	public void handleDisconnect(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
		String username = (String) headerAccessor.getSessionAttributes().get("username");
		if (username != null) {
			log.info("User disconnected: {}", username);
			var message = Message.builder().status(MessageType.LEAVE).senderName(username).message(username + " " + "has left the room").build();
			simpMessagingTemplate.convertAndSend("/chatroom/public", message);
		}
	}
}
