package com.hx.springframework.beans.factory.config;

import com.hx.springframework.beans.PropertyValues;

public class BeanDefinition {
	
	private Class beanClass;
	
	private PropertyValues propertyValues;
	
	//构造器
	public BeanDefinition(Class beanClass) {
		this.beanClass = beanClass;
		this.propertyValues = new PropertyValues();
	}
	
	public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
		this.beanClass = beanClass;
		this.propertyValues = propertyValues == null ? new PropertyValues() : propertyValues;
	}

	//get/set
	public Class getBeanClass() {
		return beanClass;
	}

	public void setBeanClass(Class beanClass) {
		this.beanClass = beanClass;
	}

	public PropertyValues getPropertyValues() {
		return propertyValues;
	}
}
