package com.jsp.message.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.message.util.SmsTemplate;

public interface SmsRepository extends JpaRepository<SmsTemplate, Long> {
	
	@Query(value="SELECT template_content FROM sms_template where template_code=:tcCode",nativeQuery=true) 
	public String getContentbyCode(@Param("tcCode")String tcCode);

}
