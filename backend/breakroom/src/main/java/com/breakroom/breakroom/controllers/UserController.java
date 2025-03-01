package com.breakroom.breakroom.controllers;

import com.breakroom.breakroom.models.ERoles;
import com.breakroom.breakroom.models.Roles;
import com.breakroom.breakroom.models.User;
import com.breakroom.breakroom.payloads.requests.SignupRequest;
import com.breakroom.breakroom.repositories.RolesRepo;
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
	UserRepo userRepo;

	@Autowired
	RolesRepo rolesRepo;

	@Autowired
	PasswordEncoder encoder;


	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody SignupRequest request) {
		if (userRepo.existsByUsername(request.getUsername())) {
			return ResponseEntity.badRequest().body("this username is taken");
		}
		if (userRepo.existsByEmail(request.getEmail())) {
			return ResponseEntity.badRequest().body("this email is already in use");
		}

		User user = new User(request.getUsername(), request.getEmail(), encoder.encode(request.getPassword()));

		Set<String> strRoles = request.getRoles();
		Set<Roles> roles = new HashSet<>();

		if (strRoles==null) {
			Roles anon = (rolesRepo.findByName(ERoles.ROLE_ANONYMOUS)
					.orElseThrow(() -> new RuntimeException("this role doesn't exist")));
			roles.add(anon);
		}
		else {
			strRoles.forEach(role -> {
				switch (role) {
					case "admin":
						Roles adminRole = rolesRepo.findByName(ERoles.ROLE_ADMIN)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(adminRole);

						break;
					case "mod":
						Roles userRole = rolesRepo.findByName(ERoles.ROLE_USER)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(userRole);

						break;
					default:
						Roles anonRole = rolesRepo.findByName(ERoles.ROLE_ANONYMOUS)
								.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
						roles.add(anonRole);
				}
			});
		}
		user.setRoles(roles);
		userRepo.save(user);
		return ResponseEntity.ok("user " + user +" has been saved");
	}

}
