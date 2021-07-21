package com.ifisolution.Huy_Trinh_resource.controllers;

import com.ifisolution.Huy_Trinh_resource.response.HuyTrinhRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/huytrinh")
public class HuyTrinhController {
    @GetMapping
    public ResponseEntity<HuyTrinhRest> getInfo() {

        HuyTrinhRest huyTrinh = new HuyTrinhRest();
        huyTrinh.setName("Trịnh Nhật Huy");
        huyTrinh.setHeight(180);
        huyTrinh.setDob("xx/10/2000");
        huyTrinh.setCareerStatus("Trash, Game Developer, PT");
        huyTrinh.setQuote("Niko ni ko ni");
        huyTrinh.setCrush("DQA");
        huyTrinh.setHobbies("Calisthenics, Motorbike, Healthy, Depress and Anime");

        return new ResponseEntity<>(huyTrinh, HttpStatus.OK);
    }
}
