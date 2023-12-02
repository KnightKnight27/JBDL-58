package com.example.minorproject.dtos;

import com.example.minorproject.models.Student;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @Min(10)
    @Max(100)
    private Integer age;

    // in dto you should have a method to convert it to an student object

    public Student to(){
        return Student.builder().
                name(this.name).
                email(this.email).
                age(this.age).
                build();
    }
}
