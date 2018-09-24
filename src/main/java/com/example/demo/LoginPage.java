package com.example.demo;

import org.springframework.data.domain.Example;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
public class LoginPage {
    @Inject
    private RegistrationRepository registrationRepository;
    private String login;
    private String password;

    public RegistrationRepository getRegistrationRepository() {
        return registrationRepository;
    }

    public void setRegistrationRepository(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String doLogin() {
        Registration example = new Registration();
        example.setLogin(login);
        example.setPassword(password);

        Optional<Registration> existing = registrationRepository.findOne(Example.of(example));
        if (!existing.isPresent()) {
            sendMessage("Login or password is incorrect");
            return null;
        }

        return "goToHomePage";
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                message, null));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Something went wrong" + message, null));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Error" + message, null));
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                "Oops! Wrong Action" + message, null));
    }
}
