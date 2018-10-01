package com.example.demo.pages;

import com.example.demo.entities.Car;
import com.example.demo.repositories.CarRepository;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CarPage {
    @Inject
    private CarRepository carRepository;
    private String model;
    private int year;
    private String color;
    private String bodyType;
    private int carID;

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void saveCar() {
        Car car = new Car();
        car.setModel(model);
        car.setYear(year);
        car.setColor(color);
        car.setBodyType(bodyType);
        carRepository.save(car);
        sendMessage("Car saved");
    }

    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                message, null));
    }
}
