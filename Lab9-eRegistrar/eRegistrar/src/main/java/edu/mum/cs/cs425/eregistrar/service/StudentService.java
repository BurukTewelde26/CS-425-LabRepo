package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.model.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    public List<Student> getAllStudents();

    public void saveStudent(Student student);

	public Optional<Student> getStudentById(Long studentId);
	public Optional<Student> deleteStudent(Long studentId);
	public Long parseData(String studId);
}
