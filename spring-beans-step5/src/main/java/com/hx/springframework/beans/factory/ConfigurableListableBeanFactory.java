package com.hx.springframework.beans.factory;

import com.hx.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.hx.springframework.beans.factory.config.BeanDefinition;
import com.hx.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends  ListableBeanFactory, ConfigurableBeanFactory, AutowireCapableBeanFactory {

	BeanDefinition getBeanDefinition(String beanName);
}
