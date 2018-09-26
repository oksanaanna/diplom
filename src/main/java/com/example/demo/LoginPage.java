package com.example.demo;

import org.springframework.data.domain.Example;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
public class LoginPage {

    @Inject
    private RegistrationRepository registrationRepository;
    private Long id;
    private String categoryName;
    private String description;
    @Inject
    private CatalogRepository catalogRepository;


    public CatalogRepository getCatalogRepository() {
        return catalogRepository;
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @PostConstruct
    public void init() {
        List<Category> categories = new ArrayList<>();
        Catalog catalog = new Catalog();
        catalog.setCategories(categories);
        catalog.setName("Catalog");

        Category category = new Category();
        category.setCategoryName("Herbs");
        category.setDescription("After meal before 12pm");

        List<Medicine> medicines = new ArrayList<>();
        Medicine medicine = new Medicine();
        medicine.setConsistency("Natural");
        medicine.setName("Krimol");
        medicine.setPrice(300);
        medicine.setDescription("With meal twice daily");

        medicines.add(medicine);
        categories.add(category);
        catalogRepository.save(catalog);

        System.out.println("saved");

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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
