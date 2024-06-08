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

import com.example.Entity.ContactUs;
import com.example.Repository.ContectUsRepository;
import com.example.Service.ContactUsSevice;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class ContactUsController {

	private static final Class<Integer> Integer = null;
	@Autowired
	private ContactUsSevice contactUsSevice;
	
	/*----------------------- add-new-contact -----------------------*/
	@PostMapping("/save-contact")
	public ResponseEntity<ContactUs> createContactUs(@RequestBody ContactUs contactUs){
		ContactUs savedContactUs = contactUsSevice.saveContactUs(contactUs);
		return ResponseEntity.ok(savedContactUs);
	}
	
	/*-----------------------get-All-contact-----------------------*/
	
	@GetMapping("/get-all-contact-list")
	public List<ContactUs> getContactUs(){
		return contactUsSevice.getAllContactUs();
	}
		
	/*-----------------------get-contact-By-Id-----------------------*/
	@GetMapping("/get-contact/{id}")
	public ContactUs getContactById(@PathVariable("id")int id) {
		return contactUsSevice.getContactById(id);
	}
	
	/*-----------------------delete-contact-By-Id-----------------------*/
	@DeleteMapping("/delete-contact/{id}")
	public ContactUs deleteContact(@PathVariable("id")int id) {
		return contactUsSevice.deleteContactUsById(id);
	}
	
	
	
    /*-----------------------Update-contact-By-Id-----------------------*/
    @PutMapping("/update-contact/{id}")
    public ResponseEntity<ContactUs> updateContactById(@PathVariable("id") int id, @RequestBody ContactUs updatedContact) {
        ContactUs existingContact = contactUsSevice.getContactById(id);
        if (existingContact != null) {
            updatedContact.setId(id); // Set the ID of the updated contact
            ContactUs updatedContactUs = contactUsSevice.updateContactById(updatedContact, id);
            return ResponseEntity.ok(updatedContactUs);
        } else {
            // Handle the case where the ContactUs with the given id doesn't exist
            return ResponseEntity.notFound().build();
        }
    }

}
