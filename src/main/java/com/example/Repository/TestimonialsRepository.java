package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entity.RequestQuote;
import com.example.Entity.Testimonials;

public interface TestimonialsRepository extends JpaRepository<Testimonials, Integer> {
	
	@Query("SELECT c FROM Testimonials c WHERE c.id = :id AND c.isDeleted = false")
	public Testimonials  findById(@Param("id")int id);
	
	@Query("SELECT c FROM Testimonials c WHERE c.isDeleted = false")
	public List<Testimonials>  getAll();
	
//	  @Query("DELETE aw FROM Testimonials aw WHERE aw.id = :id AND aw.isDeleted = false")
	Testimonials deleteById(@Param("id") int id);
	
}
