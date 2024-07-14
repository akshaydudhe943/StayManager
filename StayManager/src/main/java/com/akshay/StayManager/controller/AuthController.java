package com.akshay.StayManager.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.StayManager.config.JwtProvider;
import com.akshay.StayManager.entity.HostelOwner;
import com.akshay.StayManager.repositories.HostelOwnerRepository;
import com.akshay.StayManager.request.LoginRequest;
import com.akshay.StayManager.response.AuthResponse;
import com.akshay.StayManager.services.impl.CustomUserDetailsService;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private HostelOwnerRepository hostelOwnerRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse>createUserHandler(@RequestBody HostelOwner owner) throws Exception{
		HostelOwner isEmailExist = hostelOwnerRepository.findByEmail(owner.getEmail());
		if(isEmailExist!= null) {
			throw new Exception("Email Already Exist");
		}
		
		HostelOwner createdOwner = new HostelOwner();
		createdOwner.setEmail(owner.getEmail());
		createdOwner.setName(owner.getName());
		createdOwner.setMobile(owner.getMobile());
		createdOwner.setPassword(passwordEncoder.encode(owner.getPassword()));
		
		HostelOwner savedOwner = hostelOwnerRepository.save(createdOwner);
		
		
		Authentication authentication = new UsernamePasswordAuthenticationToken(owner.getEmail(),owner.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtProvider.generateToKen(authentication);
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(jwt);
		authResponse.setMessage("Registration Successful!!");
		
		//hostelOwnerService.sendAccountCreationUpdate(jwt.toString());
		
		return new ResponseEntity<>(authResponse,HttpStatus.CREATED);
	}
	
	
	@PostMapping("/signin")
	public ResponseEntity<AuthResponse>signin(@RequestBody LoginRequest request) throws Exception{
		String userName = request.getEmail();
		String password = request.getPassword();
		
		Authentication authentication = authenticate(userName,password);
		
		Collection<? extends GrantedAuthority>authorities = authentication.getAuthorities();
		
		String jwt = jwtProvider.generateToKen(authentication);
		
		AuthResponse authResponse = new AuthResponse();
		authResponse.setJwt(jwt);
		authResponse.setMessage("SignIn Successful!!");
		
		
		
		return new ResponseEntity<>(authResponse,HttpStatus.OK);
		
	}

	private Authentication authenticate(String username, String password) {
		
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(username);
		
		if(userDetails==null) {
			throw new BadCredentialsException("invalid username..");
		}
		
		if(!passwordEncoder.matches(password,userDetails.getPassword())) {
			throw new BadCredentialsException("invalid password..");
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}

}
