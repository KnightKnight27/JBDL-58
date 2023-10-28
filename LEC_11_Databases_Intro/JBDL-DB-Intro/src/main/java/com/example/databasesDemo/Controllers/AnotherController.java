package com.example.databasesDemo.Controllers;

import com.example.databasesDemo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnotherController {

    @Autowired
    private TestEntity testEntity;


    @PostMapping("/addEmployee2")
    public String addEmployee(@RequestBody Employee employee) throws Exception {

        return "";
    }
}
