package com.hx.springframework.beans.factory;

public interface BeanFactory {
	
	// 获取bean
	Object getBean(String beanName);
	
	// 获取bean
	Object getBean(String beanName, Object... args);
	
}
