package com.jsp.message.service;

import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.jsp.message.Dto.SmsTemplateDto;
import com.jsp.message.Dto.StudentDto;
import com.jsp.message.repository.SmsRepository;
import com.jsp.message.repository.StudentRepository;
import com.jsp.message.util.SmsTemplate;
import com.jsp.message.util.StudentDetails;

@Service
public class SmsService {

	// @Autowired
	// JdbcTemplate JdbcTemplate;

	@Autowired
	SmsRepository smsRepository;
	@Autowired
	StudentRepository studentRepository;
	
	public String createData(SmsTemplateDto smsTemplateDto) {
		// JdbcTemplate jdbcTemplate=new JdbcTemplate();
		// String sql="Insert into sms_template (
		// "+smsTemplateDto.getCreatedBy()
		// +smsTemplateDto.getCreatedDate()
		// +smsTemplateDto.getModifiedBy()
		// +smsTemplateDto.getModifiedDate()
		// +smsTemplateDto.getTemplateCode()
		// +saveEncodeData(smsTemplateDto.getTemplateContent())
		// +smsTemplateDto.getTemplatePlaceholder()
		// +smsTemplateDto.getTemplateSubject()
		// +")";

		SmsTemplate smsTemplate = new SmsTemplate();
		smsTemplate.setCreatedBy(smsTemplateDto.getCreatedBy());
		smsTemplate.setCreatedDate(smsTemplateDto.getCreatedDate());
		smsTemplate.setEntityId(smsTemplateDto.getEntityId());
		smsTemplate.setModifiedBy(smsTemplateDto.getModifiedBy());
		smsTemplate.setModifiedDate(smsTemplateDto.getModifiedDate());
		smsTemplate.setTemplateCode(smsTemplateDto.getTemplateCode());
		smsTemplate.setTemplateContent(
				saveEncodeData(smsTemplateDto.getTemplateContent()));
		smsTemplate.setTemplatePlaceholder(
				smsTemplateDto.getTemplatePlaceholder());
		smsTemplate.setTemplateSubject(smsTemplateDto.getTemplateSubject());

		smsRepository.save(smsTemplate);
		// jdbcTemplate.execute(sql);

		return new String("Sucessfully Data Added");
	}

	public String fetchData() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		return null;

	}

	public String saveEncodeData(String data) {

		byte[] encodeData = Base64.getEncoder().encode(data.getBytes());

		return new String(encodeData);
	}

	public String retriveEncodeData(String data) {
		byte[] decodedData = Base64.getDecoder().decode(data.getBytes());

		return new String(decodedData);

	}

	public String retriveEncodedData(String data) {
		// String data=myDatabaseRepository.retriveEncodedData();

		byte[] decodedBytes = Base64.getDecoder().decode(data);

		return new String(decodedBytes);
	}

	public String createStudentData(StudentDto studentDto) {
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setName(studentDto.getName());
		studentDetails.setPhoneNumber(studentDto.getPhoneNumber());

		StudentDetails s = studentRepository.save(studentDetails);

		return new String("Successfully updated");
	}

	public String getNameById(long Sid) {
		return studentRepository.findNameById(Sid);

	}

	public String getContentByCode(String code) {
		return retriveEncodeData((smsRepository.getContentbyCode(code)));

	}

	public String commonMethod(long Sid, String code) {
		String data = studentRepository.findNameById(Sid);
		String input = retriveEncodeData(smsRepository.getContentbyCode(code));
		return extractedContent(input, data);
	}
	public String extractedContent(String input, String data) {
		String regex = "MR\\.\\$\\(\\)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		String modifiedString = "";

		// String modifiedString="";
		// String regex="MR.\\$\\( )\\";
		//
		// Pattern pattern=Pattern.compile(regex);

		if(matcher.find()) {
			
			modifiedString = input.replace("MR.$()","MR." + data + "\n");
			System.err.println(data);
			return modifiedString;
		}
		else {
		System.err.println("hai");
		
		return modifiedString;
		}
		
		
	}

	
}
