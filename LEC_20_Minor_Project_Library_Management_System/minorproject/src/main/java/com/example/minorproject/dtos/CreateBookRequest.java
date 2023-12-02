package com.example.minorproject.dtos;

import com.example.minorproject.models.Author;
import com.example.minorproject.models.Book;
import com.example.minorproject.models.Genre;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest {

    @NotBlank
    private String name;

    @NotNull   // notblank cant be used here it doesnt work with user defined types
    private Genre genre;

    @NotBlank
    private String authorName;

    @NotBlank
    private String authorEmail;

    public Book to(){
        // in the builder will u pass authord or or an actual object of author ??
        // ITS JUST A METHOD TO CONVERT DTO TO AN OBJECT
        return Book.builder().
                name(this.name).
                genre(this.genre).
                my_author( Author.builder().
                        name(this.authorName).
                        email(this.authorEmail).
                        build()).
                build();
    }
}
