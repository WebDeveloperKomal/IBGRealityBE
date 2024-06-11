package com.example.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Repository.LoginUserDetailsRepository;
import com.example.Service.LoginUserDetailsService;
import com.example.Entity.*;
import com.example.model.JwtRequest;
import com.example.model.JwtResponse;
import com.example.util.JwtHelper;

import ch.qos.logback.classic.Logger;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class LoginUserDetailsController {
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LoginUserDetailsRepository loginUserDetailsRepository;
	
	@Autowired
    private UserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtHelper jwtHelper;
	
	@Autowired
	private LoginUserDetailsService loginUserDetailsService;
	

	private org.slf4j.Logger logger = LoggerFactory.getLogger(AuthenticationManager.class);
	
	/*-----------------------add-new-user-----------------------*/
	@PostMapping(value = ("/add-new-user"))
	private ResponseEntity<Map<String, Object>> saveSlides(@RequestBody String data) {
		Map<String, Object> response = new HashMap<>();
//		LoginUserDetails loginUserDetails = (LoginUserDetails) authentication.getPrincipal();
		try {
			org.json.simple.parser.JSONParser parser = new org.json.simple.parser.JSONParser();
			JSONObject json = (JSONObject) parser.parse(data);

			LoginUserDetails user = new LoginUserDetails();
			user.setName(json.get("name").toString());
			user.setL_name(json.get("lastName").toString());
			user.setNumber(json.get("number").toString());
			user.setEmail(json.get("email").toString());
			user.setPassword(passwordEncoder.encode(json.get("password").toString()));

			loginUserDetailsRepository.save(user);
			response.put("status", true);
			response.put("data", "Record saved");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.put("status", false);
			response.put("error", ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*----------------------- login-user -----------------------*/
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {
		this.doAuthenticate(request.getEmail(), request.getPassword());
		UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
		String token = this.jwtHelper.generateToken(userDetails);

		JwtResponse response = JwtResponse.builder().jwtToken(token).username(userDetails.getUsername()).build();
		/* .username(userDetails.getUsername()).build(); */
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String email, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
		try {
			authenticationManager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}
	}
	
	@PostMapping("/save-user")
	public ResponseEntity<LoginUserDetails> saveLoginUserDetails(@RequestBody LoginUserDetails loginUserDetails){
	LoginUserDetails saveLoginUserDetails = loginUserDetailsService.saveLoginUserDetails(loginUserDetails);
		return ResponseEntity.ok(saveLoginUserDetails);
	}
	
	
	/*-----------------------get-all-users-----------------------*/
	@GetMapping(value = "/get-all")
	private ResponseEntity<Map<String, Object>> getAllUsers() {
		Map<String, Object> response = new HashMap<>();

		try {
			List<LoginUserDetails> users = loginUserDetailsRepository.findAll();
			response.put("status", true);
			response.put("data", users);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception ex) {
			response.put("status", false);
			response.put("error", ex.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
