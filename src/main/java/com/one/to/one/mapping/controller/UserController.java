package com.one.to.one.mapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.one.to.one.mapping.entity.User;
import com.one.to.one.mapping.entity.UserProfile;
import com.one.to.one.mapping.exception.UserNotFoundException;
import com.one.to.one.mapping.service.UserService;

@RestController
public class UserController {
	     
             private UserService userService;
				/*
				 * @PostMapping("/Hi") public User saveUser(@RequestBody User user) { return
				 * userService.saveUser(user); }
				 */
	       @PostMapping("/Hi")
	       public User saveUser(@RequestBody User user,UserProfile userProfile) {
	    	   return userService.saveUser(user, userProfile);
	       }
	       @PutMapping("/u")
			public User updateUser(@RequestBody User user,@RequestParam long id) {
	    	   boolean isStudentExixt = userService.isStudentExixt(id);
	    	   if(isStudentExixt) {
				return  userService.updateUser(user,id);
	    	   }
	    		 else {
	    			 throw new UserNotFoundException("User id  " +id+" is not there");
	    			}
			}
	      
	       
	       @GetMapping("/all")
	       public List<User> getAllUser(){
	    	   return userService.getAllUsers();
	       }
	       @GetMapping("/g")
	       public Optional<User> getUserById(@RequestParam long id){
	    		boolean isStudentExixt = userService.isStudentExixt(id);
	    		if(isStudentExixt) {
			return userService.getUserId(id);}
	    		 else {
	    				throw new UserNotFoundException("User id  " +id+" is not there");
	    			}
	    
	       }
	       @DeleteMapping("/d")
	       public ResponseEntity<String> deleteUserById(@RequestParam long id) {
	    	   boolean isStudentExixt = userService.isStudentExixt(id);
	    	   if(isStudentExixt) {
	    	  userService.deleteUserid(id);
	    	 return new ResponseEntity<String>("User details deleted Successfully ",HttpStatus.OK);
	    	  }
	    	   else {
	    		   throw new UserNotFoundException("User id  " +id+" is not there");	
   			}
	    	  
	       }
	       
}
