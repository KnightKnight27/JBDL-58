package com.jbdl58.learningspringbootdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class ScoreFetchingController<T> {
    private static final Logger log_obj = LoggerFactory.getLogger(ScoreFetchingController.class);
    // WHY WE ARE USING THE TERM CONTROLLER
    // REVISIT THIS PART
    // MVC
    /**
     * 1) THE PROTOCOL -> HTTP/HTTPS
     * 2) BASE URL -> your ip + port of application localhost(127.0.0.1):8080
     * 3) end_point
     * 4) query params and stuff
     * ...
     * ...
     * /getScore?sport=FOOTBALL&match=NEPVSPAK
     */

    // in a production environment you will probably need different kinds of logs
    // in a dev environment you will need

    // CONCEPT OF ACTIVE PROFILES IN JAVA SPRING BOOT
    @RequestMapping(value = "/getScore", method = RequestMethod.GET)
    public String getScore(@RequestParam("sport") String sport, @RequestParam("match") String  match){
        log_obj.error("SOME CLIENT HAS MADE A REQUEST");
//        int x = 4;
//        log_obj.info(~x);
        return "Hi Kartik, I don't know the score of match " + match;
    }

//    @GetMapping("/doCalculation")
//    public int doCalculation(@RequestParam("first") T a,@RequestParam("second")T b){
//        System.out.print(a+b);
//    }
    // 1) Change the embedded server and see how your api call works
    // 2) Change logging level of the complete project ( Try this with different profiles)
    // everything even maven commands should be done using terminal
    // 3) Do a multiProject example and use that dependency in your spring boot project
    // and write api calls for it
    // for example MAKE A BILL DISCOUNT SYSTEM IN ONE PROJECT
    // GET REQUEST WITH AMOUNT AND THE DISCOUNT THEY WISH ( PARAMS 1000 , 10)
    // RETURN A REPONSE 900
    // REST API'S EXIST IN A DIFFERENT PROJECT
    //

    // UPLOAD YOUR HOMEWORK IN JBDL 58 REPO USING GIT

}
