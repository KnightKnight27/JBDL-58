package com.jbdl58.springbootfirstapp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@RestController
public class ImageController {

    @GetMapping(value = "/image" , produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] imageGenerator(@RequestParam("id") String id ,
                                 @RequestParam(value = "height",required = false , defaultValue = "200") String height ,
                                 @RequestParam(value = "width" , required = false , defaultValue = "200") String width){

        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://picsum.photos/id/"+id+"/"+height+"/"+width;
//        System.out.println(apiUrl);
        return restTemplate.getForObject(apiUrl , byte[].class);


    }
}
