package com.hx.springframework.beans.factory.support;

import com.hx.springframework.beans.factory.BeanFactory;
import com.hx.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
	
	@Override
	public Object getBean(String name) {
		Object bean = getSingleton(name);
		if (bean != null) {
			return bean;
		}
		return createBean(name, getBeanDefinition(name));
	}
	
	protected abstract BeanDefinition getBeanDefinition(String beanName);
	
	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
