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
	protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
		Object bean = null;
		try {
			bean = createBeanInstance(beanDefinition, beanName, args);
			applyPropertyValues(beanName, bean, beanDefinition);
		} catch (Exception e) {
			throw new BeansException("Instantiation of bean failed", e);
		}
		return bean;
	}
	
	protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
		Constructor constructor = null;
		Class beanClass = beanDefinition.getBeanClass();
		for (Constructor declaredConstructor : beanClass.getDeclaredConstructors()) {
			if (null != args && declaredConstructor.getParameterTypes().length == args.length) {
				constructor = declaredConstructor;
				break;
			}
		}
		return getInstantiationStrategy().instantiate(beanDefinition, beanName, constructor, args);
	}
	
	protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
		PropertyValues propertyValues = beanDefinition.getPropertyValues();
		for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
			String name = propertyValue.getName();
			Object value = propertyValue.getValue();
			if (value instanceof BeanReference) {
				BeanReference beanReference = (BeanReference) value;
				value = getBean(beanReference.getBeanName());
			}
			BeanUtil.setProperty(bean, name, value);
		}
	}
	
	public InstantiationStrategy getInstantiationStrategy() {
		return instantiationStrategy;
	}
	
	public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
		this.instantiationStrategy = instantiationStrategy;
	}
}
