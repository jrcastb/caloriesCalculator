package com.example.caloriesCalculator.unit;

import com.example.caloriesCalculator.dto.IngredientResponseDTO;
import com.example.caloriesCalculator.repository.IngredientRepository;
import com.example.caloriesCalculator.service.DishService;
import com.example.caloriesCalculator.service.IDishService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Mock
    private IngredientRepository ingredientRepository;

    @InjectMocks
    DishService dishService;

    @Test
    @DisplayName("test for getFirst n ingredients")
    void shouldReturnFirstNIngredients(){
        //arrange - given
        List<IngredientResponseDTO> expected = getIngredients();
        //mocks - when
        Mockito.when(ingredientRepository.findFirst(2)).thenReturn(expected);
        //action - then
        Assertions.assertEquals(expected, dishService.getFirst(2));
    }

    private List<IngredientResponseDTO> getIngredients() {
        List<IngredientResponseDTO> ingredientResponseDTOS = new ArrayList<>();
        ingredientResponseDTOS.add(new IngredientResponseDTO("Ajos", 74));
        ingredientResponseDTOS.add(new IngredientResponseDTO("Alcachofas", 56));
        return ingredientResponseDTOS;
    }
}
