package com.iskcon.dms.controller;

import com.iskcon.dms.entity.AuthReponse;
import com.iskcon.dms.entity.LoginRequest;
import com.iskcon.dms.entity.User;
import com.iskcon.dms.exceptions.UserNotFoundException;
import com.iskcon.dms.repository.UserRepository;
import com.iskcon.dms.service.MyUserDetailsService;
import com.iskcon.dms.service.SadhanaService;
import com.iskcon.dms.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/authenticate")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) throws Exception {
        System.out.println("Login Controller");

        String userName = loginRequest.getUsername();

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,
                loginRequest.getPassword()));

        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new UserNotFoundException("User not found: " + userName));

        String token = JwtUtils.generateToken(userName);

        return ResponseEntity.ok(new AuthReponse(token,userName,
                user.getFullName(), user.getRole()));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) throws Exception {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        myUserDetailsService.addRegistration(user);
        return ResponseEntity.ok("User registered successfully");
    }
}
