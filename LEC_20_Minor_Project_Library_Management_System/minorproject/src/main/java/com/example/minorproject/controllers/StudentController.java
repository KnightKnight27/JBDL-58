package com.example.minorproject.controllers;

import com.example.minorproject.dtos.CreateStudentRequest;
import com.example.minorproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/student")
    public void createStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest){
        studentService.create(createStudentRequest.to());
    }
}
