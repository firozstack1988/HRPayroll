package com.firoztechi.UserApp.UserApp.Service;

import com.firoztechi.UserApp.UserApp.Entity.Users;
import com.firoztechi.UserApp.UserApp.Model.UserModel;

public interface UserService {
   
	public void addUser(Users userDetail) throws Exception;
	public UserModel findUserById(String userId) throws Exception;
}
