package ait.sad.finalproject.lms.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import ait.sad.finalproject.lms.model.Book;
import ait.sad.finalproject.lms.model.Librarian;
import ait.sad.finalproject.lms.model.Student;

@Service
public interface LibrarianService 
{
	Librarian validate(HttpServletRequest req, Librarian details);
	void issueBook(Student student, Book book);
	void returnBook(Student student, Book book);
	void register(Student student);
	void unregister(Student student);
}
