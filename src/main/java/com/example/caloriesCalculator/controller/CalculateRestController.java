package com.example.caloriesCalculator.controller;

import com.example.caloriesCalculator.dto.DishDTO;
import com.example.caloriesCalculator.dto.DishResponseDTO;
import com.example.caloriesCalculator.service.IDishService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public DishResponseDTO calculate(@RequestBody DishDTO dish){
        return dishService.calculateCalories(dish);
    }
}
