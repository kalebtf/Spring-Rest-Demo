package com.example.demo.model;

import org.dozer.Mapping;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "actor")
public class Actor {

    private int id;

    private String firstName;

    private String lastName;

    private Timestamp lastUpdate;

    private  int age;



    public Actor() {
    }

    public Actor(int id, String firstName, String lastName, Timestamp lastUpdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastUpdate = lastUpdate;

    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="actor_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }




    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}