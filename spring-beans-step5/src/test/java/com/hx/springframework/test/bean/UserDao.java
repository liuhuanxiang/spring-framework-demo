package com.hx.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

public class UserDao {
	
	private static Map<String, String> map = new HashMap<>();
	
	static {
		map.put("1", "1");
		map.put("2", "2");
        map.put("3", "3");
	}
	
	public  String get(String id) {
		return map.get(id);
	}
	
	
}
