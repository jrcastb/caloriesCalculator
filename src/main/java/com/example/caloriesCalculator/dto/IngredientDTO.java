package com.example.caloriesCalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IngredientDTO {
    private String name;
    private Integer calories;
    private Integer weight;
}
