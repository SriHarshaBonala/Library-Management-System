package ait.sad.finalproject.lms.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.sad.finalproject.lms.jpa.LibrarianJpa;
import ait.sad.finalproject.lms.model.Book;
import ait.sad.finalproject.lms.model.Librarian;
import ait.sad.finalproject.lms.model.Student;

@Service
public class LibrarianServiceImpl implements LibrarianService
{
	@Autowired LibrarianJpa ljpa;
	
	@Override
	public Librarian validate(HttpServletRequest req, Librarian details) 
	{
		return ljpa.validate(req, details);
	}

	@Override
	public void issueBook(Student student, Book book) 
	{
		ljpa.issueBook(student, book);	
	}

	@Override
	public void returnBook(Student student, Book book) 
	{
		ljpa.returnBook(student, book);		
	}

	@Override
	public void register(Student student) 
	{
		ljpa.register(student);
	}

	@Override
	public void unregister(Student student) 
	{
		ljpa.unregister(student);
	}
}
