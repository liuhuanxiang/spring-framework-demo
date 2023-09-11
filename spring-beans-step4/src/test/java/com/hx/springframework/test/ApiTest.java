package com.hx.springframework.test;


import com.hx.springframework.beans.PropertyValue;
import com.hx.springframework.beans.PropertyValues;
import com.hx.springframework.beans.factory.BeanFactory;
import com.hx.springframework.beans.factory.config.BeanDefinition;
import com.hx.springframework.beans.factory.config.BeanReference;
import com.hx.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.hx.springframework.test.beans.UserDao;
import com.hx.springframework.test.beans.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.Test;

public class ApiTest {
	
	@Test
	public void test_BeanFactory() {
		//1、初始化 BeanFactory
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		
		//2、userDao 注册
		beanFactory.registerBeanDefinition("userDao", new BeanDefinition(UserDao.class));
		
		//3、UserService设置属性
		PropertyValues propertyValues = new PropertyValues();
		propertyValues.addPropertyValue(new PropertyValue("uId", "1"));
		propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));
		
		//4、 UserService 注入bean
		BeanDefinition beanDefinition = new BeanDefinition(UserService.class, propertyValues);
		beanFactory.registerBeanDefinition("userService", beanDefinition);
		
		//5、Userservice获取bean
		UserService userService = (UserService) beanFactory.getBean("userService");
		userService.queryUserInfo();
	}
	
	
	@Test
	public void test_cglib() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(UserService.class);
		enhancer.setCallback(new NoOp() {
			@Override
			public int hashCode() {
				return super.hashCode();
			}
		});
		Object o = enhancer.create(new Class[] {String.class}, new Object[] {"hx"});
		
		System.out.println(o);
	}
}
