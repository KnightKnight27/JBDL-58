package com.jbdl58.springbootfirstapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    HashMap<Integer,Employee> employeeHashMap = new HashMap<>();



    @PostMapping("/addemp")
    public String addEmployee(@RequestBody Employee employee){
        if(employee.getId()==0) return "Id cannot be null";

        // put checks for id already present , name is null

        employeeHashMap.put(employee.getId(),employee);
        logger.info("Added empoyee with id = "+employee.getId()+" and name = "+employee.getName());
        return "Employee added ";
    }

    @GetMapping("/getemp")
    public List<Employee> getEmployee(){

        List<Employee> listOfEmployees;

        return employeeHashMap.values().stream().collect(Collectors.toList());
    }
}
