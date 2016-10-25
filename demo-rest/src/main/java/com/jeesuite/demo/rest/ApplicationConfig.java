/**
 * 
 */
package com.jeesuite.demo.rest;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.web.filter.RequestContextFilter;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.jeesuite.rest.excetion.BaseExceptionMapper;
import com.jeesuite.rest.filter.format.FormatJsonDynamicFeature;
import com.jeesuite.rest.resolver.ObjectMapperResolver;

/**
 * @description <br>
 * @author <a href="mailto:wei.jiang@lifesense.com">vakin</a>
 * @date 2016年1月15日
 * @Copyright (c) 2015, lifesense.com
 */
public class ApplicationConfig extends ResourceConfig {

	public ApplicationConfig() {

		System.setProperty("user.timezone", "Asia/Shanghai");
		this.packages(new String[]{this.getClass().getPackage().getName()});
		this.register(ObjectMapperResolver.class);
		this.register(JacksonFeature.class);
		this.register(JacksonJsonProvider.class);
		this.register(BaseExceptionMapper.class);
		this.register(RequestContextFilter.class);
		//this.register(CorsFilter.class);
		register(FormatJsonDynamicFeature.class);

	}

}
