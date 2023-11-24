package com.jsp.message;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MyPortConfiguration {

	@Value("${server.port}")
	private int port;

	@Bean
	public WebServerFactoryCustomizer<ConfigurableWebServerFactory> contanCustomizer() {
		return factory -> factory.setPort(5000);
	}
}
