package com.hx.demo.springframework.beans.factory.support;

import com.hx.demo.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {
	
	private Map<String, Object> singletonObjectMap = new HashMap<>();
	
	@Override
	public Object getSingleton(String beanName) {
		return singletonObjectMap.get(beanName);
	}
	
	protected void addSingleton(String beanName, Object singletonObject) {
		singletonObjectMap.put(beanName, singletonObject);
	}
}
