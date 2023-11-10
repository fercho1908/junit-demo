package com.jdt.itcg.demo.services;

import com.jdt.itcg.demo.entities.Student;
import com.jdt.itcg.demo.records.EmailValidationResponse;
import com.jdt.itcg.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentsServices {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmailVerificationService emailVerificationService;

    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    public Student create(Student student) {


        EmailValidationResponse emailValidationResponse = emailVerificationService.verifyEmail(student.getEmail());

        if(emailValidationResponse.validFormat().value()){
           return studentRepository.save(student);
        }
        throw new RuntimeException("Error saving student");
    }
}
