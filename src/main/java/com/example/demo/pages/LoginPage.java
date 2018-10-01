package com.example.demo.pages;

import com.example.demo.entities.Catalog;
import com.example.demo.entities.Category;
import com.example.demo.entities.Medicine;
import com.example.demo.entities.Registration;
import com.example.demo.repositories.CatalogRepository;
import com.example.demo.repositories.RegistrationRepository;
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
        Catalog catalog0 = new Catalog();
        catalog0.setCategories(new ArrayList<>());
        catalog0.setName("Catalog");

        Category category = new Category();
        category.setCategoryName("Herbs");
        category.setDescription("After meal before 12pm");
        catalog0.getCategories().add(category);



        Catalog catalog1 = new Catalog();
        catalog1.setCategories(new ArrayList<>());
        catalog1.setName("Catalog1");

        category = new Category();
        category.setCategoryName("Herbs42423");
        category.setDescription("After meal before 12pm");
        catalog1.getCategories().add(category);

        category = new Category();
        category.setCategoryName("Herbs123123");
        category.setDescription("After meal before 12pm");
        catalog1.getCategories().add(category);



        Catalog catalog2 = new Catalog();
        catalog2.setCategories(new ArrayList<>());
        catalog2.setName("Catalog2");

        category = new Category();
        category.setCategoryName("8984203948203948");
        category.setDescription("After meal before 12pm");
        catalog2.getCategories().add(category);

        category = new Category();
        category.setCategoryName("98237492847392384");
        category.setDescription("After meal before 12pm");
        catalog2.getCategories().add(category);



        Catalog catalog3 = new Catalog();
        catalog3.setCategories(new ArrayList<>());
        catalog3.setName("Catalog3");

        category = new Category();
        category.setCategoryName("SDKFJLSDKFJSLDFKJ");
        category.setDescription("After meal before 12pm");
        catalog3.getCategories().add(category);

        category = new Category();
        category.setCategoryName("HFKLJSLDKFJSDF");
        category.setDescription("After meal before 12pm");
        catalog3.getCategories().add(category);



        List<Medicine> medicines = new ArrayList<>();
        Medicine medicine = new Medicine();
        medicine.setConsistency("Natural");
        medicine.setName("Krimol");
        medicine.setPrice(300);
        medicine.setDescription("With meal twice daily");

        medicines.add(medicine);

        catalogRepository.save(catalog0);
        catalogRepository.save(catalog1);
        catalogRepository.save(catalog2);
        catalogRepository.save(catalog3);

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
