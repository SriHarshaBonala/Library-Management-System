package ait.sad.finalproject.lms.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ait.sad.finalproject.lms.jpa.StudentJpa;
import ait.sad.finalproject.lms.model.Student;

@Service
public class StudentServiceImpl implements StudentService
{
	@Autowired StudentJpa sjpa;
	
	@Override
	public Student validate(HttpServletRequest req, Student details) 
	{
		return sjpa.validate(req, details);
	}

}
