package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.entity.StudentEntity;
import com.demo.exception.StudentNotFoundException;
import com.demo.repository.StudentRepository;
import com.demo.studentDTO.Student;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentrepo;

	public String saveStud(StudentEntity studententity) {

		studentrepo.save(studententity);

		return "Student Saved Successfully✅✅";
	}

	public List<Student> getAll() {

		List<StudentEntity> entitylist = studentrepo.findAll();
		List<Student> slist = new ArrayList<>();

		for (StudentEntity se : entitylist) {

			Student s = new Student();
			s.setId(se.getId());
			s.setName(se.getName());
			s.setMail(se.getMail());
			s.setMarks(se.getMarks());

			slist.add(s);
		}

		return slist;
	}

	public Student getStudentById(int id) {

		StudentEntity st = studentrepo.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found 😂😂"));

		Student s = new Student();

		s.setId(st.getId());
		s.setMail(st.getMail());
		s.setMarks(st.getMarks());
		s.setName(st.getName());

		return s;

	}

	public String updateStudent(int id, Student student) {

		Optional<StudentEntity> op = studentrepo.findById(id);

		if (op.isPresent()) {

			StudentEntity oldentity = op.get();

			if (student.getMail() != null) {
				oldentity.setMail(student.getMail());
			}
			if (student.getMarks() != 0) {
				oldentity.setMarks(student.getMarks());
			}
			if (student.getName() != null) {
				oldentity.setName(student.getName());
			}

			studentrepo.save(oldentity);

			return "Student Updated Successfully✅✅";
		} else {
			return "Student Not Found 😂😂";
		}
	}

	public String deleteStudent(int id) {

//		StudentEntity oldentity= studentrepo.findById(id).orElseThrow(() -> new RuntimeException("Student Not Found 😂😂"));
		StudentEntity oldentity = studentrepo.findById(id)
				.orElseThrow(() -> new StudentNotFoundException("Student Not Found 😂😂"));
		studentrepo.delete(oldentity);
		
		// studentrepo.deleteById(id);

		return "Student Deleted Successfully✅✅";
	}
	
	public List<Student> getStudentByName(String name) {
		
		List<StudentEntity> elist = studentrepo.findByName(name);
		List<Student> slist = new ArrayList<>();
		if(elist.isEmpty()) {
			throw new StudentNotFoundException("Student Not Found");
		}
		else {
			for(StudentEntity se : elist) {
				Student s = new Student();
				s.setId(se.getId());
				s.setMail(se.getMail());
				s.setMarks(se.getMarks());
				s.setName(se.getName());
				
				slist.add(s);
			}
		}
		return slist;
	}
	
	public List<StudentEntity> findStudentByMail(String mail) {
		
		return studentrepo.findStudentByMail(mail);
	}
	
	public List<StudentEntity> findTop2StudentByOrderByMarksDesc(){
		
		return studentrepo.findTop2StudentByOrderByMarksDesc();
	}
	
	public Page<StudentEntity> getStudentsByPage(Integer pageno , Integer size){
		
		 Pageable pages=PageRequest.of(pageno-1, size);
		
		 return studentrepo.findAll(pages);
	}
	
	public List<StudentEntity> getsortedStudents(String field , String direction) {
		
		if(direction.equalsIgnoreCase("asc")) {
			Sort s = Sort.by(field).ascending();
			return studentrepo.findAll(s);
		}
		else if(direction.equalsIgnoreCase("desc")) {
			Sort s = Sort.by(field).descending();
			return studentrepo.findAll(s);
		}
		else {
			throw new IllegalArgumentException("Direction must be asc or desc");
		}
	}

}
