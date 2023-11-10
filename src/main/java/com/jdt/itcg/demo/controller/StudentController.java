package com.jdt.itcg.demo.controller;

import com.jdt.itcg.demo.entities.Student;
import com.jdt.itcg.demo.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = StudentController.PATH)
public class StudentController {

    public static final String PATH = "/students";

    @Autowired
    private StudentsServices studentsServices;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok().body(studentsServices.getAll());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> create(@RequestBody Student student){
        return ResponseEntity.ok().body(studentsServices.create(student));
    }
}
