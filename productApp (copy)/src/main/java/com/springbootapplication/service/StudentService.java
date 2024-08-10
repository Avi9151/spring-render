package com.springbootapplication.service;

import com.springbootapplication.entity.Address;
import com.springbootapplication.entity.Student;
import com.springbootapplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        // Set the student reference in each address
        if (student.getAddresses() != null) {
            for (Address address : student.getAddresses()) {
                address.setStudent(student);
            }
        }
        return studentRepository.save(student);
    }
}

