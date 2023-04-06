package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iStudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentByEmail(String email);

    Optional<Student> findById(Long id);

    Optional<Student> deleteStudentById(Long id);

}
