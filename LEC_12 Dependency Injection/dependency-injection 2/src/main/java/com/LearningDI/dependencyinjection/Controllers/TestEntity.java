package com.LearningDI.dependencyinjection.Controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestEntity {
    private static Logger logger = LoggerFactory.getLogger(TestEntity.class);


    public TestEntity(){
        logger.info(this.toString());
    }
}
