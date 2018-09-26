package com.example.demo;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Named
public class HomePage {

    @Inject
    private Person person;

    @Inject
    private CatalogRepository catalogRepository;

    private String password;

    private Catalog selectedCatalog;

    private List<SelectItem> catalogs;

    private String login;

    private int age;

    @PostConstruct
    public void init() {
        catalogs = readCatalogsFromDatabase();
    }

    public String checkPassword() {
        if (password.equals("pass")) {
            return "goToProfile";
        } else {
            sendMessage("Invalid Password");
            return null;
        }
    }

    private List<SelectItem> readCatalogsFromDatabase() {
        List<SelectItem> catalogItems = new ArrayList<>();

        for (Catalog catalog : catalogRepository.findAll()) {
            SelectItem catalogItem = new SelectItem(catalog, catalog.getName());
            catalogItems.add(catalogItem);
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

    public List<SelectItem> getCatalogs() {
        return catalogs;
    }

    public void setCatalogs(List<SelectItem> catalogs) {
        this.catalogs = catalogs;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Catalog getSelectedCatalog() {
        return selectedCatalog;
    }

    public void setSelectedCatalog(Catalog selectedCatalog) {
        this.selectedCatalog = selectedCatalog;
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


