package com.hx.springframework.test.bean;

import com.hx.springframework.BeanDefinition;
import com.hx.springframework.BeanFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ApiTestTest {
	
	@Test
	void test_BeanFactory() {
		BeanFactory beanFactory = new BeanFactory();
		
		BeanDefinition beanDefinition = new BeanDefinition(new UserService());
		beanFactory.registerBeanDefinition("userService", beanDefinition);
		
		UserService userService = (UserService) beanFactory.getBean("userService").getBean();
		userService.queryUserInfo();
	}
}