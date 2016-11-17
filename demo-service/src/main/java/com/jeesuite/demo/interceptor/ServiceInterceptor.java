/**
 * 
 */
package com.jeesuite.demo.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import com.jeesuite.mybatis.plugin.cache.CacheHandler;

@Aspect
@Service
@Order(0)
public class ServiceInterceptor{
	
	protected static final Logger logger = LoggerFactory.getLogger(ServiceInterceptor.class);

	//定义拦截切面
	@Pointcut("execution(* com.jeesuite.demo.service..*.*(..))")  
    public void pointcut(){}

	 @Around("pointcut()") 
	 public Object around(ProceedingJoinPoint pjp) throws Throwable{
		 try {
			return pjp.proceed();
		} catch (Exception e) {
			//回滚自动缓存
			CacheHandler.rollbackCache();
			
			throw new RuntimeException(e);
		}
	 }  

}
