package com.hx.springframework.beans.factory.config;

public interface SingletonBeanRegistry {

	Object getSingleton(String beanName);
}
