package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.WebDetails;
import com.example.Service.WebDetailsService;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class WebDetailsController {

	@Autowired
	private WebDetailsService webDetailsService;
	
	@PostMapping("/save-details")
	public ResponseEntity<WebDetails> saveDetails(@RequestBody WebDetails webDetails){
		WebDetails saveDetails = webDetailsService.saveWebDetails(webDetails);
		return ResponseEntity.ok(saveDetails);
	}
	
	@GetMapping("/get-details")
	public List<WebDetails> getDetails(){
		return webDetailsService.getAllWebDetails();
	}
	
	
	 @PutMapping("/update/{id}")
	    public ResponseEntity<WebDetails> updateWebDetailsById(@PathVariable int id, @RequestBody WebDetails webDetails) {
	        WebDetails updatedWebDetails = webDetailsService.updateWebDetailsById(webDetails, id);
	        return ResponseEntity.ok(updatedWebDetails);
	    }	
}
