package com.ex.config;

import java.util.Optional;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.ex.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<com.ex.entity.User> user= repo.findByUsername(username);
		
		
		if (user.isPresent()) {
			var u = user.get();
			return User.builder().username(u.getUsername()).password(u.getPassword()).roles(u.getRole())
				.build();
		}
		else {
			throw new UsernameNotFoundException(username);
		}
	}

}
