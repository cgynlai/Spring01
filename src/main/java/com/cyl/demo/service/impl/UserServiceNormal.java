package com.cyl.demo.service.impl;

import com.cyl.demo.dao.UserDao;
import com.cyl.demo.service.UserService;

//if using auto DI:
//@Service
public class UserServiceNormal implements UserService {
    //if using auto DI:
	//@Autowired
	private UserDao userDao;
	
	public UserServiceNormal() {
		super();
	}
	
	//use constructor to establish relationship with UserDao
	public UserServiceNormal(UserDao userDao) {
		this.userDao = userDao;
	}

    //use setter to establish relationship with UserDao
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add() {
	
		userDao.add();
	}

	

	

}
