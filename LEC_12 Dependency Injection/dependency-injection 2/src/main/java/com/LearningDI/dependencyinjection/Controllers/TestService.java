package com.LearningDI.dependencyinjection.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/// REAL LIFE PROBLEM
// DB_CLASS OPERATINS
// CONNECTION CLASS THAT HELPS TO DO DB QUERIES
// CONSTRUCTOR DB_CLASS(CONNECTION_CLASS)
// CONSTRUCTOR DB_CLASS(LOGIN CLASS)  -> HOST NAME PASSWORD INFO

// I NEED A DB CLASS
// WHICH SUPPORTS BOTH THE CONSTRUCTORS BUT FOR BEAN CREATOR
// IT USED THE FIRST CONSTRUCTOR ONLY

@Service
public class TestService {

    private static Logger  logger = LoggerFactory.getLogger(TestService.class);

    TestService(AnotherDependency anotherDependency){
        logger.info("Another dependency");
    }
    // test entity fetched from IOC container

    @Autowired
    TestService(TestEntity testEntity){
        logger.info(testEntity.toString());
        logger.info("test entity constructor");
    }
    TestService(){
        logger.info("DEFAULT CONSTRUCTOR");
    }
}
