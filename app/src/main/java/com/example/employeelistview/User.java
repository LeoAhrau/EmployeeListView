package com.example.employeelistview;

public class User {

    String name;
    String age;
    String gender;
    String salary;




    public User(String name, String age, String gender, String salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "" +
                name  + ", " + "Age: " +
                 age +
                ", " + gender +
                ", Salary: " + salary
                ;
    }
}
