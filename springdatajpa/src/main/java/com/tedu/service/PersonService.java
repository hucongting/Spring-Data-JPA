package com.tedu.service;

import com.tedu.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.annotation.Resources;


@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Transactional
    public void updatePersonByName(String email,int id){
        personRepository.updatePersonByName(email,id);
    }

}
