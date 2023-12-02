package com.example.minorproject.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.util.Date;
import java.util.List;
// MINOR PROJECT
// LLIBRARY MANAGEMENT SYSTEM
// STUDENT
// TRANSACTION
// BOOK
// AUTHOR
// ADMIN
// RELATIONSHIPS BETWEEN
// BOOK AUTHOR
// ONE BOOK WILL BE WRITTEN BY ONE AUTHOR ONLY
// MANY TO ONE
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Enumerated
    private Genre genre; // HISTORY => HISTORY

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties("bookList")
    private Author my_author;


    @ManyToOne
    @JoinColumn
    private Student student;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;


}
