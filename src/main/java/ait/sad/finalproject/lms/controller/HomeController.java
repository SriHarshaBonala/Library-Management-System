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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ait.sad.finalproject.lms.jpa.BookJpa;
import ait.sad.finalproject.lms.model.Book;

@Controller
public class HomeController 
{
	@Autowired BookJpa bjpa;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView model = new ModelAndView("home.jsp");
		return model;
	}
	
	@RequestMapping(path = "/availablebooks", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ModelAndView showBooksAvailable(HttpServletRequest req, HttpServletResponse res)
	{
		List<Book> books = bjpa.findAll();
		ModelAndView model = new ModelAndView("bookavailability.jsp");
		model.addObject("availableBooks", books);
		return model;
	}
	
	@RequestMapping(value = "logout_student")
	protected void logout_student(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		if(session != null)
		{
			session.removeAttribute("student");
			String message = "Session expired! Please Login Again to continue services";
			req.setAttribute("message", message);
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, res);
		}
		else
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, res);
		}
	}
	
	@RequestMapping(value = "logout_librarian")
	protected void logout_librarian(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		HttpSession session = req.getSession(false);
		if(session != null)
		{
			session.removeAttribute("librarian");
			String message = "Session expired! Please Login Again to continue services";
			req.setAttribute("message", message);
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, res);
		}
		else
		{
			RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
			dispatcher.forward(req, res);
		}
	}
}
