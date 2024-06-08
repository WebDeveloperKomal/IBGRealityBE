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

import com.example.Entity.ContactUs;
import com.example.Entity.Testimonials;
import com.example.Service.TestimonialsService;

@Controller
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class TestimonialsController {

	private static final Class<Integer> Integer = null;
	@Autowired
	private TestimonialsService testimonialsService;

	/*
	 * @Autowired public TestimonialsController(TestimonialsService
	 * testimonialsService) { this.testimonialsService = testimonialsService; }
	 * 
	 * ----------------------- add-new-Testimonials -----------------------
	 * 
	 * @PostMapping("/save-testimonials-details") public
	 * ResponseEntity<Testimonials> createTestimonials(@RequestPart("testimonials")
	 * Testimonials testimonials,
	 * 
	 * @RequestPart("file") MultipartFile file) { try { // Set the image data from
	 * the uploaded file testimonials.setImage(file.getBytes()); Testimonials
	 * savedTestimonials = testimonialsService.saveTestimonials(testimonials);
	 * return ResponseEntity.ok(savedTestimonials); } catch (IOException e) { //
	 * Handle exception if file processing fails e.printStackTrace(); return
	 * ResponseEntity.badRequest().build(); } }
	 */

	/*----------------------- add-new-Testimonials -----------------------*/
	@PostMapping("/save-testimonials")
	public ResponseEntity<Testimonials> createTestimonials(@RequestBody Testimonials testimonials) {
		Testimonials savedTestimonials = testimonialsService.saveTestimonials(testimonials);
		return ResponseEntity.ok(savedTestimonials);
	}

	/*-----------------------get-All-Testimonials-----------------------*/

	@GetMapping("/get-all-testimonials-list")
	public List<Testimonials> getTestimonials() {
		return testimonialsService.getAllTestimonials();
	}

	/*-----------------------get-Testimonials-By-Id-----------------------*/
	@GetMapping("/get-testimonials/{id}")
	public Testimonials getTestimonialsById(@PathVariable("id") int id) {
		return testimonialsService.getTestimonialsById(id);
	}

	/*-----------------------delete-Testimonials-By-Id-----------------------*/
	@DeleteMapping("/delete-testimonials/{id}")
	public Testimonials deleteTestimonials(@PathVariable("id") int id) {
		return testimonialsService.deleTestimonialsById(id);
	}

	/*-----------------------Update-contact-By-Id-----------------------*/
	@PutMapping("/update-testimonials/{id}")
	public ResponseEntity<Testimonials> updateTestimonialsById(@PathVariable("id") int id,
			@RequestBody Testimonials updateTestimonials) {
		Testimonials existingTestimonials = testimonialsService.getTestimonialsById(id);
		if (existingTestimonials != null) {
			updateTestimonials.setId(id); // Set the ID of the updated contact
			Testimonials updatedTestimonials = testimonialsService.updateTestimonialsById(updateTestimonials, id);
			return ResponseEntity.ok(updatedTestimonials);
		} else {
			// Handle the case where the ContactUs with the given id doesn't exist
			return ResponseEntity.notFound().build();
		}
	}

}
