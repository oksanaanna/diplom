package com.example.demo;

import org.springframework.data.domain.Example;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Optional;

@Named
public class RegistrationPage {
    @Inject
    private RegistrationRepository registrationRepository;
    private long id;
    private String login;
    private String password;
    private String email;
    private String confirmPassword;

    public String getVerifyPassword() {
        return confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public RegistrationRepository getRegistrationRepository() {
        return registrationRepository;
    }

    public void setRegistrationRepository(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String regInfoSave() {

        if (verifyPassword()) {

            Registration example = new Registration();
            example.setLogin(login);
            Optional<Registration> existing = registrationRepository.findOne(Example.of(example));
            if (existing.isPresent()) {
                sendMessage("Login already exists");
                return null;
            }

            Registration registration = new Registration();
            registration.setLogin(login);
            registration.setPassword(password);
            registration.setconfirmPassword(confirmPassword);
            registration.setEmail(email);
            registrationRepository.save(registration);
            return "goToLogin";
        } else {
            sendMessage("Passwords do not match");
            return null;
        }
    }

    public boolean verifyPassword() {
        return password.equals(confirmPassword);
    }

    public List<Registration> findAllRegistrations() {
        return registrationRepository.findAll();
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                message, null));
    }
}
