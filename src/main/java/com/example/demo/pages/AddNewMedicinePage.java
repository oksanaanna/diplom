package com.example.demo.pages;

import com.example.demo.entities.Medicine;
import com.example.demo.repositories.CatalogRepository;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.MedicineRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class AddNewMedicinePage {
    @Inject
    private CatalogRepository catalogRepository;

    @Inject
    private CategoryRepository categoryRepository;

    @Inject
    private MedicineRepository medicineRepository;

    private String name;
    private String description;
    private String consistency;
    private String price;

    public void saveNewMedicine() {
        Medicine medicine = new Medicine();
        medicine.setName(name);
        medicine.setConsistency(consistency);
        medicine.setDescription(description);
        medicine.setPrice(Integer.parseInt(price));

        medicineRepository.save(medicine);
    }

    public CatalogRepository getCatalogRepository() {
        return catalogRepository;
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }

    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public MedicineRepository getMedicineRepository() {
        return medicineRepository;
    }

    public void setMedicineRepository(MedicineRepository medicineRepository) {
        this.medicineRepository = medicineRepository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getConsistency() {
        return consistency;
    }

    public void setConsistency(String consistency) {
        this.consistency = consistency;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
