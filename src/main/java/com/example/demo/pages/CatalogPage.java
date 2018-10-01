package com.example.demo.pages;

import com.example.demo.repositories.CatalogRepository;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CatalogPage {
    @Inject
    private CatalogRepository catalogRepository;
    private String name;

    public CatalogRepository getCatalogRepository() {
        return catalogRepository;
    }

    public void setCatalogRepository(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
