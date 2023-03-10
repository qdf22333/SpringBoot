package com.mysite.sbb2.users;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity

public class Users {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idx;
	
	@Column(columnDefinition ="TEXT")
	private String name;
	
	@Column(columnDefinition ="TEXT")
	private String pass;
	
	@Column(columnDefinition ="TEXT")
	private String email;
	
	private LocalDateTime createDate; 
	
	private Integer cnt;
	
	

}
