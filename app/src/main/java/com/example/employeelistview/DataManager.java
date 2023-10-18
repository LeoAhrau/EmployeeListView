package com.example.employeelistview;

import java.util.ArrayList;

public class DataManager {

    public static ArrayList <User> users = new ArrayList<>();


    public User createUser(String name, String age, String gender, String salary) {
        User user = new User(name, age, gender, salary);
        users.add(user);
        return user;

    }




    }


