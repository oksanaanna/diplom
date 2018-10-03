package com.example.demo.pages;

import com.example.demo.entities.Catalog;
import com.example.demo.entities.Category;
import com.example.demo.entities.Medicine;
import com.example.demo.entities.Registration;
import com.example.demo.repositories.CatalogRepository;
import com.example.demo.repositories.MedicineRepository;
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
    @Inject
    private MedicineRepository medicineRepository;

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
        category.setDescription("After meal");
        category.setCatalog(catalog0);
        catalog0.getCategories().add(category);

        category = new Category();
        category.setCategoryName("Herbs");
        category.setDescription("After meal");
        category.setCatalog(catalog0);
        catalog0.getCategories().add(category);

        Catalog catalog1 = new Catalog();
        catalog1.setCategories(new ArrayList<>());
        catalog1.setName("Catalog1");

        category = new Category();
        category.setCategoryName("Herbs & Tincture");
        category.setDescription("15 minutes before meal");
        category.setCatalog(catalog1);
        catalog1.getCategories().add(category);

        category = new Category();
        category.setCategoryName("Herbs to relax");
        category.setDescription("2 hours before sleep");
        category.setCatalog(catalog1);
        catalog1.getCategories().add(category);



        Catalog catalog2 = new Catalog();
        catalog2.setCategories(new ArrayList<>());
        catalog2.setName("Catalog2");

        category = new Category();
        category.setCategoryName("Cosmetics for skin & hair");
        category.setDescription("Follow the instructions");
        category.setCatalog(catalog2);
        catalog2.getCategories().add(category);

        category = new Category();
        category.setCategoryName("Spices");
        category.setDescription("After meal before 12pm");
        category.setCatalog(catalog2);
        catalog2.getCategories().add(category);



        Catalog catalog3 = new Catalog();
        catalog3.setCategories(new ArrayList<>());
        catalog3.setName("Catalog3");

        category = new Category();
        category.setCategoryName("Children & Infants");
        category.setDescription("15 min after meal");
        category.setCatalog(catalog3);
        catalog3.getCategories().add(category);

        category = new Category();
        category.setCategoryName("Juniors");
        category.setDescription("After breakfast");
        category.setCatalog(catalog3);
        catalog3.getCategories().add(category);

        catalogRepository.save(catalog0);
        catalogRepository.save(catalog1);
        catalogRepository.save(catalog2);
        catalogRepository.save(catalog3);



        Medicine medicine = new Medicine();
        medicine.setConsistency("Natural");
        medicine.setName("Liv 52");
        medicine.setPrice(153);
        medicine.setDescription("Before meal 2 tablets twice daily");
        medicineRepository.save(medicine);

        medicine = new Medicine();
        medicine.setConsistency("Natural");
        medicine.setName("Liv 52 DS");
        medicine.setPrice(300);
        medicine.setDescription("Before meal 1 tablets twice daily");
        medicineRepository.save(medicine);

        medicine = new Medicine();
        medicine.setConsistency("Natural");
        medicine.setName("Krimol");
        medicine.setPrice(300);
        medicine.setDescription("5-10ml three times daily");
        medicineRepository.save(medicine);

        medicine = new Medicine();
        medicine.setConsistency("y8768768976987698769876");
        medicine.setName("K34543545345rimol");
        medicine.setPrice(300);
        medicine.setDescription("With21312312 meal twice daily");
        medicineRepository.save(medicine);

        medicine = new Medicine();
        medicine.setConsistency("Nat23423423423423ural");
        medicine.setName("Krimo234324234l");
        medicine.setPrice(300);
        medicine.setDescription("With m234234234eal twice daily");
        medicineRepository.save(medicine);

        medicine = new Medicine();
        medicine.setConsistency("Nat23423432ural");
        medicine.setName("Kri2343242mol");
        medicine.setPrice(300);
        medicine.setDescription("With meal 23423423234twice daily");
        medicineRepository.save(medicine);

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
