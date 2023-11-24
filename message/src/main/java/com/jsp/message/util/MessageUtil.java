package com.jsp.message.util;

import org.springframework.web.bind.annotation.RequestParam;

import com.jsp.message.Dto.MessageDto;
import com.jsp.message.service.SmsService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

public class MessageUtil {
	final public static String accountSid = "AC59bc1463f6eb7f511ebb37f6e2ae92c6";
	final public static String authToken = "e9283a506b5affb5955138b16f03d33b";
	final public static String phoneNumber = "+12673524178";

	
						
	static {
		
			Twilio.init(accountSid,authToken);
	}
	
	public static void sendMessage(String to, String body) {
        
		Message.creator(
                new com.twilio.type.PhoneNumber(to),
                new com.twilio.type.PhoneNumber(phoneNumber),
                body)
                .create();
    }
}
