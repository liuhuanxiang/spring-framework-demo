package com.hx.springframework.util;

public class ClassUtils {
	
	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			// Try to get the context class loader...
			cl = Thread.currentThread().getContextClassLoader();
		} catch (Exception e) {
			// Cannot access thread context ClassLoader - falling back to system class loader...
		}
		if (cl == null) {
			// No thread context class loader  -> us class loader of this class
			cl = ClassUtils.class.getClassLoader();
		}
		return cl;
	}
	
}
