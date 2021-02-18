package ait.sad.finalproject.lms.controller;

import java.io.IOException;

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
import ait.sad.finalproject.lms.model.Student;
import ait.sad.finalproject.lms.service.StudentService;

@Controller
public class StudentController 
{
	@Autowired StudentService studentService;
	@Autowired StudentJpa sjpa;
	@Autowired BookJpa bjpa;
	
	@RequestMapping(value = "/studentLogin", method = RequestMethod.GET)
	public ModelAndView home()
	{
		ModelAndView model = new ModelAndView("userlogin.jsp");
		return model;
	}
	
	@RequestMapping(value = "/validateStudentLogin", method = RequestMethod.POST)
	public void validate(HttpServletRequest req, HttpServletResponse res, @ModelAttribute("stulog") Student details) throws IOException, ServletException
	{
		Student student = studentService.validate(req, details);
		String direct = "userlogin.jsp";
		if(null != student)
		{
			HttpSession session = req.getSession();
			session.setAttribute("student", student);
			req.setAttribute("studentname", student.getUsername());
			direct = "studenthome.jsp";
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
	
	
	
	/*@RequestMapping(value = "borrowedbooks/{studentname}")
	public ModelAndView showBooksBorrowed(@RequestParam String studentname)
	{
		List<Book> books = bjpa.findBooksByUsers(studentname);
		ModelAndView model = new ModelAndView("booksborrowed.jsp");
		model.addObject("borrowedBooks", books);
		return model;
	}*/
	
}
