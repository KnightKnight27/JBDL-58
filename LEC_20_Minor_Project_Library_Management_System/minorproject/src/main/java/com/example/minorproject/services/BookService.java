package com.example.minorproject.services;

import com.example.minorproject.models.Author;
import com.example.minorproject.models.Book;
import com.example.minorproject.models.Genre;
import com.example.minorproject.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorService authorService;

    @Autowired
    BookRepository bookRepository;


    public List<Book> getAllBooks(String key,String value) throws Exception{
        switch (key) {
            case "id" :{
                Optional<Book> book = bookRepository.findById(Integer.parseInt(value));
                if(book.isPresent()){
                    return Arrays.asList(book.get());
                }
                else{
                    return new ArrayList<>();
                }
            }
            case "genre":{
                //
                // value string value -> HISTORY
                return bookRepository.findByGenre( Genre.valueOf(value) );
            }
            case "name":{
                return bookRepository.findByName(value);
            }
            default:
                throw new Exception("Search key is not present");
        }

    }
    @Transactional
    public void create(Book book){


        Author author = book.getMy_author();
        Author foundAuthor = authorService.checkOrCreate(author);

        book.setMy_author(foundAuthor);
        bookRepository.save(book);
        // YOU HAVE CREATED A NEW AUTHOR OBJECT
        // IF WE ARE CREATING A BOOK
        //
        // FIRST WE COULD STORE THE AUTHOR IN THE DB
        // ->  IF AUTHOR ALREADY EXISTS IN THE TABLE WE WONT CREATE IT
        // AND THEN STORE OUR BOOK IN DB


        // CHECK IF AUTHOR EXISTS OR NOT ????
        // WE NEED AN AUTHOR SERVICE / AND AUTHOR REPO TO REPORT THIS TO US ????
    }
}
