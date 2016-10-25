/**
 * 
 */
package com.jeesuite.demo.rest.controller;

import javax.annotation.Resource;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.jeesuite.demo.api.IUserService;
import com.jeesuite.demo.dto.User;

/**
 * @description <br>
 * @author <a href="mailto:vakinge@gmail.com">vakin</a>
 * @date 2016年10月25日
 */
@Component
@Singleton
@Path("/user")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED,MediaType.TEXT_XML})
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_FORM_URLENCODED,MediaType.TEXT_XML})
public class UserController {
	
	@Resource
	private IUserService userService;
	
	@GET
	@Path("{id}")
	public User getUser(@PathParam("id") int userId){
		return userService.getUser(userId);
	}

}
