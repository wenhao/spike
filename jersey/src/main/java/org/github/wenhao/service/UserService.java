package org.github.wenhao.service;

import org.github.wenhao.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    public User get(String id)
    {
        return new User("jack", 30);
    }
}
