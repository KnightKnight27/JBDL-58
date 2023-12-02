package com.example.minorproject.repositories;

import com.example.minorproject.models.Book;
import com.example.minorproject.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    List<Book> findByGenre(Genre genre);
    List<Book> findByName(String name);
}
