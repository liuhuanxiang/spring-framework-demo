package com.hx.springframework.beans.factory.support;

import com.hx.springframework.beans.BeansException;
import com.hx.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry {
	
	private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
	
	@Override
	public void registerBeanDefinition(String beanNme, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanNme, beanDefinition);
	}
	
	@Override
	protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
		BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
		if (beanDefinition == null) {
			throw new BeansException("No bean named '" + beanName + "' is defined");
		}
		return beanDefinition;
	}
}
