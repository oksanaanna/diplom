package com.example.demo.pages;

import com.example.demo.entities.Catalog;
import com.example.demo.entities.Category;
import com.example.demo.repositories.CatalogRepository;
import com.example.demo.repositories.CategoryRepository;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("ALL")
@Named
@ViewScoped
public class HomePage {

    @Inject
    private Person person;

    @Inject
    private CatalogRepository catalogRepository;

    @Inject
    private CategoryRepository categoryRepository;

    private String password;

    private String selectedCatalogId;

    private String selectedCategoryId;

    private Map<String, String> catalogs;

    private Map<String, String> categories;

    private String login;

    private int age;

    @PostConstruct
    public void init() {
        catalogs = readCatalogsFromDatabase();
        categories = readCategoriesFromDatabase();
    }

    public String checkPassword() {
        if (password.equals("pass")) {
            return "goToProfile";
        } else {
            sendMessage("Invalid Password");
            return null;
        }
    }

    private Map<String, String> readCatalogsFromDatabase() {
        Map<String, String> catalogItems = new HashMap<>();

        for (Catalog catalog : catalogRepository.findAll()) {
            catalogItems.put(catalog.getName(), String.valueOf(catalog.getId()));
        }

        return catalogItems;
    }

    private Map<String, String> readCategoriesFromDatabase() {
        Map<String, String> catalogItems = new HashMap<>();

        for (Category category : categoryRepository.findAll()) {
            catalogItems.put(category.getCategoryName(), String.valueOf(category.getId()));
        }

        return catalogItems;
    }

    public String age() {
        if (age < 10 || age > 100) {
            sendMessage("Your age is out of range");
            return null;
        } else {
            return "goToMain";
        }
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                message, null));
    }

    public Map<String, String> getCatalogs() {
        return catalogs;
    }

    public String getSelectedCategoryId() {
        return selectedCategoryId;
    }

    public void setSelectedCategoryId(String selectedCategoryId) {
        this.selectedCategoryId = selectedCategoryId;
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String> categories) {
        this.categories = categories;
    }

    public void setCatalogs(Map<String, String> catalogs) {
        this.catalogs = catalogs;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSelectedCatalogId() {
        return selectedCatalogId;
    }

    public void setSelectedCatalogId(String selectedCatalogId) {
        this.selectedCatalogId = selectedCatalogId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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


