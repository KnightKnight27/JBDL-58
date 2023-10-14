package com.LearningDI.dependencyinjection.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    // FIELD DEPENDENCY INNJECTION
    // CONSTRUCTOR DEPENDENCY INJECTION
    // setter getter dependency injection


//    private TestService testService;

//    StudentController(TestService t){
//        this.testService = t;
//        logger.info(this.testService.toString());
//    }

    @Autowired
    DbOperations database;

    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) throws Exception {
        database.doSomething();
        return "Employee is created";
    }
}
