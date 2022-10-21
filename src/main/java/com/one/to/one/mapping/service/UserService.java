package com.one.to.one.mapping.service;

import java.util.List;
import java.util.Optional;

import com.one.to.one.mapping.entity.User;
import com.one.to.one.mapping.entity.UserProfile;

public interface UserService {
    User saveUser(User user,UserProfile userProfile);
   List<User>  getAllUsers();
   Optional<User> getUserId(long id);
  public void deleteUserid(long id);
 User updateUser(User user ,long id);
 public boolean isStudentExixt(long id);
}
