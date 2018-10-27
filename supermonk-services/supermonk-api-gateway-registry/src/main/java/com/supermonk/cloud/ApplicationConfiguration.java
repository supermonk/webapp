package com.supermonk.cloud;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter; 


public class ApplicationConfiguration  {
	 
//	@Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();   
//        jsonConverter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//        converters.add(jsonConverter);
//    }
}
