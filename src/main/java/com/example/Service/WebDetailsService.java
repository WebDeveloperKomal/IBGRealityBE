package com.example.Service;

import java.util.List;

import com.example.Entity.WebDetails;

public interface WebDetailsService {

	WebDetails saveWebDetails(WebDetails webDetails);
	
	List<WebDetails> getAllWebDetails();
	
	
	WebDetails updateWebDetailsById(WebDetails webDetails , int id);
}
