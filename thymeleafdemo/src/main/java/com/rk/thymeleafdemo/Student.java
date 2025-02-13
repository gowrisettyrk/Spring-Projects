package com.rk.thymeleafdemo;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Student {

    private String firstName;

    @NotNull(message="is required")
    @Size(min =1 , message = "is required")
    private  String lastName = "";
    private String country;
    private String favouriteLanguage;
    private String favouriteSystem;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavouriteLanguage() {
        return favouriteLanguage;
    }

    public void setFavouriteLanguage(String favouriteLanguage) {
        this.favouriteLanguage = favouriteLanguage;
    }

    public String getFavouriteSystem() {
        return favouriteSystem;
    }

    public void setFavouriteSystem(String favouriteSystem) {
        this.favouriteSystem = favouriteSystem;
    }
}
