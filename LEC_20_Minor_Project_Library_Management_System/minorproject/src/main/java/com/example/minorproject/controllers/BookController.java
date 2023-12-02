package com.example.minorproject.controllers;

import com.example.minorproject.dtos.CreateBookRequest;
import com.example.minorproject.dtos.SearchBook;
import com.example.minorproject.models.Book;
import com.example.minorproject.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void addBook(@RequestBody @Valid CreateBookRequest createBookRequest){
        bookService.create(createBookRequest.to());
    }

    @GetMapping("/searchBook")
    public List<Book> getBooks(@RequestParam("key") String key,@RequestParam("value") String value) throws Exception{
        return bookService.getAllBooks(key,value);
    }
}
