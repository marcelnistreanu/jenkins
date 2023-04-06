package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private iStudentRepository iStudentRepository;

    public List<Student> getStudents() {
        return iStudentRepository.findAll();
    }

    public Student findById(Long id){
        return iStudentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student with id: " + id + " was not found."));
    }

    public Student createNewStudent(Student student) {
        Optional<Student> studentOptional = iStudentRepository
                .findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken.");
        }

        return iStudentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = iStudentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("Student with id: " + id + " does not exist.");
        }
        iStudentRepository.deleteStudentById(id);
    }

    public Student updateStudent(Long id, Student studentDetails) {
        Student updatedStudent = iStudentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with id: " + id + " does not exist."));

        updatedStudent.setName(studentDetails.getName());
        updatedStudent.setEmail(studentDetails.getEmail());
        updatedStudent.setDob(studentDetails.getDob());
        updatedStudent.setSpecialization(studentDetails.getSpecialization());

        return iStudentRepository.save(updatedStudent);
    }
}
