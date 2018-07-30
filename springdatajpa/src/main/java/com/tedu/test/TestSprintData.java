package com.tedu.test;

import com.tedu.entity.Person;
import com.tedu.repository.PersonRepository;
import com.tedu.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestSprintData {

    private ApplicationContext applicationContext = null;
    private PersonRepository personRepository = null;
    private PersonService personService = null;

    {
        applicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");
        personRepository = applicationContext.getBean(PersonRepository.class);
        personService = applicationContext.getBean(PersonService.class);
    }

    @Test
    public void test(){
        List<Person> personList = personRepository.getByName("bbbbbb");
        System.out.println(personList);
    }

    @Test
    public void test2(){
        int i = personRepository.selPersonCount();
        System.out.println(i);
    }

    @Test
    public void test3(){
        List<Person> personByLike = personRepository.queryPersonByLike("b");
        System.out.println(personByLike);
    }


    @Test
    public void test4(){
        personService.updatePersonByName("1471824@163.com",3);
    }



    //CRUD
    @Test
    public void test5(){
        List<Person> personList = new ArrayList<>();

        for (int i = 'a';i <= 'z'; i++){
            Person person = new Person();

            person.setPname((char)i+""+(char)i);
            person.setBrith(new Date());
            person.setEmail(i+""+i+"@qq.com");
            personList.add(person);
        }
        personRepository.save(personList);
    }

    /**
     * 分页
     */
    @Test
    public void test6(){
        int pageNo = 2;
        int pageSize = 5;
        Sort.Order order = new Sort.Order(Sort.Direction.DESC,"pid");
        Sort sort = new Sort(order);
        PageRequest pageRequest = new PageRequest(pageNo,pageSize,sort);
        Page<Person> people = personRepository.findAll(pageRequest);
        System.out.println(people.getTotalPages());
        System.out.println(people.getNumber());
        System.out.println(people.getContent());
    }



}
