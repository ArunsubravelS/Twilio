package com.jsp.message.Dto;

import org.springframework.stereotype.Component;

@Component
public class MessageDto {
	
	public String to;
	
	public String body;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
