package com.tedu.entity;

import javax.persistence.*;
import java.util.Date;


@Table(name="jpa_person")
@Entity
public class Person {

    private Integer pid;

    private String pname;

    private String email;

    private Date brith;

    public Person() {
    }

    public Person(Integer pid, String pname, String email, Date brith) {
        this.pid = pid;
        this.pname = pname;
        this.email = email;
        this.brith = brith;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    public Date getBrith() {
        return brith;
    }

    public void setBrith(Date brith) {
        this.brith = brith;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", email='" + email + '\'' +
                ", brith=" + brith +
                '}';
    }
}
