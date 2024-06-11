package com.example.Service;

import java.util.List;

import com.example.Entity.TeamMembers;
import com.example.Entity.Testimonials;

public interface TeamMembersService {
	
	TeamMembers saveTeamMembers(TeamMembers teamMembers);
	
	byte[] getImageByPath(String imagePath);
	
	List<TeamMembers> getAllTeamMembers();
	
	TeamMembers getTeamMembersById(int id);
	
	TeamMembers deleteTeamMembersById(int id);
	
	TeamMembers updateTeamMembersById(TeamMembers teamMembers, int id);

}
