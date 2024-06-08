package com.example.ServicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {


    @Autowired
    private JavaMailSender emailSender;
    
	@Override
	public void sendThankYouEmail(String to, String subject, String text) {
		// TODO Auto-generated method stub
		   SimpleMailMessage message = new SimpleMailMessage(); 
	        message.setFrom("ibgreality1@gmail.com");
	        message.setTo(to); 
	        message.setSubject(subject); 
	        message.setText(text);
	        emailSender.send(message);
	}
}
