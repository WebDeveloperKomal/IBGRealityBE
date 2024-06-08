package com.example.Service;

import java.util.List;

import com.example.Entity.ContactUs;
import com.example.Entity.FooterContact;

public interface FooterContactService {
	
	FooterContact saveFooterContact(FooterContact footerContact);
	
	List<FooterContact> getAllFooterContact();
	
	FooterContact getFooterContactById(int id);
	
	FooterContact deleteFooterContactUsById(int id);
	
	FooterContact updateFooterContactById(FooterContact footerContact ,int id );

}
