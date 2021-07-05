package edu.mum.cs.cs425.eregistrar.controller;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller

public class StudentController {


    @Autowired
    StudentService studentService;

    @GetMapping("student/list")
    public ModelAndView getAllStudents(){
        var modelAndView = new ModelAndView();
        List<Student> students = studentService.getAllStudents();

        modelAndView.addObject("students",students);
        modelAndView.setViewName("student/list");
        return modelAndView;
    }
    @PostMapping("student/register")
    public String addStudent(@Valid
                               @ModelAttribute("student") Student student,
                                BindingResult bindingResult,
                                Model model) {

        if(bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
        }
        student = studentService.saveStudent(student);
        return "redirect: student/list";
    }
    @GetMapping("student/register")
    public String showRegisterStudentForm(Model model){
        model.addAttribute("student", new Student());
                return "student/registerForm";
    }
    @PostMapping("student/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student newStudent, BindingResult bindingResult, Model model) {
    	if(bindingResult.hasErrors()) {
    		model.addAttribute("errors", bindingResult.getAllErrors());
    		// result.getAllErrors().stream().forEach(System.out::println);
    		return "student/registerForm";
    	}
    	studentService.saveStudent(newStudent);
    	return "redirect:/student/list";
    }
    
    @GetMapping("student/edit/{studentId}")
    public String editStudentRecord(@PathVariable("studentId") Long studentId, Model model) {
    	Optional<Student> optional = studentService.getStudentById(studentId);
    	Student student = null;
    	if(optional.isPresent()) {
    		student = optional.get();
    		model.addAttribute("student",student);
    		return "student/registerForm";
    	}
    		//throw new RuntimeException("Student with Id could not found");
    		return "student/list";
    }

    @GetMapping("student/delete/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId, Model model){
       Optional<Student> optional =  studentService.deleteStudent(studentId);
        Student student = null;
        if(optional.isPresent()){
            student = optional.get();
            model.addAttribute("student",student);
            return "student/deletedRecord";
        }
       return "student/list";
    }

    
    @GetMapping("student/search")
    public String searchStudentById(@RequestParam Long studentId, Model model) {
        if(studentId == null || studentId.equals("")){
            return "home/index";
        }
    	Optional<Student> optional = studentService.getStudentById(studentId);
    	Student student = null;
    	if(optional.isPresent()) {
    	    student = optional.get();
    		model.addAttribute("student",student);
    		return "student/searchResultForm";
    	}
    	return "student/recordNotFound";
    }
    

}

