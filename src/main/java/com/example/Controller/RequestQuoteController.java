package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.RequestQuote;
import com.example.Service.RequestQuoteService;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class RequestQuoteController {

	@Autowired
	private RequestQuoteService requestQuoteService;
	
//	*************** Save Quote ****************
	@PostMapping("save-quote")
	public ResponseEntity<RequestQuote> createQuote(@RequestBody RequestQuote requestQuote){
		RequestQuote saveQuote = requestQuoteService.saveRequestQuote(requestQuote);
		 return ResponseEntity.ok(saveQuote);
	}
	
	
//	*************** Get All Quote ****************
	@GetMapping("/get-all-quote")
	public List<RequestQuote> getQuotes(){
		return requestQuoteService.getAllQuotesList();
	}
	
	
//	*************** Get Quote By Id ****************
	@GetMapping("/get-quote/{id}")
	public RequestQuote getQuoteById(@PathVariable("id")int id) {
		return requestQuoteService.getRequestQuoteById(id);
	}
	
	
//	*************** Update Quote By Id ****************
	@PutMapping("/update-quote/{id}")
	public ResponseEntity<RequestQuote> updateQuoteById(@PathVariable("id")int id , @RequestBody RequestQuote updateQuote){
		RequestQuote requestQuote = requestQuoteService.getRequestQuoteById(id);
		if(requestQuote != null) {
			updateQuote.setId(id);
			RequestQuote updateRequestQuote = requestQuoteService.updateRequestQuoteById(updateQuote, id);
			return ResponseEntity.ok(updateRequestQuote);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
//	*************** Delete Quote By Id ****************
	@DeleteMapping("/delete-quote/{id}")
	public RequestQuote deleteQuote(@PathVariable("id")int id) {
		return requestQuoteService.deleteRequestQuoteById(id);
	}
	
}
