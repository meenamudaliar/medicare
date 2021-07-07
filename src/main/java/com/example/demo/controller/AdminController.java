package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Admin;
import com.example.demo.model.Users;
import com.example.demo.repository.AdminRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/")

public class AdminController {
	@Autowired
	private AdminRepository adminRepository;
	@PostMapping("/admin/login") 
	public Admin loginAdmin(@RequestBody Admin admin)
			  throws Exception { 
				  String aname=admin.getAdminname(); 
				String  pass=admin.getPassword();
				  Admin adminObj=null; if(aname!=null&&pass!=null) {
			  adminObj=adminRepository.findByAdminnameAndPassword(aname,pass);
			  
			  } if(adminObj==null) { 
				  throw new Exception("Bad credentials");
				  }
			  
			  return adminObj;
			  }
	
}
			  
			  
