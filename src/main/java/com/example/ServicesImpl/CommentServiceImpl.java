package com.example.ServicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Entity.Comment;
import com.example.Repository.CommentRepository;
import com.example.Service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public Comment saveComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.save(comment);
	}

	@Override
	public List<Comment> getAllComments() {
		// TODO Auto-generated method stub
		return commentRepository.getAll();
	}

	@Override
	public Comment getCommentById(int id) {
		// TODO Auto-generated method stub
		return commentRepository.findById(id);
	}

	@Override
	public Comment deleteCommentByCommentId(int id) {
		// TODO Auto-generated method stub
		Comment comment = commentRepository.findById(id);
		comment.setDeleted(true);
		return commentRepository.save(comment);
	}

	@Override
	public Comment updateCommentById(Comment comment, int id) {
		// TODO Auto-generated method stub
		comment.setId(id);
		return commentRepository.save(comment);
	}

}
