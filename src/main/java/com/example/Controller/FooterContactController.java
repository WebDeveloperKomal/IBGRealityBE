package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Comment;
import com.example.Entity.FooterContact;
import com.example.Service.CommentService;
import com.example.Service.FooterContactService;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class FooterContactController {

private static final Class<Integer> Integer = null;
	
	@Autowired
	private FooterContactService footerContactService;
	
	
	@PostMapping("/save-footer-Contact")
	public ResponseEntity<FooterContact> saveFooterContact(@RequestBody FooterContact footerContact){
	FooterContact saveFooterContact = footerContactService.saveFooterContact(footerContact);
		return ResponseEntity.ok(saveFooterContact);
	}
	
	@GetMapping("/get-all-footer-Contact")
	public List<FooterContact> getallFooterContact(){
		return footerContactService.getAllFooterContact();
	}
	
	@GetMapping("/get-footer-Contact/{id}")
	public FooterContact getFooterContactById(@PathVariable("id")int id) {
		return footerContactService.getFooterContactById(id);
	}
	
	@DeleteMapping("/delete-footer-Contact/{id}")
	public FooterContact deleteCommentByIdComment(@PathVariable("id")int id) {
		return footerContactService.deleteFooterContactUsById(id);
	}
	
	@PutMapping("/update-footer-Contact/{id}")
	public ResponseEntity<FooterContact> updateFooterContactById(@PathVariable("id")int id , @RequestBody FooterContact footerContact){
		FooterContact footer = footerContactService.getFooterContactById(id);
		if(footer != null) {
			footerContact.setId(id);
			FooterContact updategetFooterContact = footerContactService.updateFooterContactById(footerContact, id);
			return ResponseEntity.ok(updategetFooterContact);
		}else {
			return ResponseEntity.notFound().build();
			}
	}
}
