package ait.sad.finalproject.lms.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import ait.sad.finalproject.lms.model.Student;

@Service
public interface StudentService 
{
	Student validate(HttpServletRequest req, Student details);
}
