package com.hx.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.hx.springframework.beans.BeansException;
import com.hx.springframework.beans.PropertyValue;
import com.hx.springframework.beans.PropertyValues;
import com.hx.springframework.beans.factory.config.BeanDefinition;
import com.hx.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {
	
	private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();
	
	
	@Override
	protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) {
		Object bean = null;
		try {
			bean = createBeanInstance(beanName, beanDefinition, args);
			//给bean填充属性
			applyPropertyValues(beanName, bean, beanDefinition);
		} catch (Exception e) {
			throw new BeansException("instantiation of bean failed", e);
		}
		addSingleton(beanName, bean);
		return bean;
	}
	
	protected Object createBeanInstance(String beanName, BeanDefinition beanDefinition, Object[] args) {
		Constructor constructorToUse = null;
		Class<?> beanClass = beanDefinition.getBeanClass();
		Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
		for (Constructor<?> ctor : declaredConstructors) {
			if (null != args && ctor.getParameterTypes().length == args.length) {
				constructorToUse = ctor;
				break;
			}
		}
		return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructorToUse, args);
	}
	
	protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
		try {
			// 1. 获取bean的属性值
			PropertyValues pvs = beanDefinition.getPropertyValues();
			// 2. 获取bean的属性值
			for (PropertyValue pv : pvs.getPropertyValues()) {
				String name = pv.getName();
				Object value = pv.getValue();
				if (value instanceof BeanReference) {
					BeanReference ref = (BeanReference) value;
					value = getBean(ref.getBeanName());
				}
				//属性填充
				BeanUtil.setProperty(bean, name, value);
			}
		} catch (Exception e) {
			throw new BeansException("Error setting property values：" + beanName, e);
		}
	}
	
	
	public InstantiationStrategy getInstantiationStrategy() {
		return instantiationStrategy;
	}
	
	public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
		this.instantiationStrategy = instantiationStrategy;
	}
}
