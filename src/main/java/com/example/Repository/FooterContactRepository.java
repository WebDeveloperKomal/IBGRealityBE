package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entity.ContactUs;
import com.example.Entity.FooterContact;

public interface FooterContactRepository extends JpaRepository<FooterContact, Integer> {
	
	
	@Query("SELECT c FROM FooterContact c WHERE c.id = :id AND c.isDeleted = false")
	public FooterContact  findById(@Param("id")int id);
	
	@Query("SELECT c FROM FooterContact c WHERE c.isDeleted = false")
	public List<FooterContact>  getAll();
	
//	  @Query("DELETE aw FROM ContactUs aw WHERE aw.id = :id AND aw.isDeleted = false")
	FooterContact deleteById(@Param("id") int id);
}
