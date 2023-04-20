package com.example.caloriesCalculator.repository;

import com.example.caloriesCalculator.dto.IngredientDTO;
import com.example.caloriesCalculator.dto.IngredientResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientRepository {
    IngredientDTO findIngredientByName(String name);

    List<IngredientResponseDTO> findFirst(Integer number);
}
