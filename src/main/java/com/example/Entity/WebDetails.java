package com.example.Entity;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "Web_Details")
public class WebDetails {

	@Id
	@GeneratedValue
	private int id;
	
	private String address;
	
	@Column(name = "mobile_number")
	private String number;
	
	@Column(name = "email_address ")
	private String email;
	
//	@Column(name ="is_deleted" , nullable = false)
//	private boolean isDeleted;
	
	@Column(name = "insert_time", updatable = false)
	@CreationTimestamp
	private Date insertTime = new Date(id);
	
	@Column(name = "update_time" , insertable = false)
	@UpdateTimestamp
	private Date updateTime;

	
}
