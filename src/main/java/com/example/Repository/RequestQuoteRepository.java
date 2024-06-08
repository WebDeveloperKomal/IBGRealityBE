package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entity.ContactUs;
import com.example.Entity.RequestQuote;

public interface RequestQuoteRepository extends JpaRepository<RequestQuote, Integer> {

	
	@Query("SELECT c FROM RequestQuote c WHERE c.id = :id AND c.isDeleted = false")
	public RequestQuote  findById(@Param("id")int id);
	
	@Query("SELECT c FROM RequestQuote c WHERE c.isDeleted = false")
	public List<RequestQuote>  getAll();
	
//	  @Query("DELETE aw FROM RequestQuote aw WHERE aw.id = :id AND aw.isDeleted = false")
	RequestQuote deleteById(@Param("id") int id);
}
