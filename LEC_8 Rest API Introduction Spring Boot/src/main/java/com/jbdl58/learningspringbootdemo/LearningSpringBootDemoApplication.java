package com.jbdl58.learningspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class LearningSpringBootDemoApplication {
    // in my class path i HAVE
    // TOMCAT SERVER
    // JETTY SERVER
    // BEHAVIOR NOW ?
    // 1) THROW AN ERROR?
    // 2) RUN TOMCAT
    // 3) RUN JETTY
    // JAVA SPRING BOOT ACTUALLY HAS A PRIORITY
    // IF IT HAS TOMCAT DEPENDENCY IT WILL RUN TOMCAT ONLY
    // IT WILL RUN JETTY IF TOMCAT IS NOT THEIR
    // IT WILL RUN  UNDER TOW
	public static void main(String[] args) {
            int x = 4;
            System.out.print(~4);
//        SpringApplication.run(LearningSpringBootDemoApplication.class, args);
	}

}
