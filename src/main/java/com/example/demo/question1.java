package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class question1 {
    public String name;
    public String gender;
    public String hobby;
    public String[] occupation;
    public String country;
    public String ageRange;
    public String[] education;

    public String goToNextPage() {
        if (name != null && name.isEmpty()) {
            sendMessage("Enter Name");
            return null;
        }

        if (country != null && country.isEmpty()) {
            sendMessage("Enter Country");
            return null;
        }
        if (gender != null && gender.isEmpty()) {
            sendMessage("Choose gender");
            return null;
        }
        if (occupation != null && occupation.length == 0) {
            sendMessage("Choose occupation");
            return null;
        }
        if (ageRange != null && ageRange.isEmpty()){
            sendMessage("Choose age range");
            return null;
        } if(education != null && education.length == 0){
            sendMessage("Choose education");
            return null;
        }

        return "goquestion2";
    }

    public String getHobby() {
        return hobby;
    }

    public String[] getEducation() {
        return education;
    }

    public void setEducation(String[] education) {
        this.education = education;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(String ageRange) {
        this.ageRange = ageRange;
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                message, null));
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setOccupation(String[] occupation) {
        this.occupation = occupation;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String[] getOccupation() {
        return occupation;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}


