package com.breakroom.breakroom.controllers;

import com.breakroom.breakroom.models.ERoles;
import com.breakroom.breakroom.models.Roles;
import com.breakroom.breakroom.models.User;
import com.breakroom.breakroom.payloads.requests.LoginRequest;
import com.breakroom.breakroom.payloads.requests.SignupRequest;
import com.breakroom.breakroom.repositories.RolesRepo;
import com.breakroom.breakroom.services.UserAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.breakroom.breakroom.repositories.UserRepo;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/auth")
public class UserController {

	@Autowired
	UserAuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request) {
		return authService.signup(request);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginRequest request){
		return authService.login(request);
	}

}
