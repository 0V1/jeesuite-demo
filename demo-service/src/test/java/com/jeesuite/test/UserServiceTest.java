/**
 * 
 */
package com.jeesuite.test;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jeesuite.demo.dao.entity.UserEntity;
import com.jeesuite.demo.dao.mapper.UserEntityMapper;
import com.jeesuite.spring.InstanceFactory;
import com.jeesuite.spring.SpringInstanceProvider;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:test-root.xml"})
public class UserServiceTest implements ApplicationContextAware{
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired UserEntityMapper mapper;

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {	
		InstanceFactory.setInstanceProvider(new SpringInstanceProvider(arg0));
	}
	
	@Test
	public void test(){
		mapper.selectByPrimaryKey(1);
		mapper.selectAll();
		mapper.findByType(1);
		
		UserEntity entity = new UserEntity();
		entity.setCreatedAt(new Date());
		entity.setMobile("15920558210");
		entity.setPassword("2345678");
		entity.setType(0);
		
		mapper.insertSelective(entity);
		
	}
	
}
