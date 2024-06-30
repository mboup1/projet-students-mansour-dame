package com.mansourdame.student.dto;

import com.mansourdame.student.entity.Student;


public class StudentMapper {

    public StudentDTO convertEntityToDto (Student student){

        return  StudentDTO.builder().firstName(student.getFirstName()).lastName(student.getLastName()).email(student.getEmail()).build();
    }

    public static Student convertDtoToEntity (StudentDTO studentDTO){

        return  Student.builder().firstName(studentDTO.getFirstName()).lastName(studentDTO.getLastName()).email(studentDTO.getEmail()).build();
    }



}
