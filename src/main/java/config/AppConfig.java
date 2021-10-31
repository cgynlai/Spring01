package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cyl.demo.dao.UserDao;
import com.cyl.demo.dao.impl.UserDaoNormal;

//for use in javaconfig in contrast to auto injection
//example: when using third party dao and jar package where we cannot
//add @Repository in the class

@Configuration
public class AppConfig {
	
	@Bean
	public UserDao userDaoNoraml() {
		System.out.println("construct UserDao instance ...");
		return new UserDaoNormal();
	}

}
