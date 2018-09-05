package com.example.demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
public class question2 {
    public String interests;
    public String favoriteActors;
    public String favoriteSingers;
    public String[] favoriteCountry;
    public String favoriteColor;
    public String favoriteNumber;

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getInterests() {
        return interests;
    }

    public String getFavoriteActors() {
        return favoriteActors;
    }

    public String getFavoriteSingers() {
        return favoriteSingers;
    }

    public String[] getFavoriteCountry() {
        return favoriteCountry;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public String getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteActors(String favoriteActors) {
        this.favoriteActors = favoriteActors;
    }

    public void setFavoriteSingers(String favoriteSingers) {
        this.favoriteSingers = favoriteSingers;
    }

    public void setFavoriteCountry(String[] favoriteCountry) {
        this.favoriteCountry = favoriteCountry;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    public void setFavoriteNumber(String favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    public void sendMessage(String message) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                message, null));
    }

    public String goToNextPage() {
        if (interests != null && interests.isEmpty()) {
            sendMessage("Enter Interests");
            return null;
        }

        if (favoriteActors != null && favoriteActors.isEmpty()) {
            sendMessage("Enter your favorite actor");
            return null;
        }
        if (favoriteColor != null && favoriteColor.isEmpty()) {
            sendMessage("Choose your favorite color");
            return null;
        }
        if (favoriteCountry != null && favoriteCountry.length == 0) {
            sendMessage("Choose your favorite country");
            return null;
        }
        if (favoriteSingers != null && favoriteSingers.isEmpty()) {
            sendMessage("Choose your favorite singer");
            return null;
        }
        if (favoriteNumber != null && favoriteNumber.isEmpty()) {
            sendMessage("Enter your favorite number");
            return null;

        }
        return "goQuestion3";

    }
}


