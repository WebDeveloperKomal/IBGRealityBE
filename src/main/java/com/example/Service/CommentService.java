package com.example.Service;

import java.util.List;

import com.example.Entity.Comment;

public interface CommentService {
	
	Comment saveComment(Comment comment);
	
	List<Comment> getAllComments();
	
	Comment getCommentById(int id);
	
	Comment deleteCommentByCommentId(int id);
	
	Comment updateCommentById(Comment comment , int id);
	
}
