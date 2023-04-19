package com.example.caloriesCalculator.repository;

import com.example.caloriesCalculator.dto.IngredientDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository {
    IngredientDTO findIngredientByName(String name);
}
