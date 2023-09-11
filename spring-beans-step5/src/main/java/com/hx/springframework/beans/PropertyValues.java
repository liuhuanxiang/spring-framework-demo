package com.hx.springframework.beans;

import java.util.ArrayList;
import java.util.List;

public class PropertyValues {
	
	private final List<PropertyValue> propertyValueList = new ArrayList<>();
	
	public void addPropertyValue(PropertyValue propertyValue) {
		this.propertyValueList.add(propertyValue);
	}
	
	//根据propertyName获取对应的propertyValue
	public PropertyValue getPropertyValue(String propertyName) {
		for (PropertyValue propertyValue : this.propertyValueList) {
			if (propertyValue.getName().equals(propertyName)) {
				return propertyValue;
			}
		}
		return null;
	}
	
	public PropertyValue[] getPropertyValues() {
		return propertyValueList.toArray(new PropertyValue[0]);
	}
}
