package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.StudentEntity;
import com.demo.service.StudentService;
import com.demo.studentDTO.Student;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/name")
	public String name() {
		
		return "My Name is ABC";
	}
	
	@GetMapping("/mail")
	public String gmail() {
		
		return "abc@gmail.com";
	}
	
	
	@GetMapping
	public String getMail(@RequestParam String mail) {
		
		return "The Mail is : "+mail;
	}
	
	@PostMapping("/register")
	public Student saveStudent(@RequestBody Student student) {
		
		return student;
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable int id) {
		
		return studentservice.getStudentById(id);
	}
	
	@PostMapping("/save")
	public String saveStud(@Valid @RequestBody StudentEntity studententity) {
		
		return studentservice.saveStud(studententity);
	}
	
	@GetMapping("/getall")
	public List<Student> getAll(){
		
		return studentservice.getAll();
	}
	
	@PutMapping("/update/{id}")
	public String updateStudent(@PathVariable int id , @RequestBody Student student) {
		
		return studentservice.updateStudent(id, student);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		
		return studentservice.deleteStudent(id);
	}
	
	@GetMapping("name/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return studentservice.getStudentByName(name);
	}
	
	@GetMapping("/mails")
	public List<StudentEntity> findStudentByMail(@RequestParam String mail){
		
		return studentservice.findStudentByMail(mail);
	}
	
	@GetMapping("/top2")
	public List<StudentEntity> findTop2StudentByOrderByMarksDesc(){
		
		return studentservice.findTop2StudentByOrderByMarksDesc();
	}
	
	// Pagination
	@GetMapping("/page")
	public Page<StudentEntity> getStudentsByPage(@RequestParam Integer pageno , @RequestParam Integer size){
		
		
		return studentservice.getStudentsByPage(pageno , size);
	}
	
	// Sorting 
	@GetMapping("/sort")
	public List<StudentEntity> getSortedStudents(@RequestParam String field , @RequestParam String direction){
		
		return studentservice.getsortedStudents(field, direction);
	}

}
