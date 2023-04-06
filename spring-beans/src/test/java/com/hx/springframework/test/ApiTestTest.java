package com.hx.springframework.test;

import com.hx.springframework.beans.factory.config.BeanDefinition;
import com.hx.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.hx.springframework.test.bean.UserService;
import org.junit.jupiter.api.Test;

class ApiTestTest {
	
	@Test
	void test_BeanFactory() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		
		beanFactory.registerBeanDefinition("userService", beanDefinition);
		
		UserService userService = (UserService) beanFactory.getBean("userService");
		
		userService.queryUserInfo();
		
		UserService userService_singleton = (UserService) beanFactory.getBean("userService");
		userService_singleton.queryUserInfo();
		
	}
	
	
}