package com.example.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Entity.Comment;
import com.example.Entity.ContactUs;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	
	@Query("SELECT c FROM Comment c WHERE c.id = :id AND c.isDeleted = false")
	public Comment  findById(@Param("id")int id);
	
	@Query("SELECT c FROM Comment c WHERE c.isDeleted = false")
	public List<Comment>  getAll();
	
//	  @Query("DELETE aw FROM Comment aw WHERE aw.id = :id AND aw.isDeleted = false")
	Comment deleteById(@Param("id") int id);

}
