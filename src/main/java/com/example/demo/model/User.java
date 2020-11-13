package com.example.demo.model;

import org.dozer.Mapping;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;
    private Double salary;

    public User() {
    }

    public User(int id, String firstName, String lastName, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;

    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }


}