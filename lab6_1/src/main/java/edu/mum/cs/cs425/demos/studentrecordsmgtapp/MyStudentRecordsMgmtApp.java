package edu.mum.cs.cs425.demos.studentrecordsmgtapp;


import edu.mum.cs.cs425.demos.studentrecordsmgtapp.model.Student;

import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.Period;
import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class MyStudentRecordsMgmtApp
{
    public static void main( String[] args ) throws ParseException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyy");

        Student s1=new Student(110001, "Dave", LocalDate.parse("11/18/1951",formatter));
        Student s2=new Student(110002, "Anna", LocalDate.parse("12/07/1990",formatter));
        Student s3=new Student(110003, "Dave", LocalDate.parse("01/31/1974",formatter));
        Student s4=new Student(110004, "Erica", LocalDate.parse("08/22/2009",formatter));
        Student s5=new Student(110005, "Bob", LocalDate.parse("03/05/1990",formatter));

        Student[] students=new Student[]{s1,s2,s3,s4,s5};
        System.out.println( "---------------List Of Students----------" );
        printListOfStudents(students);
        System.out.println( "----------------------------------------" );

        System.out.println( "-------------List Of Platinum Alumni Students-------" );
        List<Student> filtered=getListOfPlatinumAlumniStudents(students);

        filtered.sort((o1,o2)->o2.getDateOfAdmission().compareTo(o1.getDateOfAdmission()));

        for(Student s:filtered){
            System.out.println(s);
        }

        System.out.println( "----------------------------------------" );

        System.out.println( "-------------Hello World based on multiplicity of 5 and 7 -------" );

        printHelloWorld(new int[]{5,2,7,4,35});

        System.out.println( "----------------------------------------" );

        System.out.println( "-------------Second biggest-------" );

      // findSecondBiggest(new int[]{19,9,11,0,12});

        System.out.println( "----------------------------------------" );

    }

    public static void printListOfStudents(Student[] s){
        Arrays.sort(s);
        System.out.println(Arrays.toString(s));
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] s){
        List<Student> newStudents=new ArrayList<>();
        for(Student i: s) {
            Period diff=Period.between(i.getDateOfAdmission(),LocalDate.now());
           if(diff.getYears()>30)
               newStudents.add(i);
        }
    return newStudents;
    }

    public static void printHelloWorld(int[] num){
        for(int i:num){
            if(i%5==0 && i%7==0)
                System.out.println("HelloWorld");
            else if(i%5==0)
                System.out.println("Hello");
            else if(i%7==0)
                System.out.println("World");
        }
    }

    public Integer findSecondBiggest(Integer[] arr){
        int first, second;
        int arr_size=arr.length;
        if (arr_size < 2)
        {
            System.out.print(" Invalid Input ");
            return null;
        }

        first = second = Integer.MIN_VALUE;
        for (int i = 0; i < arr_size ; i++)
        {
            if (arr[i] > first)
            {
                second = first;
                first = arr[i];
            }

            else if (arr[i] > second && arr[i] != first)
                second = arr[i];
        }

        if (second == Integer.MIN_VALUE){
            System.out.println("There is no second largest");
            return null;
        }


        else{
            System.out.println("The second largest number is "+ second);
            return second;
        }

    }
}
