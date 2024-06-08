package com.example.Entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {

	@Id
	@GeneratedValue
	private int id;
	private String blogId;
	private String comment;
	private String number;
	private String email;
	private String name;
	private String website;
	
	@Column(name = "is_deleted", nullable = false)
	private boolean isDeleted;
	    
	@Column(name = "insert_time", updatable = false)
	@CreationTimestamp
	private Date insertTime = new Date(id);
	
}
