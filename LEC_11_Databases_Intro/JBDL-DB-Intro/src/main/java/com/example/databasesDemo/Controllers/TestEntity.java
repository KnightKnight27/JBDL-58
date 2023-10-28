package com.example.databasesDemo.Controllers;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class TestEntity {
    // SPRING IS DUMB ENOUGH TO KNOW WHAT PARAMETERS TO PASS IN A CONSTRUCTOR
    // THIS CODE WONT WORK
    TestEntity(){

    }
    TestEntity(int a){
        System.out.println("TEST ENTITY IS GETTING CREATED");
    }
    int x = 12;
    String y = "byee";
}
