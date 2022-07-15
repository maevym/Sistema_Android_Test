package com.example.sistemaandroidtest.Model;

public class Ingredients {
    private String ingredientsName;
    private String ingredientsMeasure;

    public Ingredients(String ingredientsName, String ingredientsMeasure) {
        this.ingredientsName = ingredientsName;
        this.ingredientsMeasure = ingredientsMeasure;
    }

    public String getIngredientsName() {
        return ingredientsName;
    }

    public void setIngredientsName(String ingredientsName) {
        this.ingredientsName = ingredientsName;
    }

    public String getIngredientsMeasure() {
        return ingredientsMeasure;
    }

    public void setIngredientsMeasure(String ingredientsMeasure) {
        this.ingredientsMeasure = ingredientsMeasure;
    }
}
