package com.example.ServicesImpl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.FooterContact;
import com.example.Repository.FooterContactRepository;
import com.example.Service.FooterContactService;

@Service
public class FooterContactServiceImpl implements FooterContactService{
	
	@Autowired
	private FooterContactRepository footerContactRepository;

	@Override
	public FooterContact saveFooterContact(FooterContact footerContact) {
		// TODO Auto-generated method stub
		return footerContactRepository.save(footerContact);
	}

	@Override
	public List<FooterContact> getAllFooterContact() {
		// TODO Auto-generated method stub
		return footerContactRepository.getAll();
	}

	@Override
	public FooterContact getFooterContactById(int id) {
		// TODO Auto-generated method stub
		return footerContactRepository.findById(id);
	}

	@Override
	public FooterContact deleteFooterContactUsById(int id) {
		// TODO Auto-generated method stub
		FooterContact footerContact = footerContactRepository.findById(id);
		footerContact.setDeleted(true);
		return footerContactRepository.save(footerContact);
	}

	@Override
	public FooterContact updateFooterContactById(FooterContact footerContact, int id) {
		// TODO Auto-generated method stub
		footerContact.setId(id);
		return footerContactRepository.save(footerContact);
	}

}
