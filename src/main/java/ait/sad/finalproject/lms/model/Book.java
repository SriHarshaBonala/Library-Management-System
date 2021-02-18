package ait.sad.finalproject.lms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="book")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book 
{
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int bid;
	
	@Column(nullable = false) 
	private String title;
	
	@Column 
	private Author author;
	
	@Column(nullable = false) 
	private int edition;
	
	@Column(nullable = false)
	private int copiesAvailable;
	
	@ManyToMany
	@JoinTable(name="user_book", joinColumns = {@JoinColumn(name="bid")}, 
	inverseJoinColumns = {@JoinColumn(name="uid")})
	private List<Student> users;
	
}
