package ait.sad.finalproject.lms.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ait.sad.finalproject.lms.jpa.BookJpa;
import ait.sad.finalproject.lms.jpa.StudentJpa;
import ait.sad.finalproject.lms.model.Book;
import ait.sad.finalproject.lms.model.Librarian;
import ait.sad.finalproject.lms.model.Student;
import ait.sad.finalproject.lms.service.LibrarianService;

@Controller
public class LibrarianController 
{
	@Autowired LibrarianService librarianService;
	@Autowired BookJpa bjpa;
	@Autowired StudentJpa sjpa;
	
	@RequestMapping(value = "/librarianLogin", method = RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView model = new ModelAndView("adminlogin.jsp");
		return model;
	}
	
	@RequestMapping(value = "validateLibrarianLogin", method = RequestMethod.POST)
	public void validate(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("liblog") Librarian details) throws IOException, ServletException
	{
		Librarian librarian = librarianService.validate(req, details);
		String direct = "adminlogin.jsp";
		if(null != librarian)
		{
			HttpSession session = req.getSession();
			session.setAttribute("librarian", librarian);
			req.setAttribute("librarianname", librarian.getUsername());
			direct = "librarianhome.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(direct);
			dispatcher.forward(req, res);
		}
		else
		{
			String message = "Invalid Credentials";
			req.setAttribute("message", message);
			RequestDispatcher dispatcher = req.getRequestDispatcher(direct);
			dispatcher.forward(req, res);
		}
	}
	
	@RequestMapping(path = "/studentborrowedbooks")
	public ModelAndView showBorrowedBooks(HttpServletRequest req, HttpServletResponse res)
	{
		List<Book> books = bjpa.findAllBorrowed();
		ModelAndView model = new ModelAndView("booksborrowed.jsp");
		model.addObject("borrowedBooks", books);
		return model;
	}
	
	@RequestMapping(path = "/issueBook", method = RequestMethod.POST)
	public ModelAndView issue(@ModelAttribute("issue") Book book, Student student)
	{
		librarianService.issueBook(student, book);
		return new ModelAndView("bookavailability.jsp");
	}
	
	@RequestMapping(path = "/returnBook", method = RequestMethod.POST)
	public ModelAndView returnBook(@ModelAttribute("return") Book book, Student student)
	{
		librarianService.returnBook(student, book);
		return new ModelAndView("bookavailability.jsp");
	}
	
	@RequestMapping(path = "/registerStudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@ModelAttribute("register") Student student) throws IOException, ServletException
	{
		librarianService.register(student);
		ModelAndView model = new ModelAndView("librarianhome.jsp");
		return model;
	}
	
	@RequestMapping(path = "/removeStudent", method = RequestMethod.POST)
	public ModelAndView removeStudent(@ModelAttribute("remove") Student student) throws IOException, ServletException
	{
		librarianService.unregister(student);
		ModelAndView model = new ModelAndView("librarianhome.jsp");
		return model;
	}
}
