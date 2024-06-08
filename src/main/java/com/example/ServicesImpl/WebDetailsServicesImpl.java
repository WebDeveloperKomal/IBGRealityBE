package com.example.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.WebDetails;
import com.example.Repository.WebDetailsRepository;
import com.example.Service.WebDetailsService;

@Service
public class WebDetailsServicesImpl implements WebDetailsService{

	@Autowired
	private WebDetailsRepository webDetailsRepository;
	
	@Override
	public WebDetails saveWebDetails(WebDetails webDetails) {
		return webDetailsRepository.save(webDetails);
	}

	@Override
	public List<WebDetails> getAllWebDetails() {
		return webDetailsRepository.findAll();
	}

	@Override
	public WebDetails updateWebDetailsById(WebDetails webDetails, int id) {
		webDetails.setId(id);
		return webDetailsRepository.save(webDetails);
	}

}
