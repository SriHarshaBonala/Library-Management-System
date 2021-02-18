package ait.sad.finalproject.lms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student 
{
	@Id
	@Column(unique = true)
	private int uid;
	
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
	
	@ManyToMany(mappedBy = "users")
	private List<Book> books;
}
