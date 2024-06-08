package com.example.Entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

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
public class RequestQuote {

	@Id
	@GeneratedValue
	private int id;
	private String companyName;
	private String website;
	private String purpose;
	private String phoneNumber;
	private String location;
	private String areaSqft;
	private String contract;
	private String email;
	
	@Column(name = "is_deleted", nullable = false)
	private boolean isDeleted;
	    
	@Column(name = "insert_time", updatable = false)
	@CreationTimestamp
	private Date insertTime = new Date(id);
	
//	aonluzzkvrrdtsdipatilkhushal5468@gmail.com
}
