package com.github.springboot.request;


import org.hibernate.validator.constraints.NotBlank;

public class CreateRequest {

    @NotBlank(message = "{NotBlank.createRequest.name}")
    private String name;
    @NotBlank(message = "{NotBlank.createRequest.id}")
    private String id;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
