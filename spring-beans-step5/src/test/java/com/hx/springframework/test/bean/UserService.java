package com.hx.springframework.test.bean;

public class UserService {
	
	private String uId;
	private UserDao userDao;
	
	public UserService(String  uId) {
		this.uId = uId;
	}
	
	public UserService() {
	}
	
	//public UserService(UserDao userDao) {
	//	this.userDao = userDao;
	//}
	
	public UserService(String uId, UserDao userDao) {
		this.uId = uId;
		this.userDao = userDao;
	}
	
	
	//public String getuId() {
	//	return uId;
	//}
	//
	//public void setuId(String uId) {
	//	this.uId = uId;
	//}
	//
	//public UserDao getUserDao() {
	//	return userDao;
	//}
	//
	//public void setUserDao(UserDao userDao) {
	//	this.userDao = userDao;
	//}
	
	public void queryUserInfo() {
		System.out.println(userDao.get(uId));
	}
	
	@Override
	public String toString() {
		return "UserService{" + "uId='" + uId + '\'' + ", userDao=" + userDao + '}';
	}
}
