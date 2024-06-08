package com.example.Service;

import java.util.List;

import com.example.Entity.ContactUs;

public interface ContactUsSevice {

	ContactUs saveContactUs(ContactUs contactUs);
	
	List<ContactUs> getAllContactUs();
	
	ContactUs getContactById(int id);
	
	ContactUs  deleteContactUsById(int id);

	ContactUs updateContactById(ContactUs contactUs, int id);
}
