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
