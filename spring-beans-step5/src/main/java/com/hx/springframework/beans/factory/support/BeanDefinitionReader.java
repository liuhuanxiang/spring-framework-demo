package com.hx.springframework.beans.factory.support;

import com.hx.springframework.beans.BeansException;
import com.hx.springframework.core.io.Resource;
import com.hx.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {
	
	BeanDefinitionRegistry getRegistry();
	
	ResourceLoader getResourceLoader();
	
	void loadBeanDefinitions(Resource resource) throws BeansException;
	
	void loadBeanDefinitions(Resource... resources) throws BeansException;
	
	void loadBeanDefinitions(String location) throws BeansException;
	
}
