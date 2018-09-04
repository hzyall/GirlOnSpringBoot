package com.hzy.girl.controller;

import com.hzy.girl.config.GirlConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "springboot")
public class DemoController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "Hello Spring Boot!";
    }
//    @RequestMapping(value = "/{id}/get")
    @RequestMapping(value = "/get/{id}/{level}", method = RequestMethod.GET)
    public String get(@PathVariable("id") Integer id, @PathVariable("level") String level){
        return "id : " + id + " -- level: " + level;
    }

    @RequestMapping(value = "/getAnother")
    public String getAnother(@RequestParam(value = "id", defaultValue = "123", required = false) Integer id){
//        return "id : " + id + " -- level: " + level;
        return "id : " + id + "--devtools just for run test";
    }

    @Autowired
    private GirlConfigurationProperties girl;

    @Value("${content}")
    private String context;

    @RequestMapping("info")
    public String fetchGirlInfo(){
        return girl.getCupSize() + " -- " + girl.getAge();
//        return context;
    }
}
