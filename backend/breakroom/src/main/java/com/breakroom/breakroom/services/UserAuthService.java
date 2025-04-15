package com.breakroom.breakroom.services;

import com.breakroom.breakroom.models.ERoles;
import com.breakroom.breakroom.models.Roles;
import com.breakroom.breakroom.models.User;
import com.breakroom.breakroom.payloads.requests.LoginRequest;
import com.breakroom.breakroom.payloads.requests.SignupRequest;
import com.breakroom.breakroom.payloads.responses.loginResponse;
import com.breakroom.breakroom.repositories.RolesRepo;
import com.breakroom.breakroom.repositories.UserRepo;
import com.breakroom.breakroom.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserAuthService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RolesRepo rolesRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    AuthenticationManager authenticationManager;



    public ResponseEntity<?> signup(SignupRequest request){
        if (userRepo.existsByUsername(request.getUsername())) {
            return ResponseEntity.badRequest().body("this username is taken");
        }
        if (userRepo.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().body("this email is already in use");
        }

        User user = new User(request.getUsername(), request.getEmail(), encoder.encode(request.getPassword()));

        Set<String> strRoles = request.getRoles();
        Set<Roles> roles = new HashSet<>();

        if (strRoles==null || strRoles.isEmpty()) {
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
        return ResponseEntity.ok("user has been saved");

    }

    public ResponseEntity<?> login(LoginRequest request){
        if (!userRepo.existsByUsername(request.getUsername())){
            return ResponseEntity.badRequest().body("this username doesn't exist");
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));

        if (!authentication.isAuthenticated())
            return ResponseEntity.badRequest().body("the password is wrong");

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return ResponseEntity.ok(new loginResponse(
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getId(),
                roles
        ));
    }

}
