package com.example.minorproject.services;

import com.example.minorproject.dtos.IntiateTransactionRequest;
import com.example.minorproject.models.*;
import com.example.minorproject.repositories.StudentRespository;
import com.example.minorproject.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Value("${student.max.books.allowed}")
    private int bookLimit;
    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookService bookService;
    public String handleTxn(IntiateTransactionRequest txnRqst){
        if(txnRqst.getTransactionType() == TransactionType.RETURN){
            return issueBook(txnRqst);
        }
        else{

        }
        return "Hello World";
    }
    private String issueBook(IntiateTransactionRequest txnRqst) throws Exception{
        Student student = studentService.find(txnRqst.getStudentId());
        Admin admin = adminService.find(txnRqst.getAdminId());
        List<Book> listOfBooks = bookService.getAllBooks("id",  String.valueOf(txnRqst.getBookId()));
        if(listOfBooks == null){
            return  "Invalid Book";
        }
        Book book = listOfBooks.get(0);
        if(student == null || admin == null || book == null || book.getStudent() != null ||
                student.getBookList().size() > bookLimit){
            throw new Exception("I CAN'T DO IT");
        }
        // everything is fine
        Transaction transaction = Transaction.builder().
                txnId(UUID.randomUUID().toString()).
                student(student).
                book(book).
                admin(admin).
                transactionType(txnRqst.getTransactionType()).
                build();
        transactionRepository.save(transaction);
        return "HELLO WORLD" ;


    }
}
