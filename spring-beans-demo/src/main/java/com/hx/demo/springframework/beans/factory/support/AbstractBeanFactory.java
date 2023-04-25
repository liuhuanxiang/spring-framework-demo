package com.hx.demo.springframework.beans.factory.support;

import com.hx.demo.springframework.beans.BeansException;
import com.hx.demo.springframework.beans.factory.BeanFactory;
import com.hx.demo.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
	
	@Override
	public Object getBean(String name) throws BeansException {
		Object bean = getSingleton(name);
		if (null != bean) {
			return bean;
		}
		BeanDefinition beanDefinition = getBeanDefinition(name);
		return createBean(name, beanDefinition);
	}
	
	protected abstract BeanDefinition getBeanDefinition(String beanName);
	
	protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
	
}