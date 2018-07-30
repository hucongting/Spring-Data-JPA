package com.tedu.controller;

import com.tedu.entity.Person;
import com.tedu.repository.PersonRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/personall")
    public String test1(){
        //Person person = personRepository.findOne(1);
        //System.out.println(person);
        return "test";
    }



}
