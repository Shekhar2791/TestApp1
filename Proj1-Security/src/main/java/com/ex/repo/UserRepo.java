package com.ex.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ex.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Optional<com.ex.entity.User> findByUsername(String username);

}
