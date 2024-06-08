package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Entity.Comment;
import com.example.Service.CommentService;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class CommentController {

	private static final Class<Integer> Integer = null;
	
	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("/save-comment")
	public ResponseEntity<Comment> saveComment(@RequestBody Comment comment){
		Comment saveComment = commentService.saveComment(comment);
		return ResponseEntity.ok(saveComment);
	}
	
	@GetMapping("/get-all-comment")
	public List<Comment> getallComments(){
		return commentService.getAllComments();
	}
	
	@GetMapping("/get-comment/{id}")
	public Comment getCommentById(@PathVariable("id")int id) {
		return commentService.getCommentById(id);
	}
	
	@DeleteMapping("/delete-comment/{id}")
	public Comment deleteCommentByIdComment(@PathVariable("id")int id) {
		return commentService.deleteCommentByCommentId(id);
	}
	
	@PutMapping("/update-comment/{id}")
	public ResponseEntity<Comment> updateCommentById(@PathVariable("id")int id , @RequestBody Comment updateComment){
		Comment comment = commentService.getCommentById(id);
		if(comment != null) {
			updateComment.setId(id);
			Comment updateCommentIdComment = commentService.updateCommentById(updateComment, id);
			return ResponseEntity.ok(updateCommentIdComment);
		}else {
			return ResponseEntity.notFound().build();
			}
	}
}
