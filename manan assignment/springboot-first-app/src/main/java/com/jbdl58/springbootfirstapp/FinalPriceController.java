package com.jbdl58.springbootfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.example.mathlib.finalAmt;

@RestController
public class FinalPriceController {


    @GetMapping("/finalprice")
    public double finalprice(@RequestParam("price") double price , @RequestParam("discount") double discount){

        return finalAmt(price,discount);
    }
}
