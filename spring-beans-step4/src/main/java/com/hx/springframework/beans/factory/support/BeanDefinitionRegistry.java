package com.hx.springframework.beans.factory.support;

import com.hx.springframework.beans.factory.config.BeanDefinition;

public interface BeanDefinitionRegistry {
	
	void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
