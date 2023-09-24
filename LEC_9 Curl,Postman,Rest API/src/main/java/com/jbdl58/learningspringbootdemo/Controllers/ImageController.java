package com.jbdl58.learningspringbootdemo.Controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
// IMAGES BLOB
@RestController
public class ImageController {

    @GetMapping(value = "/fetchImage", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] fetchImageFromPicSum(@RequestParam("id") String id,
                                       @RequestParam(value = "height",
                                               required = false,
                                               defaultValue = "200") String height,
                                       @RequestParam(value = "width",
                                               required = false,
                                               defaultValue = "200") String width){
        RestTemplate restTemplate= new RestTemplate();
        String apiUrl = "https://picsum.photos/" + "id/"+ id + "/"+ height + "/" + width;
        return restTemplate.getForObject(apiUrl, byte[].class);
    }
}
