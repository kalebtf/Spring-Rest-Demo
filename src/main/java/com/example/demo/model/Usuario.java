package com.example.demo.model;

import org.dozer.Mapping;

public class Usuario {

    private int id;
    private String nombre;
    private String apellido;
    private Float salario;

    public Usuario() {

    }

    public Usuario(int id, String nombre, String apellido, Float salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Mapping("firstName")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Mapping("lastName")
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

}
