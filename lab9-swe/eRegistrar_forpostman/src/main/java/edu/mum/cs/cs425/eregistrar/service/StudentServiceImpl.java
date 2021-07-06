package edu.mum.cs.cs425.eregistrar.service;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

  @Autowired
  StudentRepository studentRepository;
  
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return  studentRepository.save(student);
    }

	@Override
	public Student getStudentById(Long studentId) {
		// TODO Auto-generated method stub
		return studentRepository.findStudentByStudentId(studentId);
	}

    @Override
    public void  deleteStudent(Long studentId) {
     //  Optional<Student> student = studentRepository.findStudentByStudentId(studentId);

       studentRepository.deleteById(studentId);

    }


}
