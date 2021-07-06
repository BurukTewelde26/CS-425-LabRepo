package edu.mum.cs.cs425.eregistrar.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotNull(message = "*Student Number is required")
    @NotBlank(message = "*Student Number can not be blank")
    private String studentNumber;
    
    @NotNull(message = "*First name is required")
    @NotBlank(message = "*First name  can not be blank")
    private String firstName;
    
    private String middleName;

    
    @NotNull(message = "Enrollment Date is required")
    @DateTimeFormat(pattern = "uuuu-MM-dd")
    private LocalDate enrollmentDate;
    

    private String isInternational;
    
    
    

    public Student(){}
    public Student(String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate enrollmentDate) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.enrollmentDate = enrollmentDate;
    }
    public Long getStudentId() {
        return studentId;
    }



    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

 


    @NotNull(message = "Last name is required")
    private String lastName;

    private Double cgpa;

 

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getIsInternational() {
        return isInternational;
    }

    public void setIsInternational(String isInternational) {
        this.isInternational = isInternational;
    }

}

