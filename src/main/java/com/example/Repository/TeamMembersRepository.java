package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entity.RequestQuote;
import com.example.Entity.TeamMembers;

public interface TeamMembersRepository extends JpaRepository<TeamMembers, Integer>{

	@Query("SELECT c FROM TeamMembers c WHERE c.id = :id AND c.isDeleted = false")
	public TeamMembers  findById(@Param("id")int id);
	
	@Query("SELECT c FROM TeamMembers c WHERE c.isDeleted = false")
	public List<TeamMembers>  getAll();
	
	TeamMembers deleteById(@Param("id") int id);
}
