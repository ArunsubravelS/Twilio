package com.jsp.message.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jsp.message.util.StudentDetails;

public interface StudentRepository extends JpaRepository<StudentDetails, Long> {
//	@Transactional
	@Query(value = "select name from student_details where id=:sid", nativeQuery = true)
	public String findNameById(@Param("sid")long sid);

}
