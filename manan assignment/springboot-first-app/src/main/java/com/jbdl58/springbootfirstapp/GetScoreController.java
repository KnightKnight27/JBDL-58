package com.jbdl58.springbootfirstapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetScoreController {

    private static final Logger log = LoggerFactory.getLogger(GetScoreController.class);
    @GetMapping("/getScore")
    public String getScore(@RequestParam("sport") String sport, @RequestParam("match") String match){

        log.info("Client requested the score for "+match+" in "+sport);
        return "Hi Manan I don't have the score for "+match+" in "+sport;
    }
}
