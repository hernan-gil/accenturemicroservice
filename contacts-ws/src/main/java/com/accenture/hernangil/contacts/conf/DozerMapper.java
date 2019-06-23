package com.accenture.hernangil.contacts.conf;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerMapper {
	@Bean
	public Mapper beanMapper() {
		// (3)
		return new DozerBeanMapper();
	}
}
