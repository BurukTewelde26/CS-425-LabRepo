package edu.mum.cs.cs425.eregistrar.controller;

import edu.mum.cs.cs425.eregistrar.model.Student;
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

@RestController
@RequestMapping(value = "/eregistrar/api")
public class StudentController {


    @Autowired
    StudentService studentService;

    @GetMapping("student/list")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();

    }
    @PostMapping("student/register")
    public void addStudent(@RequestBody Student newStudent) {

         studentService.saveStudent(newStudent);
    }


    
    @DeleteMapping("student/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @GetMapping("student/get/{studentId}")
    public Student deleteStudent(@PathVariable("studentId") Long studentId, Student student){
      return studentService.getStudentById(studentId);
    }



}

