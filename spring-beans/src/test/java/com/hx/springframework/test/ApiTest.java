package com.hx.springframework.test;

import com.hx.springframework.beans.factory.config.BeanDefinition;
import com.hx.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.hx.springframework.test.bean.UserService;
import org.junit.Test;

public class ApiTest {
	
	@Test
	public void test_BeanFactory() {
		//1、初始化 BeanFactory
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		
		//2、注册 bean
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
		factory.registerBeanDefinition("userService", beanDefinition);
		
		//3、第一次获取 bean
		UserService userService = (UserService) factory.getBean("userService");
		userService.queryUserInfo();
		
		//4、第二次获取 bean from singleton
		UserService userService_singleton = (UserService) factory.getBean("userService");
		userService_singleton.queryUserInfo();
	}
}
