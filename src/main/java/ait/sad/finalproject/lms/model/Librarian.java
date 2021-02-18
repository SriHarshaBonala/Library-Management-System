package ait.sad.finalproject.lms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "librarian")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Librarian 
{
	@Id 
	private int id;
	
	@Column(nullable = false) 
	private String name;
	
	@Column(nullable = false) 
	@Email 
	private String email;
	
	@Column(nullable = false) 
	private String username;
	
	@Column(nullable = false) 
	private String password;
	
	@Column(nullable = false) 
	private String role;
}
