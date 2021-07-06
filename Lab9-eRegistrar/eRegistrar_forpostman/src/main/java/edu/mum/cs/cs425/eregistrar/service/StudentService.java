package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public List<Student> getAllStudents();

    public Student saveStudent(Student student);

	public Student getStudentById(Long studentId);
	public void  deleteStudent(Long studentId);
}
