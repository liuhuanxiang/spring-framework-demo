package com.hx.springframework.beans.factory.support;

import com.hx.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
	
	//注册BeanDefinition
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
	
	//获取BeanDefinition
	BeanDefinition getBeanDefinition(String beanName);
	
	//判断是否存在BeanDefinition
	boolean containsBeanDefinition(String beanName);
	
	//获取所有BeanDefinition的名字
	String[] getBeanDefinitionNames();
	
}
