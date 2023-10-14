package com.LearningDI.dependencyinjection.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DbOperations {
    private  static Logger logger = LoggerFactory.getLogger(DbOperations.class);


    String host;


    String password ;

    DbOperations(@Value("${db.host.name}") String host, @Value("${db.host.password}") String password){
        // for 1 more class
        // member variables are resolved after constructor
        logger.info(this.host + " " + this.password);
        this.host = host;
        this.password = password;
        logger.info("I AM IN DB OPERATIONS");
        logger.info(host + " " + password);
        logger.info("DB OPERATIONS CONSTRUCTOR IS OVER");
    }
    public void doSomething(){
        logger.info(host + " " + password);
    }
}
