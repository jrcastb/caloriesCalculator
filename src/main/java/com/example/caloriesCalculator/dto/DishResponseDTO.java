package com.example.caloriesCalculator.dto;

import lombok.Data;

@Data
public class DishResponseDTO extends DishDTO {

    private Integer calories;
    private IngredientDTO caloric; // nombre - calorias

    public DishResponseDTO(DishDTO dish){
        this.setIngredients(dish.getIngredients());
        this.setName(dish.getName());
    }
    public DishResponseDTO(){

    }

}
