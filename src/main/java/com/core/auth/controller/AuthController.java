package com.core.auth.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.auth.model.request.LoginRequest;
import com.core.auth.model.request.SignupRequest;
import com.core.auth.model.response.JwtResponse;
import com.core.auth.model.response.MessageResponse;
import com.core.common.entity.UserDVO;
import com.core.common.enums.ERole;
import com.core.common.service.UserService;
import com.core.security.jwt.JwtUtils;
import com.core.security.services.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authenticationManager;

	private final UserService userService;

	private final PasswordEncoder encoder;
	
	private final JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		String roles = ((List<SimpleGrantedAuthority>) userDetails.getAuthorities()).get(0).toString();
		return ResponseEntity.ok(new JwtResponse(jwt, 
				 userDetails.getUserId(), 
				 userDetails.getUsername(), 
				 userDetails.getEmail(), 
				 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
		if (userService.existsByUserName(signupRequest.getUserName())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userService.existsByEmail(signupRequest.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already taken!"));
		}

		UserDVO userDVO = new UserDVO(signupRequest.getUserName(), signupRequest.getEmail(),
				encoder.encode(signupRequest.getPassword()));
		userService.save(userDVO);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}
}
