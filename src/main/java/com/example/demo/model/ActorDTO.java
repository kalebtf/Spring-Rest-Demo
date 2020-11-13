package com.example.demo.model;

import org.dozer.Mapping;

import javax.persistence.*;
import java.sql.Timestamp;

//@Entity
//@Table(name = "actor")
public class ActorDTO {

    private int id;

    private String name;

    private String lName;

    private Timestamp lUpdate;



    public ActorDTO() {
    }

    public ActorDTO(int id, String name, String lName, Timestamp lUpdate) {
        this.id = id;
        this.name = name;
        this.lName = lName;
        this.lUpdate = lUpdate;

    }


    //@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name ="actor_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Mapping("firstName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Mapping("lastName")
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }



    @Mapping("lastUpdate")
    public Timestamp getlUpdate() {
        return lUpdate;
    }

    public void setlUpdate(Timestamp lUpdate) {
        this.lUpdate = lUpdate;
    }

}