package com.bluebikGlobal.controller;


import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluebikGlobal.entity.User;
import com.bluebikGlobal.repository.UserRepository;

@RestController
public class UserController {
	private final AtomicLong userIdGenerator = new AtomicLong(0);
	
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
    	
        if (user.getName() == null || user.getName().isEmpty()) {
        	
            return ResponseEntity.badRequest().build();
            
        }
        

        Long userId = userIdGenerator.incrementAndGet();
        user.setUserId(userId);
        userRepository.save(user);

        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}

