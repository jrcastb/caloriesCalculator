package com.example.caloriesCalculator.service;

import com.example.caloriesCalculator.dto.DishDTO;
import com.example.caloriesCalculator.dto.DishResponseDTO;

import java.util.List;

public interface IDishService {

    DishResponseDTO calculateCalories(DishDTO dish);

    List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes);
}
