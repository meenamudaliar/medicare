package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Medicines;
import com.example.demo.model.Users;
import com.example.demo.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")

public class UserController {
	@Autowired
	private UserRepository userRepository;
	@PostMapping("/users")
	public Users createUsers(@RequestBody Users users) throws Exception {
		String tempusername=users.getUsername();
		if(tempusername !=null && !"".equals(tempusername)) {
			Users userObj=userRepository.findByUsername(tempusername);
			if(userObj!=null) {
				throw new Exception("user with"+tempusername+"is already exist");
			}
		}
		Users userObj=null;
		 userRepository.save(users);
		return userObj;
	}
	
	
	  @PostMapping("/login") public Users loginUsers(@RequestBody Users users)
	  throws Exception { 
		  String uname=users.getUsername(); 
		String  pass=users.getPassword();
		  Users userObj=null; if(uname!=null&&pass!=null) {
	  userObj=userRepository.findByUsernameAndPassword(uname,pass);
	  
	  } if(userObj==null) { 
		  throw new Exception("Bad credentials");
		  }
	  
	  return userObj;
	  }
	 

}
