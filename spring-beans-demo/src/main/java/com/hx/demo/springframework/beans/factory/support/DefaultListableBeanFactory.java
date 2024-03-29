package com.hx.demo.springframework.beans.factory.support;

import com.hx.demo.springframework.beans.BeansException;
import com.hx.demo.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{
	
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
	
	
	@Override
	protected BeanDefinition getBeanDefinition(String beanName) throws BeansException{
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (null == beanDefinition) {
			throw new BeansException("No bean named '" + beanName + "' is defined");
		}
		return beanDefinition;
	}
	
	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}
}
