package com.example.databasesDemo.Controllers;
import com.example.databasesDemo.Employee;
import jdk.incubator.vector.VectorOperators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.HashMap;
import java.util.List;

import java.util.stream.Collectors;


@RestController
public class EmployeeController {
    // class loader created or manages static objects

    // @Autowired annotation it retrived the spring created instance

    @Autowired
    private TestEntity testEntity;
    /// BEANS AND BEAN SCOPE
    /// WHY AUTOWIRING IS SOMEHOW A COMPILE TIME PROCESSS OR SOMETHING LIKE THAT
    // class loaders are out of the scope from spring lifetime management so auto wiring of static doesnt go well

    // @AUTOWIRED AND STATIC  TOGETHER DOESNT REALLY MAKE SENSE

    /// pillar of spring
    // DEPENDENCY INJECTION -> USING YOUR SPRING BEANS IN YOUR CLASSES AS DEPENDENCIES this is what dependency injection
    // @autowired is something which enables dependency injection for you.....

    // inversion of control
    // @component

//    @Autowired
//    private static TestEntity testEntity;
    // NEEDS THE TEST ENTITY CLASS OBJECT



    @GetMapping("/getAllEmployees")
    public List<Employee> getAllEmployee() throws SQLException {
        Connection connection = DbConnection.getDbConnection();
        String sqlQuery = "select * from employee_data";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        //  1    2   3
        /// id name email





        while(resultSet.next()){
            Employee employee;
            resultSet.getString("name");
            resultSet.getStrdhdsfjidsfghjfdsgudsfing("email");
            resultSet.getInt("age");
            employee.add(resultSet.getString(dsdhgsjkdsgdsjh2));
            System.out.println(resultSet.getString(2));
        }


    }





    @PostMapping("/addEmployee")
    public String addEmployee(@RequestBody Employee employee) throws Exception {
        Connection connection = DbConnection.getDbConnection();
        String query = "INSERT INTO employee_data VALUES" +
                "("+employee.getId()+",\""+employee.getName()+"\",\""
                +employee.getEmailId()+"\",\""+employee.getDesignation()+"\");";
        Statement statement = connection.createStatement();
        statement.execute(query);

        // PREPARED STATEMENTS
        String insertQuery = "INSERT INTO employee (name, last, age) VALUES (?,?, ?)";

       PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
       preparedStatement.setString(1, "John");
        preparedStatement.setString(2, "Singh");

       preparedStatement.execute();





        //// BACKEND SERVER COMPLETE STRING SEND THIS STRING TO YOUR DB SERVER
        /// STRING HAS TO BE PARSEDDDD
        /// AND THEN IT CONVERTS TO SOME MACHINE LEVEL CODE
        //// AT THE SAME POINT OF TIME 100 RQSTS ARE GOING ON
        // THESE BIG QUERIES ARE COMING
        // DB SERVER IS ACTUALLY BUSY PARSING AND CONVERTING THESE STRINGS
        // A PERFORMANCE LOOPHOLE


        // SECURITY LOOPHOLE
        // WHATEVER QUERY USER SENDS IT
        // GETS COMPILED BY DB SERVER
        // WHAT IS ITTTTTTTTT???

        // SQL INJECTION ????
        // EMPLOYEE
        // ID NAME SALARY
        // INSERT INTO EMPLOYEE(1,"RITU",10000)
        // INSERT INTO EMPLOYEE(1,"SELECT SALARY,PASSWORD FROM EMPLOYEE" .2000)
        // INSERT INTO EMPLOYEE(1,"DROP TABLE EMPLOYEE" .2000)
        // db server
        // parse it
        // compile it
        // execute it
        // the data of all the passwordd will be here
        // UI
        // NAME SELECT SALARY FROM EMPLOYEE
        // EMAILO = shgdgdj@gnauk


        // CORE REASON WAS THAT YOUR QUERIES WERE GETTING COMPILED AT YOUR DB SERVER
        /// PREPARED STATEMENTS DO
        // THEY ARE PRE COMPILED STATEMENTS QUERY ( FUNCTIONS)
        // THEY EXPECT ONLY PLACEHOLDER VALUES

        // AT YOUR DB SERVER
        // INSERT INTO VALUES ( DSHGD   "DROP TABLE " )

        return "";
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
