package com.hx.springframework.beans.factory.support;

import com.hx.springframework.core.io.DefaultResourceLoader;
import com.hx.springframework.core.io.ResourceLoader;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{
	
	private BeanDefinitionRegistry registry;
	
	private ResourceLoader resourceLoader;
	
	protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
		this(registry, new DefaultResourceLoader());
	}
	
	public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
		this.registry = registry;
		this.resourceLoader = resourceLoader;
	}
	
	public BeanDefinitionRegistry getRegistry() {
		return registry;
	}

	public ResourceLoader getResourceLoader() {
		return resourceLoader;
	}

}
