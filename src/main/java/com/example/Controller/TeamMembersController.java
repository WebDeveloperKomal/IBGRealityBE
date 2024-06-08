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

import com.example.Entity.TeamMembers;
import com.example.Entity.Testimonials;
import com.example.Service.TeamMembersService;

@Controller
@RestController
@CrossOrigin
@RequestMapping("/auth")
public class TeamMembersController {
	
	@Autowired
	private TeamMembersService teamMembersService;
	

	/*----------------------- add-new-Testimonials -----------------------*/
	@PostMapping("/save-team-members")
	public ResponseEntity<TeamMembers> createTeamMembers(@RequestBody TeamMembers teamMembers) {
		TeamMembers savedTeamMembers = teamMembersService.saveTeamMembers(teamMembers);
		return ResponseEntity.ok(savedTeamMembers);
	}

	/*-----------------------get-All-Testimonials-----------------------*/
	@GetMapping("/get-all-team-members-list")
	public List<TeamMembers> getTeamMembers() {
		return teamMembersService.getAllTeamMembers();
	}

	/*-----------------------get-Testimonials-By-Id-----------------------*/
	@GetMapping("/get-team-members/{id}")
	public TeamMembers getTeamMembersById(@PathVariable("id") int id) {
		return teamMembersService.getTeamMembersById(id);
	}

	/*-----------------------delete-Testimonials-By-Id-----------------------*/
	@DeleteMapping("/delete-team-members/{id}")
	public TeamMembers deleteTeamMembers(@PathVariable("id") int id) {
		return teamMembersService.deleteTeamMembersById(id);
	}

	/*-----------------------Update-contact-By-Id-----------------------*/
	@PutMapping("/update-team-members/{id}")
	public ResponseEntity<TeamMembers> updateTeamMembersById(@PathVariable("id") int id,
			@RequestBody TeamMembers updateTeamMembers) {
		TeamMembers existingTeamMembers = teamMembersService.getTeamMembersById(id);
		if (existingTeamMembers != null) {
			updateTeamMembers.setId(id); // Set the ID of the updated contact
			TeamMembers updatedTeamMembers = teamMembersService.updateTeamMembersById(updateTeamMembers, id);
			return ResponseEntity.ok(updatedTeamMembers);
		} else {
			// Handle the case where the ContactUs with the given id doesn't exist
			return ResponseEntity.notFound().build();
		}
	}


}
