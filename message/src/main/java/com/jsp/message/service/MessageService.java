package com.jsp.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.message.Dto.MessageDto;
import com.jsp.message.util.MessageUtil;
@Service
public class MessageService  {
	@Autowired
	MessageDto messageDto;
	
	@Autowired
	SmsService smsService;
	

	public void sendMessage(MessageDto messageDto) {
		
		try{
			MessageUtil.sendMessage(messageDto.getTo(),messageDto.getBody());
		}
		catch(Exception e) {
			
		System.out.println("Enter verified number");
		}
	}
}
