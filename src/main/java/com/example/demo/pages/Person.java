package com.example.demo.pages;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@SuppressWarnings("ALL")
@Named
public class Person {

    private String name;
    private String surname;
    private int count;
    private String gender;
    private int age;
    private String login;
    private String password;

    public String checkPassword() {
        if (password.equals("pass")) {
            return "goToProfile";
        } else {
            sendMessage("Invalid Password");
            return null;
       }

    }

    public String age() {
        if (age < 10 || age > 100) {
            sendMessage("Your age is out of range");
            return null;
        }else{
            return "goToMain";
        }
    }
    public void sendMessage(String message){
        FacesContext context= FacesContext.getCurrentInstance();
        context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,
                message,null));
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
