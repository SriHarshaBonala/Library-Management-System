package ait.sad.finalproject.lms.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Author 
{
	@Column(nullable = false) private String author1;
	@Column private String author2;
	@Column private String author3;
}
