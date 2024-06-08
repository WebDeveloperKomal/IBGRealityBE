package com.example.Service;

import java.util.List;

import com.example.Entity.RequestQuote;

public interface RequestQuoteService {
	
	RequestQuote saveRequestQuote(RequestQuote requestQuote);
	
	List<RequestQuote> getAllQuotesList();
	
	RequestQuote getRequestQuoteById(int id);
	
	RequestQuote deleteRequestQuoteById(int id);
	
	RequestQuote updateRequestQuoteById(RequestQuote requestQuote,int id);
	
	

}
