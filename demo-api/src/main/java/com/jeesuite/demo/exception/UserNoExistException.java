/**
 * 
 */
package com.jeesuite.demo.exception;

/**
 * @description <br>
 * @author <a href="mailto:vakinge@gmail.com">vakin</a>
 * @date 2016年10月25日
 */
public class UserNoExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNoExistException() {
		super("用户不存在");
	}
	
	

}
