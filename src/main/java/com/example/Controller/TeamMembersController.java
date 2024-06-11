package com.example.Controller;

import java.awt.PageAttributes.MediaType;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.example.Entity.TeamMembers;
import com.example.Entity.Testimonials;
import com.example.Repository.TeamMembersRepository;
import com.example.Service.TeamMembersService;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class TeamMembersController {

	@Autowired
	private TeamMembersService teamMembersService;

	@Autowired
	private TeamMembersRepository teamMembersRepository;

	/*----------------------- add-new-team-members -----------------------*/
	@PostMapping("/save-team-members")
	public ResponseEntity<Map<String, Object>> saveTeamMembers(@RequestParam String name,
			@RequestParam String designation,
			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
//		LoginUserDetails loginUserDetails = (LoginUserDetails) authentication.getPrincipal();
		Map<String, Object> response = new HashMap<>();
		try {
			TeamMembers teamMembers = new TeamMembers();
			teamMembers.setName(name);
			teamMembers.setDesignation(designation);

			// Optional: Handle image field if provided
			if (imageFile != null && !imageFile.isEmpty()) {
				teamMembers.setImage(imageFile.getBytes());
			}

			// Save the Achievement entity using the repository
			teamMembersRepository.save(teamMembers);

			response.put("status", true);
			response.put("data", "Achievement saved successfully.");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.put("status", false);
			response.put("error", "Error saving Achievement: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/*************** get Team member image ****************/
	@GetMapping("/get-image/{id}")
	public ResponseEntity<byte[]> getImageById(@PathVariable int id) {
		Optional<TeamMembers> image = Optional.ofNullable(teamMembersRepository.findById(id));
		if (image.isPresent()) {
			TeamMembers blog = image.get();
			return ResponseEntity.ok().contentType(org.springframework.http.MediaType.IMAGE_JPEG) // Set the appropriate
																									// content type for
																									// your
					// image
					.body(blog.getImage());
		} else {
			// Handle not found scenario
			return ResponseEntity.notFound().build();
		}
	}

	/*-----------------------get-All-team-members-----------------------*/
	@GetMapping("/get-all-team-members-list")
	public List<TeamMembers> getTeamMembers() {
		return teamMembersService.getAllTeamMembers();
	}

	/*-----------------------get-team-members-By-Id-----------------------*/
	@GetMapping("/get-team-members/{id}")
	public TeamMembers getTeamMembersById(@PathVariable("id") int id) {
		return teamMembersService.getTeamMembersById(id);
	}

	/*-----------------------delete-team-members-By-Id-----------------------*/
	@DeleteMapping("/delete-team-members/{id}")
	public TeamMembers deleteTeamMembers(@PathVariable("id") int id) {
		return teamMembersService.deleteTeamMembersById(id);
	}

	/*-----------------------Update-contact-By-Id-----------------------*/
	@PutMapping("/update-team-members/{id}")
	public ResponseEntity<Map<String, Object>> updateAchievement(@PathVariable int id, @RequestParam String name,
			@RequestParam String designation,
			@RequestParam(value = "imageFile", required = false) MultipartFile imageFile) {
		Map<String, Object> response = new HashMap<>();
		try {
			Optional<TeamMembers> existingTeamMembers = Optional.ofNullable(teamMembersRepository.findById(id));

			if (existingTeamMembers.isPresent()) {
				TeamMembers achievement = existingTeamMembers.get();
				achievement.setName(name);
				achievement.setDesignation(designation);

				// Optional: Handle image field if provided
				if (imageFile != null && !imageFile.isEmpty()) {
					achievement.setImage(imageFile.getBytes());
				}

				teamMembersRepository.save(achievement);

				response.put("status", true);
				response.put("data", "Achievement updated successfully.");
				return new ResponseEntity<>(response, HttpStatus.OK);
			} else {
				response.put("status", false);
				response.put("error", "Achievement with id " + id + " not found.");
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			response.put("status", false);
			response.put("error", "Error updating Achievement: " + e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
