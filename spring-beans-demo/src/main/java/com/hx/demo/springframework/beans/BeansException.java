package com.hx.demo.springframework.beans;

public class BeansException extends RuntimeException{
	
	public BeansException(String message) {
		super(message);
	}
	
	public BeansException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
