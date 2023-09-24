package com.jbdl58.learningspringbootdemo.Controllers;


import com.jbdl58.learningspringbootdemo.Employee;
import jakarta.annotation.Nullable;
import jakarta.websocket.server.PathParam;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
public class EmployeeController {
    // addEmployee?id=12&name="kartik"&designation=SDE1
    HashMap<Integer,Employee> employeeHashMap = new HashMap<>();
    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) throws Exception {
        if(employee.getId() == 0){
            throw new Exception("Id not present");
        }
        if(employeeHashMap.containsKey(employee.getId()) ){
            throw new Exception("Key already exists");
        }
        employeeHashMap.put(employee.getId(),employee);
        // basic checks like
        return "Employee is created";
    }

    @GetMapping("/getEmployees")
    public List<Employee> fetchAllEmployees(){
        // w
        return employeeHashMap.values().stream().
                collect(Collectors.toList());
    }

    // getEmployee/id/12/name/kartik
    @GetMapping(value = "/getEmployee/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee fetchEmployee(@PathVariable("id") Integer id) throws Exception {
        if(employeeHashMap.containsKey(id)==false){
            throw  new Exception("KEY DOESN'T EXIST");
        }
        return employeeHashMap.get(id);
    }
    // 5 mins break and we will meet back by 8:51 pm
    // @DeleteMapping
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public String deleteEmployee(@RequestParam("id") int id){
        if(employeeHashMap.containsKey(id)){
            employeeHashMap.remove(id);
            return "employe deleted";
        }
        return "Id Doesn't Exist";
    }

    @PutMapping("/updateEmployee")
    public String updateEmployee(@RequestBody Employee employee){
        // { id = "",name ="",designation=""
        // }
        employeeHashMap.put(employee.getId(),employee);
        return "Update worked fine";
    }

    @PatchMapping("/updateEmployee")
    public String updateEmployee2(@RequestBody Employee employee){
        // {   designation = "", id""}
        int id = employee.getId();
        if(employee.getEmailId()!=null){
              employeeHashMap.get(id).setEmailId(employee.getEmailId());
        }
        if(employee.getDesignation()!=null){
            employeeHashMap.get(id).setDesignation(employee.getDesignation());
        }
        return "Patch was succesful";
    }




}
