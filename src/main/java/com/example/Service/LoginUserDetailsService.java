package com.example.Service;

import java.util.List;

import com.example.Entity.LoginUserDetails;

public interface LoginUserDetailsService {

	LoginUserDetails saveLoginUserDetails(LoginUserDetails loginUserDetails);
	
	List<LoginUserDetails> getUserDetails();
	
	
}
