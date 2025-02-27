package com.breakroom.breakroom.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.breakroom.breakroom.models.User;
import com.breakroom.breakroom.payloads.requests.CheckUserRequest;
import com.breakroom.breakroom.repositories.UserRepo;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/auth")
public class UserController {
	
	@Autowired
	UserRepo repo;
	
	//for testing purposes, do not use
	@PostMapping("/checkuser")
	public ResponseEntity<?> checkUser(@RequestBody  CheckUserRequest req){
		if(repo.existsByUsername(req.getUsername()) || repo.existsByEmail(req.getEmail())) {
			return ResponseEntity.ok("that user exists");
		}
		return ResponseEntity.badRequest().body("this user doesn't exist");
			
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> makeUser(@RequestBody @Valid CheckUserRequest req){
		if(repo.existsByUsername(req.getUsername()) || repo.existsByEmail(req.getEmail())) {
			return ResponseEntity.badRequest().body("this hoe already exists, chief");
		}
		User user = new User(req.getUsername(),req.getEmail(),req.getPassword());
		repo.save(user);
		return ResponseEntity.ok("user signed up");
		
	}
}
