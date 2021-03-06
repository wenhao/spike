package org.github.wenhao.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class User
{
    @NotBlank(message = "{NotBlank.user.name}")
    private String name;
    @NotNull(message = "{NotNull.user.age}")
    private int age;

    public User()
    {
    }

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }
}
