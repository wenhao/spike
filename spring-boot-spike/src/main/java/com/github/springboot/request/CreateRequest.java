package com.github.springboot.request;


import org.hibernate.validator.constraints.NotBlank;

public class CreateRequest {

    @NotBlank(message = "{NotBlank.createRequest.name}")
    private String name;
    private int age;

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
