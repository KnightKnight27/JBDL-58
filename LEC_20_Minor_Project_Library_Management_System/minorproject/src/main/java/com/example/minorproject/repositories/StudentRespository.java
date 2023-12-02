package com.example.minorproject.repositories;

import com.example.minorproject.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespository extends JpaRepository<Student,Integer> {
}
