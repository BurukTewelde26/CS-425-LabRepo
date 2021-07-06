package edu.mum.cs.cs425.eregistrar.controller;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.model.StudentDTO;
import edu.mum.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = {"http://localhost:3007"})
@RestController
@RequestMapping(value = "/eregistrar/api")
public class StudentController {


    @Autowired
    StudentService studentService;

    @GetMapping("/student/list")
    public List<Student> getAllStudents(){
        return  studentService.getAllStudents();
        }


    @PostMapping("/student/register")
    public void saveStudent(@RequestBody Student newStudent) {

    	studentService.saveStudent(newStudent);

    }
    


    @GetMapping ("/student/delete/{studentId}")
    public Optional<Student> deleteStudent(@PathVariable("studentId") Long studentId, Model model){

         return studentService.deleteStudent(studentId);

    }

    
    @GetMapping("/student/get/{studentId}")
    public Optional<Student> searchStudentById(@PathVariable("studentId") Long studentId,Student student) {

    	return  studentService.getStudentById(studentId);

    }

}

