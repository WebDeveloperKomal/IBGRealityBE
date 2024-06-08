package com.example.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.ContactUs;
import com.example.Repository.ContectUsRepository;
import com.example.Service.ContactUsSevice;

@Service
public class ServicesImpl implements ContactUsSevice {
	
	@Autowired
	private ContectUsRepository contectUsRepository;

	@Override
	public ContactUs saveContactUs(ContactUs contactUs) {
		return contectUsRepository.save(contactUs);
		 
	}

	@Override
	public List<ContactUs> getAllContactUs() {
		return contectUsRepository.getAll();
	}

	@Override
	public ContactUs getContactById(int id) {
		return contectUsRepository.findById(id);
	}

	@Override
	public ContactUs deleteContactUsById(int id) {
	ContactUs contactUs = contectUsRepository.findById(id);
	      contactUs.setDeleted(true);
	return contectUsRepository.save(contactUs);
	}

	@Override
	public ContactUs updateContactById(ContactUs contactUs , int id) {
	      contactUs.setId(id);
	return contectUsRepository.save(contactUs);
	}

	

	

}
