package com.example.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.Entity.ContactUs;
import com.example.Entity.Testimonials;
import com.example.Repository.TestimonialsRepository;
import com.example.Service.TestimonialsService;

@Controller
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class TestimonialsController {

	private static final Class<Integer> Integer = null;

	@Autowired
	private TestimonialsService testimonialsService;

	@Autowired
	private TestimonialsRepository testimonialsRepository;

	/*----------------------- add-new-Testimonials -----------------------*/
//	@PostMapping("/save-testimonials")
//	public ResponseEntity<Testimonials> createTestimonials(@RequestBody Testimonials testimonials) {
//		Testimonials savedTestimonials = testimonialsService.saveTestimonials(testimonials);
//		return ResponseEntity.ok(savedTestimonials);
//	}

	@PostMapping("/save-testimonials")
	public ResponseEntity<Map<String, Object>> saveTestimonials(@RequestParam String name,
			@RequestParam String designation, @RequestParam String comment,
			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {

		Map<String, Object> response = new HashMap();
		try {
			Testimonials testimonials = new Testimonials();
			testimonials.setName(name);
			testimonials.setDesignation(designation);
			testimonials.setComment(comment);

			// Optional: Handle image field if provided
			if (imageFile != null && !imageFile.isEmpty()) {
				testimonials.setImage(imageFile.getBytes());
			}

			// Save the Testimonials entity using the repository
			testimonialsRepository.save(testimonials);

			response.put("status", true);
			response.put("data", "Testimonials saved successfully.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("status", false);
			response.put("error", "Error saving Testimonials: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*-----------------------get-image------------------------*/
	@GetMapping("/testimonial-image/{id}")
	public ResponseEntity<byte[]> getImageById(@PathVariable int id) {
		Optional<Testimonials> testimonial = Optional.ofNullable(testimonialsRepository.findById(id));

		if (testimonial.isPresent()) {
			Testimonials image = testimonial.get();
			return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG) // Set the appropriate content type for your
																			// image
					.body(image.getImage());
		} else {
			// Handle not found scenario
			return ResponseEntity.notFound().build();
		}
	}

	/*-----------------------get-All-Testimonials-----------------------*/

	private Object getStringOrNull(JSONObject json, String string) {
		// TODO Auto-generated method stub
		return null;
	}

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
	/*
	 * @PutMapping("/update-testimonials/{id}") public ResponseEntity<Testimonials>
	 * updateTestimonialsById(@PathVariable("id") int id,
	 * 
	 * @RequestBody Testimonials updateTestimonials) { Testimonials
	 * existingTestimonials = testimonialsService.getTestimonialsById(id); if
	 * (existingTestimonials != null) { updateTestimonials.setId(id); // Set the ID
	 * of the updated contact Testimonials updatedTestimonials =
	 * testimonialsService.updateTestimonialsById(updateTestimonials, id); return
	 * ResponseEntity.ok(updatedTestimonials); } else { // Handle the case where the
	 * ContactUs with the given id doesn't exist return
	 * ResponseEntity.notFound().build(); } }
	 */
	/*-----------------------update-testimonials-----------------------*/
	@PutMapping("/update-testimonials/{id}")
	public ResponseEntity<Map<String, Object>> updateTestimonials(@PathVariable int id, @RequestParam String name,
			@RequestParam String designation, @RequestParam String comment,
			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {

//		LoginUserDetails loginUserDetails = (LoginUserDetails) authentication.getPrincipal();

		Map<String, Object> response = new HashMap<>();
		try {
			Optional<Testimonials> optionalTestimonials = Optional.ofNullable(testimonialsRepository.findById(id));
			if (optionalTestimonials.isPresent()) {
				Testimonials testimonials = optionalTestimonials.get();

				testimonials.setName(name);
				testimonials.setComment(comment);
				testimonials.setDesignation(designation);
				
				// Optional: Handle image field if provided
				if (imageFile != null && !imageFile.isEmpty()) {
					testimonials.setImage(imageFile.getBytes());
				}

				// Update the Testimonials entity using the repository
				testimonialsRepository.save(testimonials);

				response.put("status", true);
				response.put("data", "Testimonials updated successfully.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.put("status", false);
				response.put("error", "Testimonials not found with id: " + id);
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("status", false);
			response.put("error", "Error updating Testimonials: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
