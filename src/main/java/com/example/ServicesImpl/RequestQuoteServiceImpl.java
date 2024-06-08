package com.example.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.RequestQuote;
import com.example.Repository.RequestQuoteRepository;
import com.example.Service.EmailService;
import com.example.Service.RequestQuoteService;

@Service
public class RequestQuoteServiceImpl implements RequestQuoteService {
	
	@Autowired
	private RequestQuoteRepository requestQuoteRepository;
	
	@Autowired
	private EmailService emailService;

	@Override
	public RequestQuote saveRequestQuote(RequestQuote requestQuote) {
	    RequestQuote savedQuote = requestQuoteRepository.save(requestQuote);
	    
	    // Construct the email content
	    String emailContent = String.format(
	        "Dear %s,\n\n" +
	        "Thank you for contacting us. Here are the details you provided:\n\n" +
	        "Company Name: %s\n" +
	        "Website: %s\n" +
	        "Phone Number: %s\n" +
	        "Location: %s\n" +
	        "Purpose: %s\n" +
	        "Contract: %s\n" +
	        "Area (Sq.Ft): %s\n" +
	        "Email: %s\n\n" +
	        "We will calculate your area and get back to you shortly.\n\n" +
	        "Best regards,\nIBG Reality",
	        savedQuote.getCompanyName(),
	        savedQuote.getCompanyName(),
	        savedQuote.getWebsite(),
	        savedQuote.getPhoneNumber(),
	        savedQuote.getLocation(),
	        savedQuote.getPurpose(),
	        savedQuote.getContract(),
	        savedQuote.getAreaSqft(),
	        savedQuote.getEmail()
	    );

	    // Send thank you email
	    emailService.sendThankYouEmail(
	        savedQuote.getEmail(), 
	        "Thank you for your inquiry", 
	        emailContent
	    );

	    return savedQuote;
	}

	@Override
	public List<RequestQuote> getAllQuotesList() {
		// TODO Auto-generated method stub
		return requestQuoteRepository.getAll();
	}

	@Override
	public RequestQuote getRequestQuoteById(int id) {
		// TODO Auto-generated method stub
		return requestQuoteRepository.findById(id);
	}

	@Override
	public RequestQuote deleteRequestQuoteById(int id) {
		// TODO Auto-generated method stub
		RequestQuote requestQuote = requestQuoteRepository.findById(id);
		requestQuote.setDeleted(true);
		return requestQuoteRepository.save(requestQuote);
	}

	@Override
	public RequestQuote updateRequestQuoteById(RequestQuote requestQuote, int id) {
		// TODO Auto-generated method stub
		requestQuote.setId(id);
		return requestQuoteRepository.save(requestQuote);
	}

}
