package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.demo.entity.StudentEntity;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
	
	List<StudentEntity> findByName(String name);
	
	List<StudentEntity> findByNameAndMarks(String name , Double marks);
	
	List<StudentEntity> findByMarksGreaterThan(Double marks);
	
	List<StudentEntity> findByNameStartingWith(String name);
	
	List<StudentEntity> findByMailContaining(String name);
	
	List<StudentEntity> findByNameOrderByMarksAsc(String name);
	
	List<StudentEntity> findByNameOrderByMarksDesc(String name);
	
	StudentEntity findTopByOrderByMarksDesc();
	
	List<StudentEntity> findTop2ByOrderByMarksDesc();
	
	List<StudentEntity> findByNameIn(List<String> names);
	
	List<StudentEntity> findByNameNotIn(List<String> names);
	
	Long countByName(String names);
	
	Boolean existsByMail(String mail);
	
	
// ------------------------------- JPQL --------------------------------------------------------
	
//	@Query("SELECT S FROM StudentEntity S WHERE S.mail=?1")
//	List<StudentEntity> findStudentByMail(String mail);
	
	// Or
	
	@Query("SELECT S FROM StudentEntity S WHERE S.mail=:mail")
	List<StudentEntity> findStudentByMail(@Param("mail") String mail);
	
	@Query("SELECT S FROM StudentEntity S WHERE S.name=?1 AND S.mail=?2")
	List<StudentEntity> findStudentByNameAndmail(String name, String mail);
	
	@Query("SELECT S FROM StudentEntity S ORDER BY marks DESC LIMIT 2")
	List<StudentEntity> findTop2StudentByOrderByMarksDesc();
	
	@Query("SELECT S FROM StudentEntity S WHERE S.name LIKE %?1%")
	List<StudentEntity> findStudentByPattern(String pattern);
	
	@Query("SELECT S FROM StudentEntity S WHERE S.marks > ?1")
	List<StudentEntity> findStudentMarksGreaterThan(Double marks);
	
	
// ---------------------- Native Query Language -------------------------------------------------
	
	@Query(value="SELECT * FROM STUDENT_ENTITY", nativeQuery = true)
	List<StudentEntity> findAllStudents();
	
	@Query(value="SELECT * FROM STUDENT_ENTITY WHERE S_NAME LIKE ?1 " , nativeQuery = true)
	List<StudentEntity> findByPattern(String pattern);
	// for these type of queries we have to pass % and _ in the method parameters itself
	// ex : findByPattern("%ra%")
	
	@Query(value="SELECT * FROM STUDENT_ENTITY WHERE MARKS = :marks" , nativeQuery=true)
	List<StudentEntity> findStudentByMarks(@Param("marks") Double marks);
	
	



}
