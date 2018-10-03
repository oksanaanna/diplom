package com.example.demo.pages;

import com.example.demo.repositories.CatalogRepository;
import com.example.demo.repositories.MedicineRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class MedicinePage {
    @Inject
    private MedicineRepository medicineRepository;
    private String name;
    private Long id;

    public MedicineRepository getMedicineRepository() {
        return medicineRepository;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}


