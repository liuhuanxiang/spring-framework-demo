package com.hx.springframework.beans.factory.support;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry {

	private Map<String, Object> singletonObjects = new HashMap<>();
	
	public Object getSingleton(String beanName) {
		return singletonObjects.get(beanName);
	}
	
	protected void addSingleton(String beanName, Object singletonObject) {
		singletonObjects.put(beanName, singletonObject);
	}
}
