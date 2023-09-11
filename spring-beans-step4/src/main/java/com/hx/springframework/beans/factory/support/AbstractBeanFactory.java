package com.hx.springframework.beans.factory.support;

import com.hx.springframework.beans.factory.BeanFactory;
import com.hx.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
	
	@Override
	public Object getBean(String name) {
		return doGetBean(name, null);
	}
	
	@Override
	public Object getBean(String name, Object... args) {
		return doGetBean(name, args);
	}
	
	protected <T> T doGetBean(final String name, final Object[] args) {
		Object singleton = getSingleton(name);
		if (singleton != null) {
			return (T) singleton;
		}
		
		return (T) createBean(name, getBeanDefinition(name), args);
	}
	
	protected abstract BeanDefinition getBeanDefinition(String beanName);
	
	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);
}
