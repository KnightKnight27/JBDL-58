package com.example.minorproject.repositories;

import com.example.minorproject.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
    // FIND BY EMAIL


    public Author findByEmail(String email);
}
