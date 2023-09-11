package com.hx.springframework.beans.factory.support;

import com.hx.springframework.beans.BeansException;
import com.hx.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.hx.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
		implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {
	
	private final Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();
	
	@Override
	public BeanDefinition getBeanDefinition(String beanName) {
		//先从缓存中获取
		BeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
		if (null == beanDefinition) {
			throw new BeansException("No bean named '" + beanName + "' is defined");
		}
		return beanDefinition;
	}
	
	@Override
	public boolean containsBeanDefinition(String beanName) {
		return false;
	}
	
	@Override
	public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
		Map<String, T> result = new HashMap<>();
		beanDefinitionMap.forEach((beanName, beanDefinition) -> {
			Class beanClass = beanDefinition.getBeanClass();
			if (type.isAssignableFrom(beanClass)) {
				result.put(beanName, (T) getBean(beanName));
			}
		});
		return result;
	}
	
	@Override
	public String[] getBeanDefinitionNames() {
		return new String[0];
	}
	
	@Override
	public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
		beanDefinitionMap.put(beanName, beanDefinition);
	}
}
