package com.tedu.repository;

import com.tedu.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends org.springframework.data.repository.PagingAndSortingRepository<Person,Integer> {

    @Query( value = "select p from Person p where p.pname=:name")
    List<Person> getByName(@Param("name") String name);


    //使用原生sql
    //设置nativeQuery属性为true即可以是使用原生SQL
    @Query(value = "select count(*) from jpa_person p",nativeQuery = true)
    int selPersonCount();


    //Like
    //@Query("SELECT p from Person p where p.pname like %?1%")
    @Query("SELECT p from Person p where p.pname like %:name%")
    List<Person> queryPersonByLike(@Param("name") String name);


    /**
     * Query注解 删改 UPDATE/DELETE
     * JPQL不支持insert操作
     *
     * 每个方法都有默认的只读的事务
     * @param email
     * @param id
     */
    @Modifying
    @Query("UPDATE Person p set p.email = :email WHERE p.pid = :id")
    void updatePersonByName(@Param("email") String email, @Param("id") int id);




}
