package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cyl.demo.dao.UserDao;
import com.cyl.demo.dao.impl.UserDaoNormal;
import com.cyl.demo.service.UserService;
import com.cyl.demo.service.impl.UserServiceNormal;

//for use in javaconfig in contrast to auto injection
//example: when using third party dao and jar package where we cannot
//add @Repository in the class

@Configuration
public class AppConfig {
	
	@Bean
	public UserDao userDaoNormal() {
		System.out.println("construct UserDao instance ...");
		return new UserDaoNormal();
	}
	
	@Bean
	public UserService userServiceNormal(UserDao userDao) {
		System.out.println("construct UserService instance ...");
		//UserDao userDao = userDaoNormal();
		return new UserServiceNormal(userDao);
	}

}
