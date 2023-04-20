package com.example.caloriesCalculator.service;

import com.example.caloriesCalculator.dto.DishDTO;
import com.example.caloriesCalculator.dto.DishResponseDTO;
import com.example.caloriesCalculator.dto.IngredientResponseDTO;

import java.util.List;

public interface IDishService {

    DishResponseDTO calculateCalories(DishDTO dish);

    List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes);

    List<IngredientResponseDTO> getFirst(Integer number);
}
