package com.hx.springframework.beans.factory.support;

import com.hx.springframework.beans.factory.BeanFactory;
import com.hx.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
	
	@Override
	public Object getBean(String beanName) {
		return doGetBean(beanName, null);
	}
	
	@Override
	public Object getBean(String beanName, Object... args) {
		return doGetBean(beanName, args);
	}
	
	protected <T> T doGetBean(String beanName, final  Object[] args) {
		//先从单例池中获取
		Object bean = getSingleton(beanName);
		if (bean != null) {
			return (T)bean;
		}
		BeanDefinition beanDefinition = getBeanDefinition(beanName);
		return (T)createBean(beanName, beanDefinition, args);
	}
	
	protected abstract BeanDefinition getBeanDefinition(String beanName);
	
	protected  abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args);
	
}
