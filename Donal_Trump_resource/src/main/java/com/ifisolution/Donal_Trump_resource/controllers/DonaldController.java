package com.ifisolution.Donal_Trump_resource.controllers;

import com.ifisolution.Donal_Trump_resource.response.DonaldRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donald")
public class DonaldController {
    @GetMapping
    public ResponseEntity<DonaldRest> getInfo() {

        DonaldRest donald = new DonaldRest();
        donald.setName("Donald Trump");
        donald.setHeight(190);
        donald.setDob("14/6/1946");
        donald.setCareerStatus("Former President, Entreprenuer, Billionare");
        donald.setQuote("We need to build a wall, Let make American greate again");

        return new ResponseEntity<>(donald, HttpStatus.OK);
    }
}
