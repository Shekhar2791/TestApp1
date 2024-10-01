package com.ex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ex.entity.User;
import com.ex.repo.UserRepo;

@RestController
@RequestMapping("/r")
public class UserRegController {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	PasswordEncoder encoder;
	
	int count = 0;
	
	@PostMapping("/regi/user")
	public User addUser(@RequestBody User user) {
		System.out.println(user + "called");
		if(count == 0) {
			User obj = createUser();
	
		
		if(obj != null)
		System.out.println(user + "called");
		user.setPassword(encoder.encode(user.getPassword()));	}
		return repo.save(user);		
	}
	
	public User createUser() {
		
		System.out.println("createUser called");
		User u= new User();
		u.setUsername("rani5");
		u.setEmail("rani5@gmail.com");
		u.setMobile(5555);
		u.setPassword(encoder.encode("12356"));
		u.setRole("user");
		count++;
		return repo.save(u);		
	}
}
