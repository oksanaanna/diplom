package com.example.demo;

import javax.inject.Named;

@SuppressWarnings("ALL")
@Named
public class Person {
    private String name = "Vasya";
    private String surname = "Ivanov";
    private int count = 0;
    private String gender = "male";
    private int age = 0;
    private String login = "Login";
    private String password = "pass";
    public String checkPassword(){
        if(password.equals("pass")){
            return "goToProfile";
        }else{
            return "goToInvalidPage";
        }
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        count++;
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
