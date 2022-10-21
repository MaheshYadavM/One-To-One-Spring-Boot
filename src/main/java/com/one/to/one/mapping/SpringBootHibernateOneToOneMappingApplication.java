package com.one.to.one.mapping;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.one.to.one.mapping.entity.User;
import com.one.to.one.mapping.entity.UserProfile;
import com.one.to.one.mapping.repositary.UserProfileRepositary;
import com.one.to.one.mapping.repositary.UserRepositary;

@SpringBootApplication
public class SpringBootHibernateOneToOneMappingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateOneToOneMappingApplication.class, args);
	}
	@Autowired
private UserRepositary userRepositary;
	@Autowired
private UserProfileRepositary userProfileRepositary;

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setName("Radhika");
		user.setEmail("radhika@gmail.com");
		
		UserProfile userProfile=new UserProfile();
		
		userProfile.setAddress("Hyderabad");
		userProfile.setDateOfBrith(LocalDate.of(1999, 03, 30));
		userProfile.setGender("male");
	userProfile.setMobileNumber("2323232323");
	user.setUserProfile(userProfile);
	//userProfile.setUser(user);
		userRepositary.save(user);
	}

}
