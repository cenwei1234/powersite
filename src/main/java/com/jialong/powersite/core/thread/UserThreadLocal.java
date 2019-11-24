package com.jialong.powersite.core.thread;

import com.jialong.powersite.modular.system.model.User;

public class UserThreadLocal {

	
	private static ThreadLocal<User> USERTHREAD_LOCAL = new ThreadLocal<User>();
	/**
	 * 将user对象放入本地线程中
	 * @param user
	 */
	public static void set(User user){
		USERTHREAD_LOCAL.set(user);
	}
	/**
	 * 从本地线程中获取对象
	 * @return
	 */
	public static User get(){
		return USERTHREAD_LOCAL.get();
	}
}
