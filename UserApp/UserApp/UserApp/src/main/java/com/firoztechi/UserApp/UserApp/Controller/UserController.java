package com.firoztechi.UserApp.UserApp.Controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.firoztechi.UserApp.UserApp.Entity.Users;
import com.firoztechi.UserApp.UserApp.Model.ResponseModel;
import com.firoztechi.UserApp.UserApp.Model.UserModel;
import com.firoztechi.UserApp.UserApp.Service.UserServiceImpl;
import com.firoztechi.UserApp.UserApp.Utility.AppUtility;

@RestController
@RequestMapping("/users")

public class UserController {
    
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired 
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/addUser")
	public ResponseModel saveUser(@RequestBody Users users) {
		ResponseModel response=new ResponseModel();
		try {  
			UserModel dbuser=userService.findUserById(users.getLoginUser());	   
			 if(dbuser==null) {
				 String encryptPass=passwordEncoder.encode(users.getPassword());
				 users.setPassword(encryptPass);
				 userService.addUser(users);
				 response.setSuccess(AppUtility.SUCCESS_MESSAGE);
			 }
			 else {
				 response.setErrorMsg("Record Already Present"); 
			 }
		}
		catch(Exception e) {
			response.setErrorMsg(e.getLocalizedMessage());
		}
	return response;
	}

	@PostMapping("/login")
	public ResponseModel userLogin(@RequestBody Users users,HttpSession session) {
		ResponseModel response=new ResponseModel();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getLoginUser(),users.getPassword()));
			
			UserModel dbuser=userService.findUserById(users.getLoginUser());
		
			if(dbuser!=null) {
				session.setAttribute("loginUser", users.getLoginUser());
				session.setAttribute("UserRole", users.getUserRole()); 
				session.setAttribute("UserName", users.getUserName()); 	
					response.setSuccess(AppUtility.LOGIN_SUCEESS);	
					response.setContent(dbuser);
			   }			
		}
		catch(Exception e) {
			response.setErrorMsg(e.getLocalizedMessage());
		}
	return response;
	}
	@PostMapping("/logout")
	public ResponseModel userLogout(HttpSession session)throws Exception {
		ResponseModel response=new ResponseModel();
		try {
		session.invalidate(); 
		response.setSuccess(AppUtility.LOGOUT_SUCCESS );
		}
		catch(Exception e) {
			throw new Exception(e.getLocalizedMessage());
		}
	return response;
	}
 
}
