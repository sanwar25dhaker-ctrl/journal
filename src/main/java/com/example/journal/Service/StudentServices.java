package com.example.journal.Service;

import com.example.journal.Entity.Student;
import com.example.journal.Repository.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServices {




    private final StudentRepo repository;

    public StudentServices(StudentRepo repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student student = repository.findById(id).orElseThrow();
        student.setRollno(studentDetails.getRollno());
        student.setStudentName(studentDetails.getStudentName());
        student.setMarks(studentDetails.getMarks());
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
