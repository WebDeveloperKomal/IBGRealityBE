package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entity.ContactUs;

import jakarta.persistence.Id;

import java.util.List;


public interface ContectUsRepository extends JpaRepository<ContactUs, Integer> {

	@Query("SELECT c FROM ContactUs c WHERE c.id = :id AND c.isDeleted = false")
	public ContactUs  findById(@Param("id")int id);
	
	@Query("SELECT c FROM ContactUs c WHERE c.isDeleted = false")
	public List<ContactUs>  getAll();
	
//	  @Query("DELETE aw FROM ContactUs aw WHERE aw.id = :id AND aw.isDeleted = false")
	ContactUs deleteById(@Param("id") int id);
	
}
