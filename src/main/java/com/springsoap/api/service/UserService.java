package com.springsoap.api.service;


import com.springsoap.api.users.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users=new HashMap<>();

    @PostConstruct
    public void initialize() {

        User user1= new User();
        user1.setUserId(1);
        user1.setName("Abdulrahman");
        user1.setEmail("Abdulrahman@gmail.com");

        User user2= new User();
        user2.setUserId(2);
        user2.setName("Mohamed");
        user2.setEmail("mohamed@gmail.com");


        User user3= new User();
        user3.setUserId(3);
        user3.setName("Ali");
        user3.setEmail("Ali@gmail.com");


        users.put(user1.getName(),user1);
        users.put(user2.getName(),user2);
        users.put(user3.getName(),user3);


    }





    public  User getUser (String name) {

        return users.get(name);
    }



}
