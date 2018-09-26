package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@SuppressWarnings("ALL")
@Named
public class HomePage {

    @Inject
    private Person person;
    @Inject
    private CatalogRepository catalogRepository;
    public String password;

    private int age;
    private String login;

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

    public CatalogRepository getCatalogRepository() {
        return catalogRepository;
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}


