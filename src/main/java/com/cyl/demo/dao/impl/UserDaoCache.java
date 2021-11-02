package com.cyl.demo.dao.impl;

import com.cyl.demo.dao.UserDao;

public class UserDaoCache implements UserDao {

	public void add() {
		System.out.println("add user to memory ... ");
		
	}

}
