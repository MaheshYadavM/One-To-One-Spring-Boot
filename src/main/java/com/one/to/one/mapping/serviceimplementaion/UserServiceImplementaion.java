package com.one.to.one.mapping.serviceimplementaion;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.one.to.one.mapping.entity.User;
import com.one.to.one.mapping.entity.UserProfile;
import com.one.to.one.mapping.exception.UserNotFoundException;
import com.one.to.one.mapping.repositary.UserRepositary;
import com.one.to.one.mapping.service.UserService;
@Service
public class UserServiceImplementaion implements UserService {

	@Autowired
	private UserRepositary userRepositary;
	
	public UserServiceImplementaion(UserRepositary userRepositary) {
		super();
		this.userRepositary = userRepositary;
	}

	@Override
	public User saveUser(User user, UserProfile userProfile) {
		
		return userRepositary.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userRepositary.findAll();
	}

	@Override
	public Optional<User> getUserId(long id) {
		Optional<User> user =userRepositary.findById(id);
		return user;
		
	}

	@Override
	public void deleteUserid(long id) {
		
		userRepositary.deleteById(id);
		
	}

	@Override
	public User updateUser(User user ,long id) {
		User user1=new User();
		user1=userRepositary.findById(id).orElseThrow(() -> new UserNotFoundException());
		UserProfile userProfile1=new UserProfile();
		user1.setName(user.getName());
		user1.setEmail(user.getEmail());
		userProfile1.setId(id);
		userProfile1.setMobileNumber(user.getUserProfile().getMobileNumber());
		userProfile1.setAddress(user.getUserProfile().getAddress());
		userProfile1.setGender(user.getUserProfile().getGender());
		userProfile1.setDateOfBrith(user.getUserProfile().getDateOfBrith());
		
		user1.setUserProfile(userProfile1);
		
		return userRepositary.save(user1);
		
	}

	@Override
	public boolean isStudentExixt(long id) {
		
		return userRepositary.existsById(id);
	}


	

	

	

	

	

	

	

	
	


}
