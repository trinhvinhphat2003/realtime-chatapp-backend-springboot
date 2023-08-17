package com.example.ChatApp.DTO;

import com.example.ChatApp.enums.MessageType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {
	private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private MessageType status;
}
