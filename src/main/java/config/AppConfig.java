package config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.cyl.demo.dao.UserDao;
import com.cyl.demo.dao.impl.UserDaoCache;
import com.cyl.demo.dao.impl.UserDaoNormal;
import com.cyl.demo.service.UserService;
import com.cyl.demo.service.impl.UserServiceNormal;

//for use in javaconfig in contrast to auto injection
//example: when using third party dao and jar package where we cannot
//add @Repository in the class

@Configuration
public class AppConfig {
	// Spring scan 'Bean' and construct object

	@Bean("normal")
	public UserDao userDaoNormal() {
		System.out.println("construct UserDao instance ...");
		return new UserDaoNormal();
	}
	
	@Bean ("cache")	 
	  public UserDao userDaoCache() {
	  System.out.println("construct UserDaoCache instance ..."); 
	  return new UserDaoCache(); }

	// Spring use constructed bean
//	@Bean
//	public UserService userServiceNormal(UserDao userDao) {
//		System.out.println("construct UserService instance ...");
//		//UserDao userDao = userDaoNormal();
//		return new UserServiceNormal(userDao);
//	}

	// use setter to instantiate bean with UserDao object
	
	@Bean
	public UserService userServiceNormal(@Qualifier("cache") UserDao userDao) {
		UserServiceNormal userServiceNormal = new UserServiceNormal();
		userServiceNormal.setUserDao(userDao);
		return userServiceNormal;
	}

	
	  
	 
}
