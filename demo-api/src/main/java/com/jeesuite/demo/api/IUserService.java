/**
 * 
 */
package com.jeesuite.demo.api;

import com.jeesuite.demo.dto.User;
import com.jeesuite.demo.exception.UserNoExistException;

/**
 * @description <br>
 * @author <a href="mailto:vakinge@gmail.com">vakin</a>
 * @date 2016年10月25日
 */
public interface IUserService {

	User getUser(Integer userId) throws UserNoExistException;
	
	void updateUser(User user);
	
	void removeUser(Integer userId) throws UserNoExistException;
	
	void kafkaProducerTest();
	
	void cacheTest();
}
