package com.example.sistemaandroidtest.Model;

import java.util.Vector;

public class Meals {

    private String strMeal;
    private String strMealThumb;
    private String idMeal;
    private String strDrinkAlternate;
    private String strCategory;
    private String strArea;
    private String strInstructions;
    private String strTags;
    private String strYoutube;
    private Vector<String> strIngredient;
    private Vector<String> strMeasure;
    private String strSource;
    private String strImageSource;
    private String strCreativeCommonsConfirmed;
    private String dateModified;

    public Meals(){};

    public Meals(String strMeal, String strMealThumb, String idMeal, String strDrinkAlternate, String strCategory, String strArea) {
        this.strMeal = strMeal;
        this.strMealThumb = strMealThumb;
        this.idMeal = idMeal;
        this.strDrinkAlternate = strDrinkAlternate;
        this.strCategory = strCategory;
        this.strArea = strArea;
    }

    public Meals(String strMeal, String strMealThumb, String idMeal, String strDrinkAlternate, String strCategory, String strArea, String strInstructions, String strTags, String strYoutube, Vector<String> strIngredient, Vector<String> strMeasure, String strSource, String strImageSource, String strCreativeCommonsConfirmed, String dateModified) {
        this.strMeal = strMeal;
        this.strMealThumb = strMealThumb;
        this.idMeal = idMeal;
        this.strDrinkAlternate = strDrinkAlternate;
        this.strCategory = strCategory;
        this.strArea = strArea;
        this.strInstructions = strInstructions;
        this.strTags = strTags;
        this.strYoutube = strYoutube;
        this.strIngredient = strIngredient;
        this.strMeasure = strMeasure;
        this.strSource = strSource;
        this.strImageSource = strImageSource;
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
        this.dateModified = dateModified;
    }

    public String getStrMeal() {
        return strMeal;
    }

    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }

    public String getStrMealThumb() {
        return strMealThumb;
    }

    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }

    public String getIdMeal() {
        return idMeal;
    }

    public void setIdMeal(String idMeal) {
        this.idMeal = idMeal;
    }

    public String getStrDrinkAlternate() {
        return strDrinkAlternate;
    }

    public void setStrDrinkAlternate(String strDrinkAlternate) {
        this.strDrinkAlternate = strDrinkAlternate;
    }

    public String getStrCategory() {
        return strCategory;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public String getStrArea() {
        return strArea;
    }

    public void setStrArea(String strArea) {
        this.strArea = strArea;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public String getStrTags() {
        return strTags;
    }

    public void setStrTags(String strTags) {
        this.strTags = strTags;
    }

    public String getStrYoutube() {
        return strYoutube;
    }

    public void setStrYoutube(String strYoutube) {
        this.strYoutube = strYoutube;
    }

    public Vector<String> getStrIngredient() {
        return strIngredient;
    }

    public void setStrIngredient(Vector<String> strIngredient) {
        this.strIngredient = strIngredient;
    }

    public Vector<String> getStrMeasure() {
        return strMeasure;
    }

    public void setStrMeasure(Vector<String> strMeasure) {
        this.strMeasure = strMeasure;
    }

    public String getStrSource() {
        return strSource;
    }

    public void setStrSource(String strSource) {
        this.strSource = strSource;
    }

    public String getStrImageSource() {
        return strImageSource;
    }

    public void setStrImageSource(String strImageSource) {
        this.strImageSource = strImageSource;
    }

    public String getStrCreativeCommonsConfirmed() {
        return strCreativeCommonsConfirmed;
    }

    public void setStrCreativeCommonsConfirmed(String strCreativeCommonsConfirmed) {
        this.strCreativeCommonsConfirmed = strCreativeCommonsConfirmed;
    }

    public String getDateModified() {
        return dateModified;
    }

    public void setDateModified(String dateModified) {
        this.dateModified = dateModified;
    }
}
