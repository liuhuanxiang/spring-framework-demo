package com.hx.springframework.test;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.IoUtil;
import com.hx.springframework.beans.PropertyValue;
import com.hx.springframework.beans.PropertyValues;
import com.hx.springframework.beans.factory.config.BeanDefinition;
import com.hx.springframework.beans.factory.config.BeanReference;
import com.hx.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.hx.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.hx.springframework.core.io.DefaultResourceLoader;
import com.hx.springframework.core.io.Resource;
import com.hx.springframework.test.bean.UserDao;
import com.hx.springframework.test.bean.UserService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ApiTest {
	
	@Test
	public void test_beanFactory() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		
		beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
		
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
		//propertyValues.addPropertyValue(new PropertyValue("uId", "2"));
		
		beanFactory.registerBeanDefinition("userService", new BeanDefinition(UserService.class, propertyValues));
		
		UserService userService = (UserService) beanFactory.getBean("userService", "2");
		userService.queryUserInfo();
		
	}
	
	@Test
	public void test_xml() {
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		
		//注入xml
		new XmlBeanDefinitionReader(beanFactory).loadBeanDefinitions("classpath:spring.xml");
		
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserInfo();
	}
	
	private DefaultResourceLoader resourceLoader;
	
	@Before
	public void init() {
		
		resourceLoader = new DefaultResourceLoader();
		
	}
	
	@Test
	public void test_classpath() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:important.properties");
		InputStream inputStream = resource.getInputStream();
		String content = IoUtil.readUtf8(inputStream);
		System.out.println(content);
	}
	
	@Test
	public void test_file()throws IOException {
		Resource resource = resourceLoader.getResource("src/main/resources/important.properties");
		InputStream inputStream = resource.getInputStream();
		String content = IoUtil.readUtf8(inputStream);
		System.out.println(content);
	}
	
	@Test
	public void test_beanUtil() {
		Object userService = new UserService();
		BeanUtil.setProperty(userService, "uId", "1");
		System.out.println(userService);
	}
}
