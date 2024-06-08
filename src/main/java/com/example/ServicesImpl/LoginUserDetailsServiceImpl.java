package com.example.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Entity.LoginUserDetails;
import com.example.Repository.LoginUserDetailsRepository;
import com.example.Service.LoginUserDetailsService;

@Service
public class LoginUserDetailsServiceImpl  implements LoginUserDetailsService{

	@Autowired
	private LoginUserDetailsRepository loginUserDetailsRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
		
	@Override
	public LoginUserDetails saveLoginUserDetails(LoginUserDetails loginUserDetails) {
		loginUserDetails .setPassword(passwordEncoder.encode(loginUserDetails.getPassword()));
		LoginUserDetails saveloginUserDetailsData = loginUserDetailsRepository.save(loginUserDetails);
		return saveloginUserDetailsData;
	}

	@Override
	public List<LoginUserDetails> getUserDetails() {
		// TODO Auto-generated method stub
		return loginUserDetailsRepository.findAll();
	}

 
}
