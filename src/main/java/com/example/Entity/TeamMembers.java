package com.example.Entity;

import java.sql.Date;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
public class TeamMembers {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String designation;
	
    @Lob
    @Column(name = "emp_image", columnDefinition = "LONGBLOB")
    private byte[] image;
    
    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted;
    
    @Column(name = "update_time", insertable = false)
    @UpdateTimestamp
    private Date updateTime;
	
}
