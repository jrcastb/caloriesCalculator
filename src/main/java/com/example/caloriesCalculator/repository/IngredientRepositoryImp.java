package com.example.caloriesCalculator.repository;


import com.example.caloriesCalculator.dto.IngredientDTO;
import com.example.caloriesCalculator.dto.IngredientResponseDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class IngredientRepositoryImp implements IngredientRepository {
    private final List<IngredientDTO> database;

    public IngredientRepositoryImp(){
        this.database = loadDatabase();
    }

    @Override
    public IngredientDTO findIngredientByName(String name) {

        Optional<IngredientDTO> firstIngredient = database.stream().filter(ingredientDTO -> ingredientDTO.getName().equals(name)).findFirst();
        IngredientDTO result = null;
        if (firstIngredient.isPresent())
            result = firstIngredient.get();
        return result;
    }

    @Override
    public List<IngredientResponseDTO> findFirst(Integer number) {
        //Consulta a la base de datos (archivo estatico) para traer los primeros "#number" ingredientes
        /*List<IngredientResponseDTO> responseDTOS = new ArrayList<>();
        for (IngredientDTO element: database) {
            responseDTOS.add(new IngredientResponseDTO(element.getName(), element.getCalories()));
        }*/
        List<IngredientDTO> ingredients = database.stream().limit(number).toList();
        return ingredients.stream().map(this::mapToResponse).toList();
    }

    private IngredientResponseDTO mapToResponse(IngredientDTO ingredient) {
        return IngredientResponseDTO.builder()
                .name(ingredient.getName())
                .calories(ingredient.getCalories())
                .build();
    }

    private List<IngredientDTO> loadDatabase() {
        //La carga del archivo
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
        //Se mapea el archivo a una estructura
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<IngredientDTO>> typeReference = new TypeReference<>() {};
        List<IngredientDTO> ingredientDTOS = null;
        try {
            ingredientDTOS = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }
        return ingredientDTOS;
    }
}
