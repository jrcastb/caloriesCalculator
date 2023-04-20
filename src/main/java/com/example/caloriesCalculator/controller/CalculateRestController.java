package com.example.caloriesCalculator.controller;

import com.example.caloriesCalculator.dto.DishDTO;
import com.example.caloriesCalculator.dto.DishResponseDTO;
import com.example.caloriesCalculator.dto.IngredientResponseDTO;
import com.example.caloriesCalculator.service.IDishService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calories_calculator")
public class CalculateRestController {

    //Inyección de dependencias
    //suministrar objetos a la clase controller
    //IoC
    /**
     * Formas de hacer inyección de dependencias
     * 1. Constructor - Forma correcta
     * 2. @Autowired
     * 3. Método Set
     * */

    private final IDishService dishService;
    public CalculateRestController(IDishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping("/calculate")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public DishResponseDTO calculate(@RequestBody DishDTO dish){
        return dishService.calculateCalories(dish);
    }

    @PostMapping("/calculateAll")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<DishResponseDTO> calculateAll(@RequestBody List<DishDTO> dishes){
        return dishService.calculateAllCalories(dishes);
    }

    @GetMapping(value = "/get_first", params = {"number"})
    @ResponseStatus(HttpStatus.OK)
    public List<IngredientResponseDTO> getFirstFiveIngredients(@RequestParam(value = "number") Integer number){
        //TODO: conectar con la capa del servicio
        return null;
    }
}
