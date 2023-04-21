package com.example.caloriesCalculator.service;

import com.example.caloriesCalculator.dto.DishDTO;
import com.example.caloriesCalculator.dto.DishResponseDTO;
import com.example.caloriesCalculator.dto.IngredientDTO;
import com.example.caloriesCalculator.dto.IngredientResponseDTO;
import com.example.caloriesCalculator.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService implements IDishService {

    private final IngredientRepository repository;

    public DishService(IngredientRepository repository){
        this.repository = repository;
    }

    @Override
    public DishResponseDTO calculateCalories(DishDTO dish) {
        DishResponseDTO response = new DishResponseDTO(dish);
        Integer total = 0;
        Integer maxCalories = 0;

        for (IngredientDTO ingredient: response.getIngredients()) {
            calculateIngredientCalories(ingredient);
            total += ingredient.getCalories();
            if (ingredient.getCalories() > maxCalories){
                response.setCaloric(ingredient);
                maxCalories = ingredient.getCalories();
            }
        }
        response.setCalories(total);
        return response;
    }

    private void calculateIngredientCalories(IngredientDTO ingredient) {
        ingredient.setCalories(0);
        IngredientDTO ingredientFromRepository = repository.findIngredientByName(ingredient.getName());
        if (ingredientFromRepository != null){
            ingredient.setCalories((ingredient.getWeight() * ingredientFromRepository.getCalories())/100);
        }
    }

    @Override
    public List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes) {
        List<DishResponseDTO> response = new ArrayList<>();
        dishes.forEach(dish -> response.add(this.calculateCalories(dish)));
        return response;
    }

    @Override
    public List<IngredientResponseDTO> getFirst(Integer number) {
        //Conexión con la capa del repository
        return repository.findFirst(number);
    }
}
