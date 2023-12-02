package com.example.minorproject.services;

import com.example.minorproject.models.Author;
import com.example.minorproject.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {


    @Autowired
    AuthorRepository authorRepository;
    public Author checkOrCreate(Author author){
        Author retrivedAuthor = authorRepository.findByEmail(author.getEmail());
        if(retrivedAuthor == null){
            // you dont have this author
            authorRepository.save(author);
            return author;
        }
        return retrivedAuthor;
    }
}
