package com.example.Microservices.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

	@Entity
	@Data
	public class User {
	
		@Id
		private String username;
		private String password;
		private String role;
		private String question;
		private String answer;
		private String gender;
		private String email;
		private String isactive;
		private String procudtId; 
}
