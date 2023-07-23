package com.malunjkar.factory;

import com.malunjkar.service.UserService;
import com.malunjkar.service.UserServiceImp;

public class UserServiceFactory {

	private static UserService  userService;
	
	static {
		  userService=new UserServiceImp();
	}
	public static UserService getUserService() {
		return userService;
	}
}
