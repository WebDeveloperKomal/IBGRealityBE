package com.example.Service;

import java.util.List;

import com.example.Entity.Testimonials;

public interface TestimonialsService {

//	Testimonials saveTestimonials(Testimonials testimonials, MultipartFile file) throws IOException;
	
	Testimonials saveTestimonials(Testimonials testimonials);
	
	List<Testimonials> getAllTestimonials();
	
	Testimonials getTestimonialsById(int id);
	
	Testimonials deleTestimonialsById(int id);
	
	Testimonials updateTestimonialsById(Testimonials testimonials, int id);
	
}
