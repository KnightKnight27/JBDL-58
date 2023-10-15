package com.jbdl58.homework.assi2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    Logger logger= LoggerFactory.getLogger(Home.class);
    @GetMapping("/")
    public String home(){
        logger.error("Error Log");
        logger.debug("Debug Log");
        logger.info("Info Log");
        logger.trace("Trace Log");
        logger.warn("Warning Log");
        return "hello world";
    }

}
