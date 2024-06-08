package com.example.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Testimonials;
import com.example.Repository.TestimonialsRepository;
import com.example.Service.TestimonialsService;

@Service
public class TestimonialsServicesImpl implements TestimonialsService{
	
	@Autowired
	private TestimonialsRepository testimonialsRepository;
	
	/*
	 * @Override public Testimonials updateTestimonialsById(Testimonials
	 * testimonials, int id) { // TODO Auto-generated method stub
	 * testimonials.setId(id); return testimonialsRepository.save(testimonials); }
	 * 
	 * @Override public Testimonials saveTestimonials(Testimonials testimonials,
	 * MultipartFile file) throws IOException {
	 * testimonials.setImage(file.getBytes()); return
	 * testimonialsRepository.save(testimonials); }
	 */
	
	@Override
	public Testimonials saveTestimonials(Testimonials testimonials) {
		// TODO Auto-generated method stub
		return testimonialsRepository.save(testimonials);
	}

	@Override
	public List<Testimonials> getAllTestimonials() {
		// TODO Auto-generated method stub
		return testimonialsRepository.getAll();
	}

	@Override
	public Testimonials getTestimonialsById(int id) {
		// TODO Auto-generated method stub
		return testimonialsRepository.findById(id);
	}

	@Override
	public Testimonials deleTestimonialsById(int id) {
		// TODO Auto-generated method stub
		Testimonials testimonials = testimonialsRepository.findById(id);
		testimonials.setDeleted(true);
		return testimonialsRepository.save(testimonials);
	}

	@Override
	public Testimonials updateTestimonialsById(Testimonials testimonials, int id) {
		// TODO Auto-generated method stub
		testimonials.setId(id);
		return testimonialsRepository.save(testimonials);
	}

}
