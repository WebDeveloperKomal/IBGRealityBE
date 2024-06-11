package com.example.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.TeamMembers;
import com.example.Repository.TeamMembersRepository;
import com.example.Service.TeamMembersService;

@Service
public class TeamMembersServicesImpl implements TeamMembersService{
	
	@Autowired
	private TeamMembersRepository teamMembersRepository;

	@Override
	public TeamMembers saveTeamMembers(TeamMembers teamMembers) {
		// TODO Auto-generated method stub
		return teamMembersRepository.save(teamMembers);
	}
	
	 @Override
	    public byte[] getImageByPath(String imagePath) {
			return null;
	        // Logic to retrieve image bytes from the database using the image path
	        // You can use the TeamMembersRepository to find the record by imagePath and retrieve the image bytes
	        // Return the byte array of the image
	    }

	@Override
	public List<TeamMembers> getAllTeamMembers() {
		// TODO Auto-generated method stub
		return teamMembersRepository.getAll();
		}

	@Override
	public TeamMembers getTeamMembersById(int id) {
		// TODO Auto-generated method stub
		return teamMembersRepository.findById(id);
	}

	@Override
	public TeamMembers deleteTeamMembersById(int id) {
		// TODO Auto-generated method stub
		TeamMembers teamMembers = teamMembersRepository.findById(id);
		teamMembers.setDeleted(true);
		return teamMembersRepository.save(teamMembers);
	}

	@Override
	public TeamMembers updateTeamMembersById(TeamMembers teamMembers, int id) {
		// TODO Auto-generated method stub
		teamMembers.setId(id);
		return teamMembersRepository.save(teamMembers);
	}

}
