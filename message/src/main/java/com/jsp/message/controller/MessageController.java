package com.jsp.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.message.Dto.MessageDto;
import com.jsp.message.Dto.SmsTemplateDto;
import com.jsp.message.Dto.StudentDto;
import com.jsp.message.service.MessageService;
import com.jsp.message.service.SmsService;

@RestController
public class MessageController {
	
	@Autowired
	MessageService messageService;
	
	@Autowired
	SmsService smsService;
	
	@PostMapping("/send-message")
	public@ResponseBody void sendMessage(@RequestBody MessageDto messageDto) {
		messageService.sendMessage(messageDto);
		
	}
	@PostMapping("/createData")
	public@ResponseBody void createData(@RequestBody SmsTemplateDto smsTemplateDto) {
		smsService.createData(smsTemplateDto);
	}
	
	@PostMapping("/createStudentData")
	public@ResponseBody void createStudentData(@RequestBody StudentDto studentDto) {
		smsService.createStudentData(studentDto);
	}
	
	@PutMapping("/getSid")
	public @ResponseBody String getSid(@RequestHeader("Sid")long Sid) {
	return	smsService.getNameById(Sid);
		
	}
	
	@PutMapping("/getCode")
	public @ResponseBody String getSubjectByCode(@RequestHeader("tcCode")String tcCode,@RequestParam("templatePlaceolder") String templatePlaceHolder) {
		return smsService.getContentByCode(tcCode);
	} 
	
	@PutMapping("/CommonMethod")
	public @ResponseBody String commonMethod(@RequestHeader("sid")long sid,@RequestHeader("tcCode")String tcCode) {
	return smsService.commonMethod(sid, tcCode);
		
		
	}
	
	
}
